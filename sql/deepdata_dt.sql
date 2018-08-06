DROP DATABASE IF EXISTS deepdata_dt;
CREATE DATABASE deepdata_dt;
\c deepdata_dt;

CREATE
	OR REPLACE FUNCTION update_changetimestamp_column () RETURNS TRIGGER AS $$ BEGIN
		NEW.uts = now();
	RETURN NEW;

END;
$$ LANGUAGE'plpgsql';
-- partition creator
CREATE
	OR REPLACE FUNCTION partition_rule ( TABLE_NAME TEXT, start_time TEXT, end_time TEXT, intv INTERVAL ) RETURNS TEXT AS $$ DECLARE
	partition_date TEXT;
partition_name TEXT;
partition_index_name TEXT;
partition_end_date TEXT;
BEGIN
		LOOP
		partition_date := to_char( DATE ( start_time ), 'YYYY_MM_DD' );
	partition_name := TABLE_NAME || '_' || partition_date;
	partition_index_name := 'idx_' || partition_name || '_ctime';
	partition_end_date := DATE ( start_time ) + intv;
	IF
		NOT EXISTS ( SELECT relname FROM pg_class WHERE relname = partition_name ) THEN
			RAISE NOTICE'A partition has been created %',
			partition_name;
		EXECUTE'CREATE TABLE ' || partition_name || ' PARTITION OF ' || TABLE_NAME || ' FOR VALUES FROM ( ''' || start_time || ''' ) TO ( ''' || partition_end_date || ''' );';
		RAISE NOTICE'A partition index has been created %',
		partition_index_name;
		EXECUTE'CREATE INDEX ' || partition_index_name || ' ON ' || partition_name || ' using btree (uts);';

	END IF;
	start_time := partition_end_date;
	EXIT
	WHEN DATE ( start_time ) > DATE ( end_time );

END LOOP;
RETURN NULL;

END;
$$ LANGUAGE plpgsql VOLATILE COST 100;
CREATE TABLE
IF
	NOT EXISTS images (
		ID bigserial NOT NULL,
		uts TIMESTAMP DEFAULT now(),
		image_id VARCHAR ( 36 ) NOT NULL CONSTRAINT images_pkey PRIMARY KEY,
		ts BIGINT DEFAULT 0 NOT NULL,
		repo_id VARCHAR ( 36 ) DEFAULT '' :: CHARACTER VARYING NOT NULL,
		sensor_id VARCHAR ( 36 ) DEFAULT '' :: CHARACTER VARYING NOT NULL,
		source_id VARCHAR ( 36 ) DEFAULT '' :: CHARACTER VARYING NOT NULL,
		task_id VARCHAR ( 36 ) DEFAULT '' :: CHARACTER VARYING NOT NULL,
		user_id VARCHAR ( 36 ) DEFAULT '' :: CHARACTER VARYING NOT NULL,
		TYPE SMALLINT DEFAULT 0 NOT NULL,
		image_uri VARCHAR ( 1024 ) DEFAULT '' :: CHARACTER VARYING NOT NULL,
		width INTEGER DEFAULT 0 NOT NULL,
		height INTEGER DEFAULT 0 NOT NULL,
		thumbnail_image_uri VARCHAR ( 1024 ) DEFAULT '' :: CHARACTER VARYING NOT NULL,
		thumbnail_width INTEGER DEFAULT 320 NOT NULL,
		thumbnail_height INTEGER DEFAULT 240 NOT NULL,
		status SMALLINT DEFAULT 1 NOT NULL
	);
CREATE INDEX
IF
	NOT EXISTS images_time_spacial_repo_idx ON images ( ts, repo_id );
CREATE INDEX
IF
	NOT EXISTS images_time_spacial_sensor_idx ON images ( ts, sensor_id );
DROP TRIGGER
IF
	EXISTS update_images_changetimestamp ON images;
CREATE TRIGGER update_images_changetimestamp BEFORE UPDATE ON images FOR EACH ROW
EXECUTE PROCEDURE update_changetimestamp_column ();
CREATE TABLE
IF
	NOT EXISTS vehicles (
		ID bigserial NOT NULL,
		uts TIMESTAMP DEFAULT now(),
		vehicle_id VARCHAR ( 36 ) NOT NULL,
		image_id VARCHAR ( 36 ) NOT NULL DEFAULT '',-- TODO
		ts BIGINT DEFAULT 0 NOT NULL,
		repo_id VARCHAR ( 36 ) DEFAULT '' :: CHARACTER VARYING NOT NULL,
		sensor_id VARCHAR ( 36 ) DEFAULT '' :: CHARACTER VARYING NOT NULL,
-- detail_id varchar(36) default ''::character varying not null,
    confidence REAL DEFAULT 0 NOT NULL,
    brand_id SMALLINT DEFAULT 0 NOT NULL,
    sub_brand_id SMALLINT DEFAULT 0 NOT NULL,
    model_year_id SMALLINT DEFAULT 0 NOT NULL,
    type_id SMALLINT DEFAULT 0 NOT NULL,
    color_id SMALLINT DEFAULT 0 NOT NULL,
    plate_text VARCHAR ( 10 ) DEFAULT '' :: CHARACTER VARYING NOT NULL,
    plate_type_id SMALLINT DEFAULT 0 NOT NULL,
    plate_color_id SMALLINT DEFAULT 0 NOT NULL,
    side SMALLINT DEFAULT 0 NOT NULL,
    SIZE SMALLINT DEFAULT 0 NOT NULL,
    speed SMALLINT DEFAULT 0 NOT NULL,
    direction SMALLINT DEFAULT 0 NOT NULL,
    symbol_int BIGINT DEFAULT 0 NOT NULL,
    symbol_str VARCHAR ( 15 ) DEFAULT '' :: CHARACTER VARYING NOT NULL,
    illegal_int BIGINT DEFAULT 0 NOT NULL,
    illegal_str VARCHAR ( 15 ) DEFAULT '' :: CHARACTER VARYING NOT NULL,
    coillegal_int BIGINT DEFAULT 0 NOT NULL,
    coillegal_str VARCHAR ( 15 ) DEFAULT '' :: CHARACTER VARYING NOT NULL,
    special_int BIGINT DEFAULT 0 NOT NULL,
    special_str VARCHAR ( 15 ) DEFAULT '' :: CHARACTER VARYING NOT NULL,
    driver_on_the_phone BOOLEAN DEFAULT FALSE NOT NULL,
    driver_without_belt BOOLEAN DEFAULT FALSE NOT NULL,
    codriver_without_belt BOOLEAN DEFAULT FALSE NOT NULL,
    CONTENT TEXT NOT NULL DEFAULT '',
    "lane" varchar(255) COLLATE "pg_catalog"."default" NOT NULL DEFAULT ''::character varying,
    face_id VARCHAR ( 256 ) NOT NULL DEFAULT '',
    oil_type VARCHAR ( 32 ) NOT NULL DEFAULT '',
    oil_amount float4 NOT NULL DEFAULT 0,
    engine_fuel SMALLINT DEFAULT 0 NOT NULL
  ) PARTITION BY RANGE ( ts );

comment on column vehicles.oil_type is '加油类型'
;
comment on column vehicles.oil_type is '加油量'
;
comment on column vehicles.engine_fuel is '1：汽油车，2：柴油车'
;

-- partition creator
CREATE
	OR REPLACE FUNCTION vehicle_partition_rule ( TABLE_NAME TEXT, start_time TEXT, end_time TEXT, intv INTERVAL ) RETURNS TEXT AS $$ DECLARE
	partition_date TEXT;
partition_name TEXT;
partition_index_name TEXT;
partition_end_date TEXT;
update_changetimestamp TEXT;
partition_id_idx TEXT;
partition_image_id_idx TEXT;
partition_time_spacial_repo_idx TEXT;
partition_time_spacial_sensor_idx TEXT;
partition_ref_index TEXT;
partition_start_ts BIGINT;
partition_end_ts BIGINT;
BEGIN
		LOOP
		partition_date := to_char( DATE ( start_time ), 'YYYY_MM_DD' );
	partition_name := TABLE_NAME || '_' || partition_date;
	partition_index_name := 'idx_' || partition_name || '_ctime';
	partition_end_date := DATE ( start_time ) + intv;
	RAISE NOTICE'date from % to %',
	start_time,
	partition_end_date;
	partition_start_ts := EXTRACT ( DAY FROM to_timestamp( start_time, 'YYYY-MM-DD HH24-MI-SS' ) - '1970-01-01 00:00:00' ) * 86400000 + EXTRACT ( HOUR FROM to_timestamp( start_time, 'YYYY-MM-DD HH24-MI-SS' ) - '1970-01-01 00:00:00' ) * 3600000;
	partition_end_ts := EXTRACT ( DAY FROM to_timestamp( partition_end_date, 'YYYY-MM-DD HH24-MI-SS' ) - '1970-01-01 00:00:00' ) * 86400000 + EXTRACT ( HOUR FROM to_timestamp( partition_end_date, 'YYYY-MM-DD HH24-MI-SS' ) - '1970-01-01 00:00:00' ) * 3600000;
	RAISE NOTICE'timestamp from % to %',
	partition_start_ts,
	partition_end_ts;
	IF
		NOT EXISTS ( SELECT relname FROM pg_class WHERE relname = partition_name ) THEN
			RAISE NOTICE'A partition has been created %',
			partition_name;
		EXECUTE'CREATE TABLE ' || partition_name || ' PARTITION OF ' || TABLE_NAME || ' FOR VALUES FROM ( ''' || partition_start_ts || ''' ) TO ( ''' || partition_end_ts || ''' );';
		RAISE NOTICE'A partition index has been created %',
		partition_index_name;
		EXECUTE'CREATE INDEX ' || partition_index_name || ' ON ' || partition_name || ' using btree (ts);';
		update_changetimestamp := 'update_' || partition_name || '_changetimestamp';
		EXECUTE'CREATE TRIGGER ' || update_changetimestamp || ' BEFORE UPDATE
		ON ' || partition_name || ' FOR EACH ROW EXECUTE PROCEDURE
		update_changetimestamp_column();';
		partition_id_idx := partition_name || '_id_idx';
		EXECUTE'CREATE INDEX ' || partition_id_idx || ' ON ' || partition_name || ' (vehicle_id);';
		partition_image_id_idx := partition_name || '_image_id_idx';
		EXECUTE'CREATE INDEX ' || partition_image_id_idx || ' ON ' || partition_name || ' (image_id);';
		partition_time_spacial_repo_idx := partition_name || '_time_spacial_repo_idx';
		EXECUTE'CREATE INDEX ' || partition_time_spacial_repo_idx || ' ON ' || partition_name || ' (ts, repo_id, plate_text);';
		partition_time_spacial_sensor_idx := partition_name || '_time_spacial_sensor_idx';
		EXECUTE'CREATE INDEX ' || partition_time_spacial_sensor_idx || ' ON ' || partition_name || ' (ts, sensor_id, plate_text);';
		partition_ref_index := partition_name || '_ref_index';
		EXECUTE'CREATE INDEX ' || partition_ref_index || ' ON ' || partition_name || ' (plate_text varchar_pattern_ops);';

	END IF;
	start_time := partition_end_date;
	EXIT
	WHEN DATE ( start_time ) > DATE ( end_time );

END LOOP;
RETURN NULL;

END;
$$ LANGUAGE plpgsql VOLATILE COST 100;
-- table_name=vehicles-- start_time=2018-03-22 00:00:01-- end_time=2019-03-22 23:59:59-- interval=7 days
SELECT
	vehicle_partition_rule ( 'vehicles', '2018-06-22 00:00:00', '2019-06-22 24:00:00', INTERVAL '7 days' );
-- 面部遮挡
CREATE TABLE facial_shaded_vehicles (
	ID bigserial PRIMARY KEY NOT NULL,
	vehicle_id VARCHAR ( 36 ) NOT NULL DEFAULT '',
	driver_shaded SMALLINT NOT NULL DEFAULT 0,
	codriver_shaded SMALLINT NOT NULL DEFAULT 0
);
CREATE INDEX facial_shaded_vehicles_idx ON facial_shaded_vehicles ( vehicle_id );
CREATE
	OR REPLACE VIEW facial_shaded_vehicle_view AS SELECT
	vehicles.*,
	facial_shaded_vehicles.driver_shaded,
	facial_shaded_vehicles.codriver_shaded
FROM
	facial_shaded_vehicles
	LEFT JOIN vehicles ON facial_shaded_vehicles.vehicle_id = vehicles.vehicle_id;
-- 危化品车单人驾驶
CREATE TABLE chemical_vehicles ( ID bigserial PRIMARY KEY NOT NULL, vehicle_id VARCHAR ( 36 ) NOT NULL DEFAULT '', passengers INT NOT NULL DEFAULT 1 );
CREATE INDEX chemical_vehicles_idx ON chemical_vehicles ( vehicle_id );
CREATE
	OR REPLACE VIEW chemical_vehicle_view AS SELECT
	vehicles.*,
	chemical_vehicles.passengers
FROM
	chemical_vehicles
	LEFT JOIN vehicles ON chemical_vehicles.vehicle_id = vehicles.vehicle_id
WHERE
	passengers < 2
	AND side = 1;
CREATE TABLE
IF
	NOT EXISTS pedestrians (
		ID bigserial NOT NULL,
		uts TIMESTAMP DEFAULT now(),
		pedestrian_id VARCHAR ( 36 ) NOT NULL,
		image_id VARCHAR ( 36 ) NOT NULL DEFAULT '',-- TODO
		ts BIGINT DEFAULT 0 NOT NULL,
		repo_id VARCHAR ( 36 ) DEFAULT '' :: CHARACTER VARYING NOT NULL,
		sensor_id VARCHAR ( 36 ) DEFAULT '' :: CHARACTER VARYING NOT NULL,
-- detail_id varchar(36) default ''::character varying not null,
		confidence REAL DEFAULT 0 NOT NULL,
		gender_id SMALLINT DEFAULT 0 NOT NULL,
		age_id SMALLINT DEFAULT 0 NOT NULL,
		nation_id SMALLINT DEFAULT 0 NOT NULL,
		SIZE SMALLINT DEFAULT 0 NOT NULL,
		speed SMALLINT DEFAULT 0 NOT NULL,
		direction SMALLINT DEFAULT 0 NOT NULL,
		desc_eye SMALLINT DEFAULT 0 NOT NULL,
		desc_head SMALLINT DEFAULT 0 NOT NULL,
		desc_mouth SMALLINT DEFAULT 0 NOT NULL,
		with_ss_bag SMALLINT DEFAULT 0 NOT NULL,
		with_backpack SMALLINT DEFAULT 0 NOT NULL,
		with_handbag SMALLINT DEFAULT 0 NOT NULL,
		with_hand_carry SMALLINT DEFAULT 0 NOT NULL,
		with_pram SMALLINT DEFAULT 0 NOT NULL,
		with_luggage SMALLINT DEFAULT 0 NOT NULL,
		attached_items BIGINT NOT NULL DEFAULT 0,
		upper_color SMALLINT NOT NULL DEFAULT 0,
		upper_texture SMALLINT NOT NULL DEFAULT 0,
		upper_style SMALLINT NOT NULL DEFAULT 0,
		lower_color SMALLINT NOT NULL DEFAULT 0,
		lower_texture SMALLINT NOT NULL DEFAULT 0,
		lower_style SMALLINT NOT NULL DEFAULT 0,
		CONTENT TEXT NOT NULL DEFAULT '',
		face_id VARCHAR ( 256 ) NOT NULL DEFAULT ''
	) PARTITION BY RANGE ( ts );
-- partition creator
CREATE
	OR REPLACE FUNCTION pedestrian_partition_rule ( TABLE_NAME TEXT, start_time TEXT, end_time TEXT, intv INTERVAL ) RETURNS TEXT AS $$ DECLARE
	partition_date TEXT;
partition_name TEXT;
partition_index_name TEXT;
partition_end_date TEXT;
update_changetimestamp TEXT;
partition_id_idx TEXT;
partition_image_id_idx TEXT;
partition_time_spacial_repo_idx TEXT;
partition_time_spacial_sensor_idx TEXT;
partition_start_ts BIGINT;
partition_end_ts BIGINT;
BEGIN
		LOOP
		partition_date := to_char( DATE ( start_time ), 'YYYY_MM_DD' );
	partition_name := TABLE_NAME || '_' || partition_date;
	partition_index_name := 'idx_' || partition_name || '_ctime';
	partition_end_date := DATE ( start_time ) + intv;
	RAISE NOTICE'date from % to %',
	start_time,
	partition_end_date;
	partition_start_ts := EXTRACT ( DAY FROM to_timestamp( start_time, 'YYYY-MM-DD HH24-MI-SS' ) - '1970-01-01 00:00:00' ) * 86400000 + EXTRACT ( HOUR FROM to_timestamp( start_time, 'YYYY-MM-DD HH24-MI-SS' ) - '1970-01-01 00:00:00' ) * 3600000;
	partition_end_ts := EXTRACT ( DAY FROM to_timestamp( partition_end_date, 'YYYY-MM-DD HH24-MI-SS' ) - '1970-01-01 00:00:00' ) * 86400000 + EXTRACT ( HOUR FROM to_timestamp( partition_end_date, 'YYYY-MM-DD HH24-MI-SS' ) - '1970-01-01 00:00:00' ) * 3600000;
	RAISE NOTICE'timestamp from % to %',
	partition_start_ts,
	partition_end_ts;
	IF
		NOT EXISTS ( SELECT relname FROM pg_class WHERE relname = partition_name ) THEN
			RAISE NOTICE'A partition has been created %',
			partition_name;
		EXECUTE'CREATE TABLE ' || partition_name || ' PARTITION OF ' || TABLE_NAME || ' FOR VALUES FROM ( ''' || partition_start_ts || ''' ) TO ( ''' || partition_end_ts || ''' );';
		RAISE NOTICE'A partition index has been created %',
		partition_index_name;
		EXECUTE'CREATE INDEX ' || partition_index_name || ' ON ' || partition_name || ' using btree (ts);';
		update_changetimestamp := 'update_' || partition_name || '_changetimestamp';
		EXECUTE'CREATE TRIGGER ' || update_changetimestamp || ' BEFORE UPDATE
    ON ' || partition_name || ' FOR EACH ROW EXECUTE PROCEDURE
    update_changetimestamp_column();';
		partition_id_idx := partition_name || '_id_idx';
		EXECUTE'CREATE INDEX ' || partition_id_idx || ' ON ' || partition_name || ' (pedestrian_id);';
		partition_image_id_idx := partition_name || '_image_id_idx';
		EXECUTE'CREATE INDEX ' || partition_image_id_idx || ' ON ' || partition_name || ' (image_id);';
		partition_time_spacial_repo_idx := partition_name || '_time_spacial_repo_idx';
		EXECUTE'CREATE INDEX ' || partition_time_spacial_repo_idx || ' ON ' || partition_name || ' (ts, repo_id);';
		partition_time_spacial_sensor_idx := partition_name || '_time_spacial_sensor_idx';
		EXECUTE'CREATE INDEX ' || partition_time_spacial_sensor_idx || ' ON ' || partition_name || ' (ts, sensor_id);';

	END IF;
	start_time := partition_end_date;
	EXIT
	WHEN DATE ( start_time ) > DATE ( end_time );

END LOOP;
RETURN NULL;

END;
$$ LANGUAGE plpgsql VOLATILE COST 100;
-- table_name=pedestrians-- start_time=2018-03-22 00:00:01-- end_time=2019-03-22 23:59:59-- interval=10 days
SELECT
	pedestrian_partition_rule ( 'pedestrians', '2018-06-22 00:00:00', '2019-06-22 24:00:00', INTERVAL '10 days' );
CREATE TABLE
IF
	NOT EXISTS nonmotors (
		ID bigserial NOT NULL,
		uts TIMESTAMP DEFAULT now(),
		motor_id VARCHAR ( 36 ) NOT NULL DEFAULT '',
		image_id VARCHAR ( 36 ) NOT NULL DEFAULT '',
		ts BIGINT DEFAULT 0 NOT NULL,
		repo_id VARCHAR ( 36 ) DEFAULT '' :: CHARACTER VARYING NOT NULL,
		sensor_id VARCHAR ( 36 ) DEFAULT '' :: CHARACTER VARYING NOT NULL,
-- detail_id varchar(36) default ''::character varying not null,
		confidence REAL DEFAULT 0 NOT NULL,
		motor_type SMALLINT NOT NULL DEFAULT 0,
-- motor_type_name varchar NOT NULL DEFAULT '',
		motor_gesture SMALLINT NOT NULL DEFAULT 0,
		motor_color_id SMALLINT NOT NULL DEFAULT 0,-- ADD 1.6.0+
		plate_text VARCHAR ( 10 ) NOT NULL DEFAULT '',
		plate_color_id SMALLINT NOT NULL DEFAULT 0,
		plate_type_id SMALLINT NOT NULL DEFAULT 0,
		speed SMALLINT NOT NULL DEFAULT 0,
		direction SMALLINT NOT NULL DEFAULT 0,
		SIZE SMALLINT DEFAULT 0 NOT NULL,
-- motor's CategoryAndFeature
		gender_id SMALLINT NOT NULL DEFAULT 0,
		age_id SMALLINT NOT NULL DEFAULT 0,
		nation_id SMALLINT NOT NULL DEFAULT 0,
		attached_items BIGINT NOT NULL DEFAULT 0,
		upper_color SMALLINT NOT NULL DEFAULT 0,
		upper_texture SMALLINT NOT NULL DEFAULT 0,
		upper_style SMALLINT NOT NULL DEFAULT 0,
		desc_eye SMALLINT NOT NULL DEFAULT 0,
		desc_head SMALLINT NOT NULL DEFAULT 0,
		desc_mouth SMALLINT NOT NULL DEFAULT 0,
		with_ss_bag SMALLINT NOT NULL DEFAULT 0,
		with_backpack SMALLINT NOT NULL DEFAULT 0,
		CONTENT TEXT NOT NULL DEFAULT '',
		"lane" VARCHAR ( 255 ) COLLATE "pg_catalog"."default" NOT NULL DEFAULT '' :: CHARACTER VARYING,
		face_id VARCHAR ( 256 ) NOT NULL DEFAULT ''
	) PARTITION BY RANGE ( ts );
-- partition creator
CREATE
	OR REPLACE FUNCTION nonmotor_partition_rule ( TABLE_NAME TEXT, start_time TEXT, end_time TEXT, intv INTERVAL ) RETURNS TEXT AS $$ DECLARE
	partition_date TEXT;
partition_name TEXT;
partition_index_name TEXT;
partition_end_date TEXT;
update_changetimestamp TEXT;
partition_id_idx TEXT;
partition_image_id_idx TEXT;
partition_time_spacial_repo_idx TEXT;
partition_time_spacial_sensor_idx TEXT;
partition_ref_index TEXT;
partition_start_ts BIGINT;
partition_end_ts BIGINT;
BEGIN
		LOOP
		partition_date := to_char( DATE ( start_time ), 'YYYY_MM_DD' );
	partition_name := TABLE_NAME || '_' || partition_date;
	partition_index_name := 'idx_' || partition_name || '_ctime';
	partition_end_date := DATE ( start_time ) + intv;
	RAISE NOTICE'date from % to %',
	start_time,
	partition_end_date;
	partition_start_ts := EXTRACT ( DAY FROM to_timestamp( start_time, 'YYYY-MM-DD HH24-MI-SS' ) - '1970-01-01 00:00:00' ) * 86400000 + EXTRACT ( HOUR FROM to_timestamp( start_time, 'YYYY-MM-DD HH24-MI-SS' ) - '1970-01-01 00:00:00' ) * 3600000;
	partition_end_ts := EXTRACT ( DAY FROM to_timestamp( partition_end_date, 'YYYY-MM-DD HH24-MI-SS' ) - '1970-01-01 00:00:00' ) * 86400000 + EXTRACT ( HOUR FROM to_timestamp( partition_end_date, 'YYYY-MM-DD HH24-MI-SS' ) - '1970-01-01 00:00:00' ) * 3600000;
	RAISE NOTICE'timestamp from % to %',
	partition_start_ts,
	partition_end_ts;
	IF
		NOT EXISTS ( SELECT relname FROM pg_class WHERE relname = partition_name ) THEN
			RAISE NOTICE'A partition has been created %',
			partition_name;
		EXECUTE'CREATE TABLE ' || partition_name || ' PARTITION OF ' || TABLE_NAME || ' FOR VALUES FROM ( ''' || partition_start_ts || ''' ) TO ( ''' || partition_end_ts || ''' );';
		RAISE NOTICE'A partition index has been created %',
		partition_index_name;
		EXECUTE'CREATE INDEX ' || partition_index_name || ' ON ' || partition_name || ' using btree (ts);';
		update_changetimestamp := 'update_' || partition_name || '_changetimestamp';
		EXECUTE'CREATE TRIGGER ' || update_changetimestamp || ' BEFORE UPDATE
    ON ' || partition_name || ' FOR EACH ROW EXECUTE PROCEDURE
    update_changetimestamp_column();';
		partition_id_idx := partition_name || '_id_idx';
		EXECUTE'CREATE INDEX ' || partition_id_idx || ' ON ' || partition_name || ' (motor_id);';
		partition_image_id_idx := partition_name || '_image_id_idx';
		EXECUTE'CREATE INDEX ' || partition_image_id_idx || ' ON ' || partition_name || ' (image_id);';
		partition_time_spacial_repo_idx := partition_name || '_time_spacial_repo_idx';
		EXECUTE'CREATE INDEX ' || partition_time_spacial_repo_idx || ' ON ' || partition_name || ' (ts, repo_id, plate_text);';
		partition_time_spacial_sensor_idx := partition_name || '_time_spacial_sensor_idx';
		EXECUTE'CREATE INDEX ' || partition_time_spacial_sensor_idx || ' ON ' || partition_name || ' (ts, sensor_id, plate_text);';
		partition_ref_index := partition_name || '_ref_index';
		EXECUTE'CREATE INDEX ' || partition_ref_index || ' ON ' || partition_name || ' (plate_text varchar_pattern_ops);';

	END IF;
	start_time := partition_end_date;
	EXIT
	WHEN DATE ( start_time ) > DATE ( end_time );

END LOOP;
RETURN NULL;

END;
$$ LANGUAGE plpgsql VOLATILE COST 100;
-- table_name=nonmotors-- start_time=2018-03-22 00:00:01-- end_time=2019-03-22 23:59:59-- interval=10 days
SELECT
	nonmotor_partition_rule ( 'nonmotors', '2018-06-22 00:00:00', '2019-06-22 24:00:00', INTERVAL '10 days' );
-- 非机动车非法载人
CREATE TABLE nonmotor_illegal_manned (
	ID bigserial PRIMARY KEY NOT NULL,
	ts BIGINT NOT NULL DEFAULT 0,
	repo_id VARCHAR ( 36 ) DEFAULT '' :: CHARACTER VARYING NOT NULL,
	sensor_id VARCHAR ( 36 ) DEFAULT '' :: CHARACTER VARYING NOT NULL,
	nonmotor_id VARCHAR ( 36 ) NOT NULL DEFAULT '',
	passenger_id VARCHAR ( 36 ) NOT NULL DEFAULT '',
	passengers INT NOT NULL DEFAULT 1
);
CREATE INDEX nonmotor_illegal_manned_time_spacial_idx ON nonmotor_illegal_manned ( ts, repo_id, sensor_id );
CREATE INDEX nonmotor_illegal_manned_idx ON nonmotor_illegal_manned ( nonmotor_id );
CREATE INDEX nonmotor_illegal_manned_p_idx ON nonmotor_illegal_manned ( passenger_id );
CREATE
	OR REPLACE VIEW nonmotor_illegal_manned_view AS SELECT
	nonmotors.*,
	nonmotor_illegal_manned.passengers
FROM
	nonmotor_illegal_manned
	LEFT JOIN nonmotors ON nonmotor_illegal_manned.nonmotor_id = nonmotors.motor_id
WHERE
	passengers > 1;
-- 摩托车未戴头盔
CREATE TABLE nonmotor_without_helmet (
	ID bigserial PRIMARY KEY NOT NULL,
	ts BIGINT NOT NULL DEFAULT 0,
	repo_id VARCHAR ( 36 ) DEFAULT '' :: CHARACTER VARYING NOT NULL,
	sensor_id VARCHAR ( 36 ) DEFAULT '' :: CHARACTER VARYING NOT NULL,
	nonmotor_id VARCHAR ( 36 ) NOT NULL DEFAULT '',
	passenger_id VARCHAR ( 36 ) NOT NULL DEFAULT ''
);
CREATE INDEX nonmotor_without_helmet_time_spacial_idx ON nonmotor_without_helmet ( ts, repo_id );
CREATE INDEX nonmotor_without_helmet_time_spacial_str_idx ON nonmotor_without_helmet ( ts, sensor_id );
CREATE INDEX nonmotor_without_helmet_idx ON nonmotor_without_helmet ( nonmotor_id );
CREATE INDEX nonmotor_without_helmet_p_idx ON nonmotor_without_helmet ( passenger_id );
CREATE TABLE
IF
	NOT EXISTS alarm_rule (
		ID bigserial NOT NULL CONSTRAINT alarm_rule_pkey PRIMARY KEY,
		uts TIMESTAMP DEFAULT now(),
		RULE TEXT DEFAULT '' :: TEXT NOT NULL,
		rule_type SMALLINT DEFAULT 0 NOT NULL,
		case_type SMALLINT DEFAULT 0 NOT NULL,
		dead_time BIGINT DEFAULT 0 NOT NULL,
		status SMALLINT DEFAULT 1 NOT NULL
	);
DROP TRIGGER
IF
	EXISTS update_alarm_rule_changetimestamp ON alarm_rule;
CREATE TRIGGER update_alarm_rule_changetimestamp BEFORE UPDATE ON alarm_rule FOR EACH ROW
EXECUTE PROCEDURE update_changetimestamp_column ();
CREATE TABLE
IF
	NOT EXISTS alarm_event (
		ID bigserial NOT NULL CONSTRAINT alarm_event_pkey PRIMARY KEY,
		ts BIGINT DEFAULT 0 NOT NULL,
		rule_type SMALLINT DEFAULT 0 NOT NULL,
		case_type SMALLINT DEFAULT 0 NOT NULL,
		sensor_id VARCHAR ( 36 ) DEFAULT '' :: CHARACTER VARYING NOT NULL,
		plate_text VARCHAR ( 10 ) DEFAULT '' :: CHARACTER VARYING NOT NULL,
		rule_id bigserial NOT NULL,
		vehicle_id VARCHAR ( 36 ) DEFAULT '' :: CHARACTER VARYING NOT NULL
	);
CREATE INDEX
IF
	NOT EXISTS alarm_event_time_spacial_idx ON alarm_event ( ts, sensor_id );
CREATE INDEX
IF
	NOT EXISTS alarm_event_idx_ruleid ON alarm_event ( rule_id );
CREATE INDEX
IF
	NOT EXISTS alarm_event_vehicle_id_idx ON alarm_event ( vehicle_id );
CREATE TABLE
IF
	NOT EXISTS counter (
		DAY BIGINT DEFAULT 0 NOT NULL CONSTRAINT counter_pkey PRIMARY KEY,
		uts TIMESTAMP DEFAULT now(),
		image_count INTEGER DEFAULT 0 NOT NULL,
		vehicle_count INTEGER DEFAULT 0 NOT NULL,
		nonmotor_count INTEGER DEFAULT 0 NOT NULL,
		pedestrian_count INTEGER DEFAULT 0 NOT NULL
	);
DROP TRIGGER
IF
	EXISTS update_counter_changetimestamp ON counter;
CREATE TRIGGER update_counter_changetimestamp BEFORE UPDATE ON counter FOR EACH ROW
EXECUTE PROCEDURE update_changetimestamp_column ();
CREATE TABLE
IF
	NOT EXISTS vehicle_invalid_plate (
		ID bigserial NOT NULL CONSTRAINT vehicle_invalid_plate_pkey PRIMARY KEY,
		uts TIMESTAMP DEFAULT now(),
		vehicle_id VARCHAR ( 36 ) DEFAULT '' :: CHARACTER VARYING NOT NULL,
		invalid_type SMALLINT DEFAULT 0 NOT NULL
	);
CREATE INDEX
IF
	NOT EXISTS vehicle_invalid_id_idx ON vehicle_invalid_plate ( vehicle_id );
DROP TRIGGER
IF
	EXISTS update_vehicle_invalid_plate_changetimestamp ON vehicle_invalid_plate;
CREATE TRIGGER update_vehicle_invalid_plate_changetimestamp BEFORE UPDATE ON vehicle_invalid_plate FOR EACH ROW
EXECUTE PROCEDURE update_changetimestamp_column ();
CREATE TABLE
IF
	NOT EXISTS vehicle_last_appear (
		ID bigserial NOT NULL CONSTRAINT vehicle_last_appear_pkey PRIMARY KEY,
		uts TIMESTAMP DEFAULT now(),
		plate_text VARCHAR ( 10 ) DEFAULT '' :: CHARACTER VARYING NOT NULL,
		ts BIGINT DEFAULT 0 NOT NULL
	);
CREATE UNIQUE INDEX
IF
	NOT EXISTS vehicle_last_appear_ref_index ON vehicle_last_appear ( plate_text );
DROP TRIGGER
IF
	EXISTS update_vehicle_last_appear_changetimestamp ON vehicle_last_appear;
CREATE TRIGGER update_vehicle_last_appear_changetimestamp BEFORE UPDATE ON vehicle_last_appear FOR EACH ROW
EXECUTE PROCEDURE update_changetimestamp_column ();
CREATE TABLE
IF
	NOT EXISTS vehicle_new_comer (
		ID bigserial NOT NULL CONSTRAINT vehicle_new_comer_pkey PRIMARY KEY,
		uts TIMESTAMP DEFAULT now(),
		vehicle_id VARCHAR ( 36 ) DEFAULT '' :: CHARACTER VARYING NOT NULL,
		freeze_day SMALLINT DEFAULT 0 NOT NULL
	);
CREATE INDEX
IF
	NOT EXISTS vehicle_new_id_idx ON vehicle_new_comer ( vehicle_id );
DROP TRIGGER
IF
	EXISTS update_vehicle_new_comer_changetimestamp ON vehicle_new_comer;
CREATE TRIGGER update_vehicle_new_comer_changetimestamp BEFORE UPDATE ON vehicle_new_comer FOR EACH ROW
EXECUTE PROCEDURE update_changetimestamp_column ();
CREATE TABLE
IF
	NOT EXISTS vehicle_statistics (
		ID bigserial NOT NULL CONSTRAINT vehicle_statistics_pkey PRIMARY KEY,
		uts TIMESTAMP DEFAULT now(),
		sensor_id VARCHAR ( 36 ) DEFAULT '' :: CHARACTER VARYING NOT NULL,
		HOUR INTEGER DEFAULT 0 NOT NULL,
		plate_text VARCHAR ( 10 ) DEFAULT '' :: CHARACTER VARYING NOT NULL,
		COUNT INTEGER DEFAULT 0 NOT NULL
	);
CREATE INDEX
IF
	NOT EXISTS vehicle_statistics_idx ON vehicle_statistics ( sensor_id, HOUR, plate_text );
CREATE INDEX
IF
	NOT EXISTS vehicle_statistics_ref_index ON vehicle_statistics ( plate_text );
DROP TRIGGER
IF
	EXISTS update_vehicle_statistics_changetimestamp ON vehicle_statistics;
CREATE TRIGGER update_vehicle_statistics_changetimestamp BEFORE UPDATE ON vehicle_statistics FOR EACH ROW
EXECUTE PROCEDURE update_changetimestamp_column ();
CREATE TABLE
IF
	NOT EXISTS cgs (
		ID bigserial NOT NULL CONSTRAINT cgs_pkey PRIMARY KEY,
		uts TIMESTAMP DEFAULT now(),
		plate_text VARCHAR ( 10 ) DEFAULT '' :: CHARACTER VARYING NOT NULL,
		retire_date VARCHAR DEFAULT '' :: CHARACTER VARYING NOT NULL,
		model_name VARCHAR ( 10 ) DEFAULT '' :: CHARACTER VARYING NOT NULL,
		brand_name VARCHAR ( 10 ) DEFAULT '' :: CHARACTER VARYING NOT NULL,
		carry_capacity SMALLINT DEFAULT 0 NOT NULL,
		email_address VARCHAR DEFAULT '' :: CHARACTER VARYING NOT NULL,
		plate_type VARCHAR ( 2 ) DEFAULT '' :: CHARACTER VARYING NOT NULL,
		vehicle_status VARCHAR DEFAULT '' :: CHARACTER VARYING NOT NULL,
		address VARCHAR DEFAULT '' :: CHARACTER VARYING NOT NULL,
		contact_detail VARCHAR DEFAULT '' :: CHARACTER VARYING NOT NULL,
		engine_type VARCHAR DEFAULT '' :: CHARACTER VARYING NOT NULL,
		engine_number VARCHAR DEFAULT '' :: CHARACTER VARYING NOT NULL,
		vehicle_color VARCHAR DEFAULT '' :: CHARACTER VARYING NOT NULL,
		phone_number VARCHAR DEFAULT '' :: CHARACTER VARYING NOT NULL,
		manufacture_date VARCHAR DEFAULT '' :: CHARACTER VARYING NOT NULL,
		record_date VARCHAR DEFAULT '' :: CHARACTER VARYING NOT NULL,
		load_capacity REAL DEFAULT 0 NOT NULL,
		vehicle_type VARCHAR ( 2 ) DEFAULT '' :: CHARACTER VARYING NOT NULL,
		id_number VARCHAR DEFAULT '' :: CHARACTER VARYING NOT NULL,
		OWNER VARCHAR DEFAULT '' :: CHARACTER VARYING NOT NULL,
		detail_address VARCHAR DEFAULT '' :: CHARACTER VARYING NOT NULL,
		POWER REAL DEFAULT 0 NOT NULL,
		use_nature VARCHAR DEFAULT '' :: CHARACTER VARYING NOT NULL,
		vehicle_id_number VARCHAR DEFAULT '' :: CHARACTER VARYING NOT NULL,
		displacement REAL DEFAULT 0 NOT NULL
	);
CREATE UNIQUE INDEX
IF
	NOT EXISTS cgs_vehicle_plate_idx ON cgs ( plate_text );
CREATE INDEX
IF
	NOT EXISTS cgs_vehicle_id_idx ON cgs ( ID );
DROP TRIGGER
IF
	EXISTS update_cgs_changetimestamp ON cgs;
CREATE TRIGGER update_cgs_changetimestamp BEFORE UPDATE ON cgs FOR EACH ROW
EXECUTE PROCEDURE update_changetimestamp_column ();
CREATE TABLE
IF
	NOT EXISTS faces (
		ID bigserial NOT NULL,
		uts TIMESTAMP WITHOUT TIME ZONE DEFAULT now() NOT NULL,
		ts BIGINT DEFAULT 0 NOT NULL,
		image_id VARCHAR ( 36 ) NOT NULL DEFAULT '',
		repo_id CHARACTER VARYING ( 36 ) NOT NULL,
		sensor_id CHARACTER VARYING ( 36 ) NOT NULL,
		face_id CHARACTER VARYING ( 36 ) NOT NULL,
		face_reid CHARACTER VARYING ( 1024 ) DEFAULT '' :: CHARACTER VARYING NOT NULL,
		confidence REAL DEFAULT 0 NOT NULL,
		gender_id SMALLINT DEFAULT 0,
		gender_confidence REAL DEFAULT 0,
		age_id SMALLINT DEFAULT 0,
		age_confidence REAL DEFAULT 0,
		nation_id SMALLINT DEFAULT 0,
		nation_confidence REAL DEFAULT 0,
		glass_id SMALLINT DEFAULT 0,
		glass_confidence REAL DEFAULT 0,
		mask_id SMALLINT DEFAULT 0 NOT NULL,
		mask_confidence REAL DEFAULT 0 NOT NULL,
		hat_id SMALLINT DEFAULT 0 NOT NULL,
		hat_confidence REAL DEFAULT 0 NOT NULL,
		halmet_id SMALLINT DEFAULT 0 NOT NULL,
		halmet_confidence REAL DEFAULT 0 NOT NULL,
		image_type SMALLINT DEFAULT 0 NOT NULL,
		image_uri CHARACTER VARYING ( 256 ) DEFAULT '' :: CHARACTER VARYING,
		thumbnail_image_uri CHARACTER VARYING ( 256 ) DEFAULT '' :: CHARACTER VARYING,
		cutboard_image_uri CHARACTER VARYING ( 256 ) DEFAULT '' :: CHARACTER VARYING,
		CONTENT TEXT DEFAULT '' :: TEXT,
		is_warned SMALLINT DEFAULT 0,
		status SMALLINT DEFAULT 1 NOT NULL,
		owner_type SMALLINT DEFAULT 0 NOT NULL,
		owner_id VARCHAR ( 256 ) NOT NULL DEFAULT ''
	);
COMMENT ON COLUMN faces.owner_type IS '人脸所属人类型 1:机动车，2:行人，3:非机动车，4:人脸';
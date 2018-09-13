package com.sensenets.sinopec.kafka.core;

import com.google.common.base.Optional;

public enum DataCategory {
    UNKNOWN("unknown", 0),
    ALL("all", 1),
    VEHICLE("vehicle", 2),
    HUMAN_FACE("human_face", 3),
    HUMAN_BODY("human_body", 4),
    NONMOTOR("nonmotor", 5),
    GAS_STATION("gas_station", 6);

    private String name;
    private int code;

    private DataCategory(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }

    public static Optional<DataCategory> parseByCode(String strCode) {
        int _code = 0;

        try {
            _code = Integer.parseInt(strCode);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return parseByCode(_code);
    }

    public static Optional<DataCategory> parseByCode(int _code) {
    	Optional<DataCategory> categoryPossible = Optional.absent();
        DataCategory[] values = DataCategory.values();

        for (DataCategory value : values) {
        	if (value.getCode() == _code) {
        		categoryPossible = Optional.of(value);
        		break;
        	}
        }
        
        return categoryPossible;
    }

    public static Optional<DataCategory> parseByName(String _name) {
    	Optional<DataCategory> categoryPossible = Optional.absent();
        DataCategory[] values = DataCategory.values();

        for (DataCategory value : values) {
        	if (value.getName().equals(_name)) {
        		categoryPossible = Optional.of(value);
        	}
        }
        
        return categoryPossible;
    }
}
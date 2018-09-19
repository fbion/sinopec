package com.sensenets.sinopec.kafka.common;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sensenets.sinopec.kafka.buffer.gas.VehicleQueueSourceData;
import com.sensenets.sinopec.kafka.core.DataCategory;
import com.sensenets.sinopec.kafka.core.ExchangeMessageHandler;
import com.sensenets.sinopec.kafka.core.KafkaMessageHandler;
import com.sensenets.sinopec.kafka.core.KafkaRawMessage;
import com.sensenets.sinopec.kafka.core.MessageHandlerError;
import com.sensenets.sinopec.kafka.core.MessageHandlerException;

import dg.model.PimpRecObj;

public class KafkaReceiveHandler implements KafkaMessageHandler {

	private static final Logger log = LoggerFactory.getLogger(KafkaReceiveHandler.class);

	private final ExchangeMessageHandler exchangeHandler;
	private final ReceiveDataConverter converter;

	public KafkaReceiveHandler(ExchangeMessageHandler exchangeHandler, ReceiveDataConverter converter) {
		this.exchangeHandler = exchangeHandler;
		this.converter = converter;
	}

	@Override
	public void handle(KafkaRawMessage message) throws MessageHandlerException, MessageHandlerError {
		DataCategory dataCategory = DataCategory.GAS_STATION;
		VehicleQueueSourceData transformed = null;
		try {
			PimpRecObj.PetrolStationObj stationObj = PimpRecObj.PetrolStationObj.parseFrom(message.getMessage());
			transformed = converter.transformObj(stationObj);
			if (transformed==null) {
				log.debug("data transformed is null.type:{}", dataCategory);
				return;
			}
			this.exchangeHandler.push(dataCategory, transformed);
		} catch (Exception e) {
			log.error(String.format("%s execute error.", dataCategory.getName()), e);
		}
	}

}

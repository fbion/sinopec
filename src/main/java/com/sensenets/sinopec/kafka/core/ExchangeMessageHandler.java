package com.sensenets.sinopec.kafka.core;

import java.nio.ByteBuffer;
import java.util.List;

import com.sensenets.sinopec.kafka.buffer.gas.VehicleQueueSourceData;

public abstract class ExchangeMessageHandler {
    
    public abstract void push(DataCategory var1, ByteBuffer var2) throws Exception;

    public abstract void push(DataCategory var1, List<ByteBuffer> var2) throws Exception;
    
    public abstract void  push(DataCategory var1, VehicleQueueSourceData transformed) throws Exception;
}
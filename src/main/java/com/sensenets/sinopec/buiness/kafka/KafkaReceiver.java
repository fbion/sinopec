package com.sensenets.sinopec.buiness.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.google.protobuf.InvalidProtocolBufferException;

import dg.model.PimpCouponUsed;
import dg.model.PimpNonOilTrade;
import dg.model.PimpObject;
import dg.model.PimpOilEvent;
import dg.model.PimpOilTrade;
import dg.model.PimpTicketOpen;
import lombok.extern.slf4j.Slf4j;


/**
  * @ClassName: KafkaConsumer
  * @Description: 消息消费者
  * @author think
  * @date 2018年8月10日 下午2:38:36
  *
  */
@Component
@Slf4j
public class KafkaReceiver {

    
    @KafkaListener(topics = {"${kafka.faceTopic}"})
    public void processFaceMsg(PimpObject.ObjectPublish content) {
        PimpObject.ObjectPublish obj  = content;
        switch (obj.getObjectTypeValue()){
        case PimpObject.ObjectType.Object_Type_Oil_Event_VALUE:
            try {
                PimpOilEvent.OilEventWithPlate event =  PimpOilEvent.OilEventWithPlate.parseFrom(obj.getBinData());
                log.info("接收到提挂枪消息:" + event.getOilGunId());
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
            }
            break;
        case PimpObject.ObjectType.Object_Type_Non_Oil_Trade_VALUE:
            try {
                PimpNonOilTrade.NonOilTradePublish event =  PimpNonOilTrade.NonOilTradePublish.parseFrom(obj.getBinData());
                log.info("接收到非油品消息:" + event.getOrderNo()+" event:"+event.getAdditionalInfosMap().get("name"));
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
            }
            break;
           
        case PimpObject.ObjectType.Object_Type_Oil_Trade_VALUE:
                try {
                    PimpOilTrade.OilTradePublish event =  PimpOilTrade.OilTradePublish.parseFrom(obj.getBinData());
                    log.info("接收到油品交易消息:" + event.getOilTypeNum());
                } catch (InvalidProtocolBufferException e) {
                    e.printStackTrace();
                }
                break;
        
        case PimpObject.ObjectType.Object_Type_Ticket_Open_VALUE:
            try {
                PimpTicketOpen.TicketOpenPublish event =  PimpTicketOpen.TicketOpenPublish.parseFrom(obj.getBinData());
                log.info("接收到开票消息:" + event.getEventType());
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
            }
            break;
        case PimpObject.ObjectType.Object_Type_Coupon_Used_VALUE:
            try {
                PimpCouponUsed.CouponUsedPublish event =  PimpCouponUsed.CouponUsedPublish.parseFrom(obj.getBinData());
                log.info("接收到扫卷消息:" + event.getEventType());
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
            }
            break;
        default:
                    break;
        }


    }
    

    @KafkaListener(topics = {"${kafka.vehicleTopic}"})
    public void processVehicleMsg(String content) {
        log.info("接收车消息：" + content);
    }
}

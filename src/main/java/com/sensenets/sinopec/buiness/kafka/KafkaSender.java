package com.sensenets.sinopec.buiness.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import dg.model.PimpCouponUsed;
import dg.model.PimpNonOilTrade;
import dg.model.PimpObject;
import dg.model.PimpOilEvent;
import dg.model.PimpOilTrade;
import dg.model.PimpTicketOpen;

/**
 * @ClassName: kafkaProducer
 * @Description: 消息生产者
 * @author think
 * @date 2018年8月10日 下午2:39:00
 *
 */
@Component
public class KafkaSender {
    @Autowired
    private KafkaTemplate<Long,PimpObject.ObjectPublish> kafkaTemplate;
    
    @Value("${kafka.faceTopic}")
    private String faceTopic;

    public void sendPimpObject(final String topic,final PimpObject.ObjectPublish objectPublish){
        if(objectPublish!=null){
            kafkaTemplate.send(topic,objectPublish);
        }
    }
    
    public <T> PimpObject.ObjectPublish generatePublishObj(PimpObject.ObjectType type,PimpObjParams<T>  params){
        PimpObject.ObjectPublish objectPublish = null;
        switch(type){
        // 未知
        case Object_Type_Unknown:
            objectPublish  =  PimpObject.ObjectPublish.newBuilder()
            .setObjectType(PimpObject.ObjectType.Object_Type_Unknown)
            .build();
            break;
        // 提挂枪对象
        case Object_Type_Oil_Event:
            PimpOilEvent.OilEvent  oilEvent = (PimpOilEvent.OilEvent)params.getObj();
            objectPublish  =  PimpObject.ObjectPublish.newBuilder()
            .setObjectType(PimpObject.ObjectType.Object_Type_Oil_Event)
            .setBinData(oilEvent.toByteString())
            .build();
            break;
        // 油品交易对象
        case Object_Type_Oil_Trade:
            PimpOilTrade.OilTrade  oilTrade = (PimpOilTrade.OilTrade)params.getObj();
            objectPublish  =  PimpObject.ObjectPublish.newBuilder()
            .setObjectType(PimpObject.ObjectType.Object_Type_Oil_Trade)
            .setBinData(oilTrade.toByteString())
            .build();
        
        // 非油品交易对象
        case Object_Type_Non_Oil_Trade :
            PimpNonOilTrade.NonOilTrade  nonOilTrade = (PimpNonOilTrade.NonOilTrade)params.getObj();
            objectPublish =  PimpObject.ObjectPublish.newBuilder()
            .setObjectType(PimpObject.ObjectType.Object_Type_Non_Oil_Trade)
            .setBinData(nonOilTrade.toByteString())
            .build();
        // 开票
        case Object_Type_Ticket_Open :
            PimpTicketOpen.TicketOpen  ticketOpen = (PimpTicketOpen.TicketOpen)params.getObj();
            objectPublish =  PimpObject.ObjectPublish.newBuilder()
            .setObjectType(PimpObject.ObjectType.Object_Type_Ticket_Open)
            .setBinData(ticketOpen.toByteString())
            .build();
        // 优惠券
        case Object_Type_Coupon_Used :
            PimpCouponUsed.CouponUsed  couponUsed = (PimpCouponUsed.CouponUsed)params.getObj();
            objectPublish =  PimpObject.ObjectPublish.newBuilder()
            .setObjectType(PimpObject.ObjectType.Object_Type_Coupon_Used)
            .setBinData(couponUsed.toByteString())
            .build();
        // 不能识别
        case UNRECOGNIZED:
            objectPublish  =  PimpObject.ObjectPublish.newBuilder()
            .setObjectType(PimpObject.ObjectType.UNRECOGNIZED)
            .build();
            break;
        }
        return  objectPublish;
    } 
    
    
}

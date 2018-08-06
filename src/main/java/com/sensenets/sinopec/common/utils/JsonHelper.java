package com.sensenets.sinopec.common.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * 
 * @author summer
 *
 */
public class JsonHelper {

    private static Gson gson = new GsonBuilder().create();

    /**
     * @Title: toJson
     * @Description: toJson
     * @param obj
     *            Object
     * @return String
     */
    public static String toJson(Object obj) {
        String result = com.alibaba.fastjson.JSON.toJSONString(obj, SerializerFeature.DisableCircularReferenceDetect, SerializerFeature.WriteDateUseDateFormat,
                SerializerFeature.WriteNullNumberAsZero, SerializerFeature.WriteNullStringAsEmpty);
        if (StringUtils.isEmpty(result) || StringUtils.equals(result, "{}")) {
            result = "";
        }
        return result;
    }

    /**
     * @Title: toJsonByteArray
     * @Description: toJsonByteArray
     * @param obj
     *            Object
     * @return byte[]
     */
    public static byte[] toJsonByteArray(Object obj) {
        byte[] result = com.alibaba.fastjson.JSON.toJSONBytes(obj, SerializerFeature.DisableCircularReferenceDetect, SerializerFeature.WriteDateUseDateFormat,
                SerializerFeature.WriteNullNumberAsZero, SerializerFeature.WriteNullStringAsEmpty);
        return result;
    }

    /**
     * @Title: fromJson2ListByClass
     * @Description: fromJson2ListByClass
     * @param json
     *            String
     * @param type
     *            Class<T>
     * @param <T>
     *            <T>
     * @return List
     */
    public static <T> List<T> fromJson2ListByClass(String json, Class<T> type) {
        if (StringUtils.isEmpty(json) || StringUtils.equals(json, "{}")) {
            return null;
        }

        return com.alibaba.fastjson.JSONArray.parseArray(json, type);
    }

    public static <T> ArrayList<T> fromJsonList(String json, Class<T> cls) {
        ArrayList<T> mList = new ArrayList<T>();
        JsonArray array = new JsonParser().parse(json).getAsJsonArray();
        for (final JsonElement elem : array) {
            mList.add(gson.fromJson(elem, cls));
        }
        return mList;
    }

    public static <T> T fromJson(String json, Class<T> cls) {
        return gson.fromJson(json, cls);
    }

    /**
     * @Title: fromJsonByT
     * @Description: fromJsonByT
     * @param json
     *            String
     * @param type
     *            Class<T>
     * @param <T>
     *            <T>
     * @return T
     */
    public static <T> T fromJsonByT(String json, Class<T> type) {
        if (StringUtils.isEmpty(json) || StringUtils.equals(json, "{}")) {
            return null;
        }
        return com.alibaba.fastjson.JSON.parseObject(json, type);
    }

    /**
     * @Title: fromJsonByClass
     * @Description: fromJsonByClass
     * @param json
     *            String
     * @param type
     *            Class<?>
     * @return Object
     */
    public static Object fromJsonByClass(String json, Class<?> type) {
        if (StringUtils.isEmpty(json) || StringUtils.equals(json, "{}")) {
            return null;
        }
        return com.alibaba.fastjson.JSON.parseObject(json, type);
    }

    /**
     * @Title: fromJson
     * @Description: fromJson
     * @param json
     *            String
     * @return Object
     */
    public static Object fromJson(String json) {
        if (StringUtils.isEmpty(json) || StringUtils.equals(json, "{}")) {
            return null;
        }
        return com.alibaba.fastjson.JSON.parse(json);
    }
}

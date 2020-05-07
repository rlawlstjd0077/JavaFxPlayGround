package com.jinseong.soft.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.time.ZonedDateTime;
import java.util.*;

public class JsonUtil {

    private static final Map<Type, Object> typeAdapterMap = new HashMap<>();
    private static Gson gson;

    private JsonUtil() {
    }

    /**
     * JSON 을 사용하기 위해서 Gson이 필요한 경우 활용. (기본적으로는 JEST 라이브러리에게 전달하기 위한 용도)
     *
     * @return Gson 인스턴스
     */
    public static synchronized Gson getGsonSingleton() {
        if (gson == null) {
            gson = getGsonBuilder()
                    .excludeFieldsWithModifiers(Modifier.TRANSIENT, Modifier.STATIC)
                    .create();
        }
        return gson;
    }

    /**
     * 객체를 Json으로 변환해 주는 메소드.
     *
     * @param object 변환하기 위한 객체
     * @return String Json String
     */
    public static <T> String toJson(T object) {
        return getGsonSingleton().toJson(object);
    }

    /**
     * 객체를 보기좋은 Json String 으로 변환해 주는 메소드.
     *
     * @param object 변환하기 위한 객체
     * @return String Json String
     */
    public static <T> String toPrettyJson(T object) {
        return getGsonBuilder().setPrettyPrinting().create().toJson(object).replace("\n", "\r\n");
    }

    /**
     * 객체의 Transient 필드를 포함하여 Json으로 변환해 주는 메소드.
     *
     * @param object 변환하기 위한 객체
     * @return String Json String
     */
    public static <T> String toJsonWithTransient(T object) {
        return getGsonBuilder().excludeFieldsWithModifiers(Modifier.STATIC).create().toJson(object);
    }

    /**
     * Json String을 객체로 변환해 주는 메소드.
     *
     * @param json Json String
     * @param classOfT 객체 타입
     * @param <T> 객체 타입
     * @return 객체 타입
     */
    public static <T> T toInstance(String json, Class<T> classOfT) {
        return getGsonSingleton().fromJson(json, classOfT);
    }

    public static <T> T toInstance(String json, Type type) {
        return getGsonSingleton().fromJson(json, type);
    }

    /**
     * Json String을 Transient 필드를 포함하여 객체로 변환해 주는 메소드.
     *
     * @param json Json String
     * @param type 객체 타입
     * @return 객체 타입
     */
    public static <T> T toInstanceWithTransient(String json, Type type) {
        return getGsonBuilder().excludeFieldsWithModifiers(Modifier.STATIC).create().fromJson(json, type);
    }

    /**
     * 클래스 복제.
     *
     * @param object 입력 instance
     * @param classOfT 클래스 타입
     * @param <T> 클래스 타입
     * @return 복제 instance
     */
    public static <T> T clone(T object, Class<T> classOfT) {
        final String json = toJson(object);
        return toInstance(json, classOfT);
    }

    private static GsonBuilder getGsonBuilder() {
        final GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(ZonedDateTime.class, new ZonedDateTimeTypeAdaptor());

        for (Map.Entry<Type, Object> entry : typeAdapterMap.entrySet()) {
            builder.registerTypeAdapter(entry.getKey(), entry.getValue());
        }

        return builder;
    }


    public static void registerTypeAdapter(Type type, Object typeAdapter) {
        if (!typeAdapterMap.containsKey(type)) {
            typeAdapterMap.put(type, typeAdapter);
        }
    }
}

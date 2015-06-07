package io.swagger.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class JsonUtil {
    public static GsonBuilder gsonBuilder;

    public static Gson getGson() {
        return gsonBuilder.create();
    }

    public static String serialize(Object obj) {
        return getGson().toJson(obj);
    }

    public static <T> T deserializeToList(String jsonString, Class cls) {
        return getGson().fromJson(jsonString, getListTypeForDeserialization(cls));
    }

    public static <T> T deserializeToObject(String jsonString, Class cls) {
        return getGson().fromJson(jsonString, getTypeForDeserialization(cls));
    }

    public static Type getListTypeForDeserialization(Class cls) {
        String className = cls.getSimpleName();

        if ("User".equalsIgnoreCase(className)) {
            return new TypeToken<List<User>>() {
            }.getType();
        }

        if ("Category".equalsIgnoreCase(className)) {
            return new TypeToken<List<Category>>() {
            }.getType();
        }

        if ("Pet".equalsIgnoreCase(className)) {
            return new TypeToken<List<Pet>>() {
            }.getType();
        }

        if ("Tag".equalsIgnoreCase(className)) {
            return new TypeToken<List<Tag>>() {
            }.getType();
        }

        if ("Order".equalsIgnoreCase(className)) {
            return new TypeToken<List<Order>>() {
            }.getType();
        }

        return new TypeToken<List<Object>>() {
        }.getType();
    }

    public static Type getTypeForDeserialization(Class cls) {
        String className = cls.getSimpleName();

        if ("User".equalsIgnoreCase(className)) {
            return new TypeToken<User>() {
            }.getType();
        }

        if ("Category".equalsIgnoreCase(className)) {
            return new TypeToken<Category>() {
            }.getType();
        }

        if ("Pet".equalsIgnoreCase(className)) {
            return new TypeToken<Pet>() {
            }.getType();
        }

        if ("Tag".equalsIgnoreCase(className)) {
            return new TypeToken<Tag>() {
            }.getType();
        }

        if ("Order".equalsIgnoreCase(className)) {
            return new TypeToken<Order>() {
            }.getType();
        }

        return new TypeToken<Object>() {
        }.getType();
    }

    static {
        gsonBuilder = new GsonBuilder();
        gsonBuilder.serializeNulls();
        gsonBuilder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    }

};

package com.makiia.crosscutting.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.makiia.crosscutting.domain.adapter.HibernateProxyTypeAdapter;
import lombok.experimental.UtilityClass;

@UtilityClass
public class GsonUtil {
    public static Gson getGson() {
        return getGson("MMM dd, yyyy HH:mm:ss", true);
    }

    public static Gson getGson(boolean exclude) {
        return getGson("MMM dd, yyyy HH:mm:ss", exclude);
    }

    public static Gson getGson(String format, boolean exclude) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder
                .registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY)
                .setDateFormat(format)
                .serializeNulls();

        if (exclude) {
            gsonBuilder.setExclusionStrategies(new ExclusionStrategy() {
                @Override
                public boolean shouldSkipClass(Class<?> clazz) {
                    return (null != clazz.getAnnotation(JsonIgnore.class));
                }

                @Override
                public boolean shouldSkipField(FieldAttributes f) {
                    return (null != f.getAnnotation(JsonIgnore.class));
                }
            });
        }

        return gsonBuilder.create();
    }

}

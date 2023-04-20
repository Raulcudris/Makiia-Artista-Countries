package com.makiia.crosscutting.domain.adapter;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;

import java.io.IOException;

@SuppressWarnings("unchecked")
public class HibernateProxyTypeAdapter extends TypeAdapter<HibernateProxy> {

    public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory() {
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            TypeAdapter<T> o = null;

            return (HibernateProxy.class.isAssignableFrom(type.getRawType()) ?
                    (TypeAdapter<T>) new HibernateProxyTypeAdapter(gson) : o);
        }
    };
    private final Gson context;

    private HibernateProxyTypeAdapter(Gson context) {
        this.context = context;
    }

    @Override
    public HibernateProxy read(JsonReader in) throws IOException {
        throw new UnsupportedOperationException("Not supported");
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void write(JsonWriter out, HibernateProxy value) throws IOException {
        if (value == null) {
            out.nullValue();
            return;
        }

        Class<?> baseType = Hibernate.getClass(value);
        TypeAdapter delegate = context.getAdapter(TypeToken.get(baseType));
        Object unproxiedValue = value.getHibernateLazyInitializer().getImplementation();
        delegate.write(out, unproxiedValue);
    }
}

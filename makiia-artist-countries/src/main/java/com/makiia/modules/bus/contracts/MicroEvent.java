package com.makiia.modules.bus.contracts;

public interface MicroEvent<T> {
    /**
     * @return String
     */
    String getId();

    /**
     * @return BusFlow
     */
    BusFlow getFlow();

    /**
     * @return T
     */
    T getPayload();

    /**
     * @param payload payload
     */
    void setPayload(T payload);

    /**
     * @param key
     * @param value
     */
    void setHeader(String key, String value);

    /**
     * @param key
     * @param value
     */
    void setHeader(String key, Object value);

    /**
     * @param key key to Map Headers
     * @return header
     */
    String getHeader(String key);
}

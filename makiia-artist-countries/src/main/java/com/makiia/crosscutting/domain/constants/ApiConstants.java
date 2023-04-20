package com.makiia.crosscutting.domain.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiConstants {

    public static final String GET_HTTP = "GET";
    public static final String POST_HTTP = "POST";
    public static final String PUT_HTTP = "PUT";
    public static final String DELETE_HTTP = "DELETE";

    public static final String GET_ALL_DESC = "Get list an entitites";
    public static final String GET_DESC = "Get an entity";
    public static final String POST_DESC = "Save a new entity";
    public static final String PUT_DESC = "Update an entity";
    public static final String DELETE_DESC = "Delete an entity";
}

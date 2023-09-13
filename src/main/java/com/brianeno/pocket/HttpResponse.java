package com.brianeno.pocket;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.nio.charset.StandardCharsets;
import java.util.Map;

public class HttpResponse {

    private final byte[] body;

    protected HttpResponse(byte[] body) {
        this.body = body;
    }

    protected <T> T asObject(Class<T> type) {
        return new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create().fromJson(new String(body, StandardCharsets.UTF_8), type);
    }

    protected String asString() {
        return new String(body, StandardCharsets.UTF_8);
    }

    protected Map<String, Object> asMap() {
        return new Gson().fromJson(asString(), new TypeToken<Map<String, String>>() {
        }.getType());
    }
}

package com.brianeno.pocket;

import lombok.Getter;

@Getter
public class PocketAuth {

    private final String consumerKey;
    private final String accessToken;

    PocketAuth(String consumerKey, String accessToken) {
        this.consumerKey = consumerKey;
        this.accessToken = accessToken;
    }
}

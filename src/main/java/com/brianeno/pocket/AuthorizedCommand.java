package com.brianeno.pocket;

import lombok.Getter;

@Getter
public abstract class AuthorizedCommand {
    private String consumer_key;
    private String access_token;

    void setAuth(PocketAuth pocketAuth) {
        consumer_key = pocketAuth.getConsumerKey();
        access_token = pocketAuth.getAccessToken();
    }
}

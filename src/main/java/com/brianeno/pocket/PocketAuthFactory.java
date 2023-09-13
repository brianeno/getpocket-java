package com.brianeno.pocket;

import java.io.IOException;
import java.util.HashMap;

public class PocketAuthFactory {

    private static final String AUTH_URL = "https://getpocket.com/v3/oauth/authorize";
    private static final String AUTH_URL_WITH_TOKEN = AUTH_URL + "?request_token=";
    private static final String ACCESS_CODE_URL = "https://getpocket.com/v3/oauth/request";

    private final String consumerKey;
    private final String redirectUrl;
    private final String code;

    private PocketAuthFactory(String consumerKey, String redirectUrl) throws IOException {
        this.consumerKey = consumerKey;
        this.redirectUrl = redirectUrl;
        this.code = generateAccessCode();
    }

    public static PocketAuth createForAccessToken(String consumerKey, String accessToken) {
        return new PocketAuth(consumerKey, accessToken);
    }

    public static PocketAuth createForCode(String consumerKey, String code) throws IOException {
        String accessToken = generateAccessToken(consumerKey, code);
        return new PocketAuth(consumerKey, accessToken);
    }

    public static PocketAuthFactory create(String consumerKey, String redirectUrl) throws IOException {
        return new PocketAuthFactory(consumerKey, redirectUrl);
    }

    public String getCode() {
        return code;
    }

    public String getAuthUrl() {
        return AUTH_URL_WITH_TOKEN + code + "&redirect_uri=" + redirectUrl;
    }

    public PocketAuth create() throws IOException {
        return createForCode(consumerKey, code);
    }

    private String generateAccessCode() throws IOException {
        HashMap<String, String> params = new HashMap<>();
        params.put("consumer_key", consumerKey);
        params.put("redirect_uri", redirectUrl);
        HttpRequest request = HttpRequest.postJson(ACCESS_CODE_URL, params);
        HttpResponse response = HttpProvider.get().send(request);
        return (String) response.asMap().get("code");
    }

    private static String generateAccessToken(String consumerKey, String accessCode) throws IOException {
        HashMap<String, String> params = new HashMap<>();
        params.put("consumer_key", consumerKey);
        params.put("code", accessCode);
        HttpRequest request = HttpRequest.postJson(AUTH_URL, params);
        HttpResponse response = HttpProvider.get().send(request);
        return (String) response.asMap().get("access_token");
    }
}

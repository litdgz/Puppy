package com.litdgz.puppy.restApi;

public final class ConstantesRestApi {

    public static final String VERSION = "/v9.0/";
    public static final String ROOT_URL = "https://graph.facebook.com/" + VERSION;
    public static final String ACCESS_TOKEN = "EAAPfdZAERB80BAErFPZCfV3B236X8V1ZBUL9vt30SjQZBGYDEDNpwlWkGEWtCzar8fipZCn6eJZATjRHBTb1WoGM0zshvACRDn7cGYSZBLMnQVpVT6X8NlG4UjF2ipGnEsP5vZATolE8peTZCExrmWPIV6d99tNrcn5cZD";
    public static final String KEY_ACCESS_TOKEN = "&access_token=";
    public static final String KEY_GET_RECENT_MEDIA_USER = "17841400864510469/media?fields=like_count,media_type,media_url,owner,username,id";
    public static final String URL_GET_RECENT_MEDIA_USER = KEY_GET_RECENT_MEDIA_USER + KEY_ACCESS_TOKEN + ACCESS_TOKEN;
}

// https://graph.facebook.com/v9.0/17841400864510469/media?fields=id,media_type,media_url,like_count,timestamp,owner&access_token=
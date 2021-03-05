package com.my.test;

import org.apache.http.HttpRequest;

import java.io.InputStream;

public interface MApiRequest extends HttpRequest {
    CacheType defaultCacheType();

    boolean disableStatistics();

    InputStream input();
}
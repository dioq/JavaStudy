package com.my.test;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class MApiFormInputStream extends FormInputStream {
    public static final String DEFAULT_CHARSET = "UTF-8";
    public static final String UTF_8 = "UTF-8";

    public MApiFormInputStream(List<NameValuePair> form) {
        super(form, "UTF-8");
    }

    public MApiFormInputStream(String... keyValues) {
        super(form(keyValues), "UTF-8");
    }

    private static List<NameValuePair> form(String... keyValues) {
        int n = keyValues.length / 2;
        ArrayList<NameValuePair> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(new BasicNameValuePair(keyValues[i * 2], keyValues[(i * 2) + 1]));
        }
        return list;
    }
}
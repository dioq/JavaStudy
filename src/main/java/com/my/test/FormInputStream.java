package com.my.test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class FormInputStream extends WrapInputStream {
    public static final String DEFAULT_CHARSET = "ISO-8859-1";
    public static final String ISO_8859_1 = "ISO-8859-1";
    private String charsetName;
    private List<NameValuePair> form;

    public FormInputStream(List<NameValuePair> form2, String charsetName2) {
        this.form = form2;
        this.charsetName = charsetName2;
    }

    public FormInputStream(List<NameValuePair> form2) {
        this(form2, "ISO-8859-1");
    }

    public FormInputStream(String... keyValues) {
        int n = keyValues.length / 2;
        ArrayList<NameValuePair> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(new BasicNameValuePair(keyValues[i * 2], keyValues[(i * 2) + 1]));
        }
        this.form = list;
        this.charsetName = "ISO-8859-1";
    }

    public List<NameValuePair> form() {
        return this.form;
    }

    public String charsetName() {
        return this.charsetName;
    }

    private String encode() throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        for (NameValuePair e : this.form) {
            if (sb.length() > 0) {
                sb.append('&');
            }
            sb.append(e.getName());
            sb.append('=');
            if (e.getValue() != null) {
                sb.append(URLEncoder.encode(e.getValue(), this.charsetName));
            }
        }
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public InputStream wrappedInputStream() throws IOException {
        try {
            return new ByteArrayInputStream(encode().getBytes(this.charsetName));
        } catch (UnsupportedCharsetException e) {
            throw new IOException(e.getMessage());
        }
    }

    public String toString() {
        try {
            return encode();
        } catch (Exception e) {
            return "";
        }
    }
}
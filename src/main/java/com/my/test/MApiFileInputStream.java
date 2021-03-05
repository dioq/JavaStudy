package com.my.test;


import java.io.IOException;
import java.io.InputStream;

public class MApiFileInputStream extends MApiFormInputStream {
    private InputStream mInputSteam;

    public MApiFileInputStream(InputStream inputStream) {
        super(new String[0]);
        this.mInputSteam = inputStream;
    }

    /* access modifiers changed from: protected */
    public InputStream wrappedInputStream() throws IOException {
        return this.mInputSteam;
    }
}

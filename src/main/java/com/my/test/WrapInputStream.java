package com.my.test;

import java.io.IOException;
import java.io.InputStream;

public abstract class WrapInputStream extends InputStream {
    private IOException ex;
    private InputStream ins;

    /* access modifiers changed from: protected */
    public abstract InputStream wrappedInputStream() throws IOException;

    private synchronized InputStream inputStream() throws IOException {
        if (this.ex != null) {
            throw this.ex;
        }
        if (this.ins == null) {
            try {
                this.ins = wrappedInputStream();
            } catch (IOException e) {
                this.ex = e;
                throw this.ex;
            }
        }
        return this.ins;
    }

    public int available() throws IOException {
        return inputStream().available();
    }

    public void close() throws IOException {
        if (this.ins != null) {
            inputStream().close();
        }
    }

    public void mark(int readlimit) {
    }

    public synchronized void reset() throws IOException {
        this.ins = null;
    }

    public boolean markSupported() {
        return true;
    }

    public int read() throws IOException {
        return inputStream().read();
    }

    public int read(byte[] buffer, int offset, int length) throws IOException {
        return inputStream().read(buffer, offset, length);
    }

    public int read(byte[] buffer) throws IOException {
        return inputStream().read(buffer);
    }

    public long skip(long byteCount) throws IOException {
        return inputStream().skip(byteCount);
    }
}

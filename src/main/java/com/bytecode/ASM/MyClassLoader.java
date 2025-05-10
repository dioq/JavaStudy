package com.bytecode.ASM;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MyClassLoader extends ClassLoader {

    private String classPath;

    public MyClassLoader(String classPath) {
        this.classPath = classPath;
    }

    public byte[] readFile(String name) throws IOException {
        File file = new File(classPath, name + ".class");
        if (!file.exists()) {
            return null;
        }

        FileInputStream fin = new FileInputStream(file);
        int length = fin.available();
        byte[] buff = new byte[length];
        fin.read(buff);
        fin.close();
        return buff;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] data = readFile(name);
            if (data != null) {
                return defineClass(name, data, 0, data.length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
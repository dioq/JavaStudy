package com.study01.file_io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {

    private static FileUtil instance;

    private FileUtil() {
    }

    public static FileUtil getInstance() {
        if (instance == null) {
            synchronized (FileUtil.class) {
                if (instance == null) {
                    instance = new FileUtil();
                }
            }
        }
        return instance;
    }

    public byte[] read(File file) throws FileNotFoundException, IOException {
        FileInputStream fin = new FileInputStream(file);
        int length = fin.available();
        byte[] buff = new byte[length];
        fin.read(buff);
        fin.close();
        return buff;
    }

    public void write(File file, byte[] data) throws FileNotFoundException, IOException {
        // 创建基于文件的输出流
        FileOutputStream fos = new FileOutputStream(file);
        // 把数据写入到输出流
        fos.write(data);
        // 关闭输出流
        fos.close();
    }

    // 复制文件
    public void copyFile(File srcFile, File dstFile) throws FileNotFoundException, IOException {
        if (dstFile.exists()) {
            dstFile.delete();
        }

        FileInputStream fileInputStream = new FileInputStream(srcFile);
        FileOutputStream fileOutputStream = new FileOutputStream(dstFile);
        byte[] data = new byte[0x1000];
        int len = -1;
        while ((len = fileInputStream.read(data)) != -1) {
            fileOutputStream.write(data, 0, len);
            fileOutputStream.flush();
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}

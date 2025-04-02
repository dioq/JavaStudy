package com.study01.file_io;

import java.io.File;

public class Test {

    public static void main(String[] args) {
        // test_write();
        // test_read();
        test_copy();
    }

    public static void test_write() {
        String path = "/tmp/test.txt";
        String str = "this is only a test!";
        try {
            FileUtil.getInstance().write(new File(path), str.getBytes());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void test_read() {
        String path = "/tmp/test.txt";
        try {
            byte[] bytes = FileUtil.getInstance().read(new File(path));
            String str = new String(bytes);
            System.out.println(str);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void test_copy() {
        String srcPath = "/tmp/test.txt";
        String dstPath = "/tmp/test2.txt";
        File srcFile = new File(srcPath);
        File dstFile = new File(dstPath);
        try {
            FileUtil.getInstance().copyFile(srcFile, dstFile);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

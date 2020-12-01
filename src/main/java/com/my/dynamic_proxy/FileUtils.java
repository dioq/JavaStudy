package com.my.dynamic_proxy;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    /**
     * 读取一个文本 一行一行读取
     *
     * @param path
     * @return
     */
    public static List<String> read_file_row(String path) {
        List<String> list = new ArrayList<String>();
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            fis = new FileInputStream(path);
            isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            br = new BufferedReader(isr);
            String line = "";
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (isr != null) {
                    isr.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }


    //读取本地文本里的数据(一次读完所有数据)
    public static String read_file(String path) {
        String result = null;
        try {
            File f = new File(path);
            System.out.println(f.getAbsoluteFile());
            if (!f.exists()) {
                return null;
            }
            int length = (int) f.length();
            byte[] buff = new byte[length];
            FileInputStream fin = new FileInputStream(f);
            fin.read(buff);
            fin.close();
            result = new String(buff, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


    //把本地的任一文件 的二进制数据 获取到并以二进制的形式 写到另一个文件里
    public static void fileBytes_to_localFile(String source_path, String destination_path) {
        File source_file = new File(source_path);
        File des_file = new File(destination_path);

        DataInputStream bis = null;
        FileInputStream fis = null;
        OutputStream out = null;

        try {
            if (!source_file.exists()) {
                System.out.println("待处理文件不存在");
                return;
            }
            //目标文件不存在 就创建
            if (!des_file.exists()) {
                des_file.createNewFile();
            }

            //把图片的二进制数据 读到输入流里
            fis = new FileInputStream(source_file);
            bis = new DataInputStream(fis);
            //建立目标输出流
            out = new FileOutputStream(des_file.getAbsolutePath());
            int len = 0;
            byte[] buff = new byte[1024];
            //依次读入输入流里的二进制数据,再写到输出流里
            while ((len = bis.read(buff)) != -1) {
                out.write(buff, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null)
                    out.close();
                if (fis != null)
                    fis.close();
                if (bis != null)
                    bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    //把string 写到本地文件里(会覆盖)
    public static void write_to_localFile(String content, String filePath) {
        File f = new File(filePath);
        FileOutputStream fos = null;
        try {
            if (!f.exists()) {
                boolean isOr = f.createNewFile();
                if (!isOr) {
                    return;
                }
            }
            byte[] data = content.getBytes();
            // 创建基于文件的输出流
            fos = new FileOutputStream(f);
            // 把数据写入到输出流
            fos.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    // 关闭输出流
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //把string 写到本地文件里(往尾部追加数据)
    public static void write_toEnd_localFile(String content, String filePath) {
        File f = new File(filePath);
        BufferedWriter out = null;
        try {
            if (!f.exists()) {
                f.createNewFile();
            }
            out = new BufferedWriter(new FileWriter(f, true));
            out.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    // 关闭输出流
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

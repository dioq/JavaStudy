package com.study01.file_io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    /*
     * 获取指定行数的数据
     * */
    public static String readLineByIndex(String path, int lineNumber) {
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        String line = null;
        try {
            fis = new FileInputStream(path);
            isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            br = new BufferedReader(isr);

            line = br.readLine();
            if (lineNumber < 0 || lineNumber > getTotalLines(path)) {
                System.out.println("不在文件的行数范围之内。");
                return null;
            }
            int num = 0;
            while (line != null) {
                if (lineNumber == ++num) {
//                    System.out.println("line " + lineNumber + ": " + line);
                    break;
                }
                line = br.readLine();
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
        return line;
    }

    // 文件内容的总行数
    public static int getTotalLines(String path) {
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        LineNumberReader reader = null;
        int lines = 0;
        try {
            fis = new FileInputStream(path);
            isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            br = new BufferedReader(isr);
            reader = new LineNumberReader(br);
            String s = reader.readLine();
            while (s != null) {
                lines++;
                s = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
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
        return lines;
    }


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
            FileInputStream fin = new FileInputStream(f);
            int length = fin.available();
            byte[] buff = new byte[length];
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
            out = Files.newOutputStream(Paths.get(des_file.getAbsolutePath()));
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
                if (out != null) out.close();
                if (fis != null) fis.close();
                if (bis != null) bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    // 读取本地文件的 二进制数据
    public static byte[] readBytes_from_localFile(String source_path) {
        File source_file = new File(source_path);
        if (!source_file.exists()) {
            System.out.println("待处理文件不存在");
            return null;
        }

        DataInputStream bis = null;
        FileInputStream fis = null;
        byte[] buff = null;

        try {
            fis = new FileInputStream(source_file);
            bis = new DataInputStream(fis);

            int len = bis.available();//获取文件字节数
            buff = new byte[len];
            bis.read(buff, 0, len);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) fis.close();
                if (bis != null) bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return buff;
    }

    // 将 二进制数据 写到本地文件
    public static void writeBytes_to_localFile(byte[] data, String destination_path) {
        File des_file = new File(destination_path);

        OutputStream out = null;

        if (data.length <= 0) {
            System.out.println("要写入的数据为空");
            return;
        }

        try {
            //目标文件存在 就删除,保证新建的文件是全新的
            if (des_file.exists()) {
                des_file.delete();
            }
            des_file.createNewFile();

            //建立目标输出流
            out = new FileOutputStream(des_file.getAbsolutePath());
            //将数据写到本地文件中
            out.write(data, 0, data.length);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) out.close();
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

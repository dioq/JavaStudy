package com.my.file_io;

public class Test {

    public static void main(String[] args) {
//        String filePath = "F:\\log\\money.jpg";
//        String desPath = "F:\\log\\image_bytes";
//        FileUtils.fileBytes_to_localFile(filePath, desPath);

//        String test_str = "this is only a test!";
//        String desPath = "F:\\log\\test1.txt";
//        FileUtils.write_to_localFile(test_str, desPath);

//        String test_str = "this is only a test!";
//        String desPath = "F:\\log\\test2.txt";
//        FileUtils.write_toEnd_localFile(test_str, desPath);

        readSelectedLine();
    }

    public static void readSelectedLine() {
        String path = "src/main/java/com/my/file_io/target.txt";
        int totalNum = FileUtils.getTotalLines(path);
        System.out.println("totalNum : " + totalNum);
        String line = FileUtils.readLineByIndex(path, 8);
        System.out.println(line);
    }

}

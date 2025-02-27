package cn.my;

public class Test {
    public String getMsgFromDexFile(String param) {
        return param + "| come from dex file";
    }

    public static void main(String[] args) {
        String str = new Test().getMsgFromDexFile("Hello world!");
        System.out.println(str);
    }
}

package com.my.verificationcode;

import static com.my.verificationcode.IdentifeUtil.getImgContent;

public class Test {

    public static void main(String[] args) {
        String code = getImgContent("src/main/resources/images/001.jpeg");
        System.out.println("验证码 = " + code);
        String code2 = getImgContent("src/main/resources/images/002.png");
        System.out.println("验证码 = " + code2);
        String code3 = getImgContent("src/main/resources/images/003.jpeg");
        System.out.println("验证码 = " + code3);
    }

}

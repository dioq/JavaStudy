package com.base.Unicode;

import static com.base.Unicode.UnicodeUtil.stringToUnicode;
import static com.base.Unicode.UnicodeUtil.unicodeToString;

public class Test {
    public static void main(String[] args) {
        String str = "汉语pinyin";
        String unicode = stringToUnicode(str);
        System.out.println("字符串转unicode结果：" + unicode);
        String s = unicodeToString(unicode);
        System.out.println("unicode转字符串结果：" + s);
    }
}

package com.base.auxiliary;

import static com.base.auxiliary.ClassUtils.*;

public class Test {
    public static void main(String[] args) {
        System.out.println("current class: " + getClassName());
        System.out.println("current function: " + getMethodName());
        System.out.println("current filename: " + getFileName());
        System.out.println("current line: " + getLineNumber());
    }
}

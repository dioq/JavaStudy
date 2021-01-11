package com.my.reflect;

import java.awt.*;
import java.lang.reflect.Array;

public class ArrayTypeDemo {

    /*
       Java 中所有的类都继承自 Object，数组本身也是一个 Class，如果我们能够得到数据的 Class 对象，那么我们可以通过反射生成数组对象。
       在Java的反射机制中，通过 数组的 class 对象的getComponentType()方法可以取得一个数组的Class对象， 通过Array.newInstance()可以反射生成数组对象
    * */
    public static void main(String[] args) {
        int[] ints = new int[2];
        Button[] buttons = new Button[6];
        String[][] twoDim = new String[4][5];
        String[] two = new String[4];

        printComponentType(ints);
        printComponentType(buttons);
        printComponentType(twoDim);
        printComponentType(two);
    }

    static void printComponentType(Object array) {
        Class arrayClass = array.getClass();
        String arrayName = arrayClass.getName();
        Class componentClass = arrayClass.getComponentType();
        String componentName = componentClass.getName();
        System.out.println("ArrayClass:" + arrayClass + "  ||||  ArrayName: " + arrayName + "  ||||| Component: "
                + componentName);

        System.out.println("反射生成新数组");

        //生成一个新的数组
        Object result = Array.newInstance(componentClass, 10);
        Class resultClass = result.getClass();
        System.out.println("resultClass : " + resultClass);

        System.out.println("====================== end ======================");
    }


}

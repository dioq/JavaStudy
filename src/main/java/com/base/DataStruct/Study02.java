package com.base.DataStruct;

import java.lang.reflect.Array;

public class Study02 {
    public static void main(String[] args) {
        test2();
    }

    public static void test2() {
        Class<?> clazz = int.class;
        int[] destArray = (int[]) Array.newInstance(clazz, 5);// 构造指定类型的数组

        int[] srcArray = { 1, 2, 3, 4, 5 };
        // 复制 srcArray 的前 3 个元素到 destArray 的前 3 个位置
        System.arraycopy(srcArray, 0, destArray, 0, 3);

        // 打印目标数组
        for (int i : destArray) {
            System.out.print(i + " "); // 输出: 1 2 3 0 0
        }
    }

    public static void test1() {
        int[] srcArray = { 1, 2, 3, 4, 5 };
        int[] destArray = new int[5];

        // 复制 srcArray 的前 3 个元素到 destArray 的前 3 个位置
        System.arraycopy(srcArray, 0, destArray, 0, 3);

        // 打印目标数组
        for (int i : destArray) {
            System.out.print(i + " "); // 输出: 1 2 3 0 0
        }
    }
}

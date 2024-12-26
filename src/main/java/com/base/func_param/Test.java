package com.base.func_param;

public class Test {
    public static void main(String[] args) {
        Test m1 = new Test();
        //一个值都不传递
        m1.changeParam();
        //传数组对象
        int[] arr = new int[]{5, 7, 9, 1};
        m1.changeParam(arr);
        //传多个元素值，会当成数组处理
        m1.changeParam(1, 2, 3, 4, 5);
        //传null，但是这个参数不可用
//        m1.changeParam(null);
    }
    public void changeParam(int... a) {
        System.out.println("数组长度为：" + a.length);
    }
}

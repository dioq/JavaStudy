package com.my.reference;

/*
 * 值传递
 * 形参是实参的拷贝，改变形参的值并不会影响外部实参的值。
 * 从被调用函数的角度来说，值传递是单向的（实参->形参），参数的值只能传入，不能传出。
 * */
public class IntegerTest01 {
    private static void changeInt(int value) {
        ++value;
    }

    public static void main(String[] args) {
        int a = 1;
        changeInt(a);
        System.out.println("a = " + a);
    }
}

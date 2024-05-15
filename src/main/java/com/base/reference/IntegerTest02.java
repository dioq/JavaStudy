package com.base.reference;

/*
 * Java 中所传递的所有东西都是值，但此值是变量所携带的值。引用对象的变量所携带的是远程控制而不是对象本身，
 * 若你对方法传入参数，实际上传入的是远程控制的拷贝。
 * 如果使用直接指针，那么 Java 堆对象的布局中就必须考虑如何放置访问对象类型数据的相关信息，而 reference 中存储的直接就是对象地址。
 *
 * 在 Java 中声明并初始化一个对象Object object = new Object()，在堆中存储对象实例数据，在栈中存储对象地址，
 * 这里的变量 object 相当于 C/C++ 中的指针。
 * 因此，可以通过 Java 对象的引用，达到指针传递的效果。
 * */
public class IntegerTest02 {
    private static void changeInt(int[] value) {
        ++value[0];
    }

    public static void main(String[] args) {
        int[] a = {1};
        changeInt(a);
        System.out.println("a[0] = " + a[0]);
    }
}

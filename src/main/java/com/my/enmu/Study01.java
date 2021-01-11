package com.my.enmu;

enum Signal {
    //定义一个枚举类型
    GREEN, YELLOW, RED
}

public class Study01 {
    public static void main(String[] args) {
//        test1_func();
        allValues();
    }

    //打印所有枚举值
    private static void allValues() {
        for (int i = 0; i < Signal.values().length; i++) {
            System.out.println("枚举成员：" + Signal.values()[i]);
        }
    }

    //简单使用
    private static void test1_func() {
        Signal color = Signal.GREEN;
        switch (color) {
            case RED:
                color = Signal.GREEN;
                break;
            case YELLOW:
                color = Signal.RED;
                break;
            case GREEN:
                color = Signal.YELLOW;
                break;
        }
        System.out.println("color : " + color);
    }

}

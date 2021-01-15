package com.my.enumdemo.study02;

public class Test01 {
    public static void main(String[] args) {
        allValues();
    }

    private static void allValues() {
        for (WeekDay day : WeekDay.values()) {
            System.out.println(day + "====>" + day.getDay());
        }
        WeekDay.printDay(5);
    }
}

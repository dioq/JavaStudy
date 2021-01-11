package com.my.enmu;

public class Study02 {
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

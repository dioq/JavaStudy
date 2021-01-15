package com.my.enumdemo.study02.another;

import com.my.enumdemo.study02.WeekDay;

public class Test02 {
    public static void main(String[] args) {
        judgeWhichDay(WeekDay.Sun);
    }

    public static void judgeWhichDay(WeekDay day) {
        switch (day) {
            case Sat:
            case Sun:
                System.out.println(day.getDay() + " 休息");
                break;
            default:
                System.out.println(day.getDay() + " 工作日 上班");
        }
    }
}

package com.base.random;

import java.util.Random;

public class RandomDemo {

    public static void main(String[] args) {
        Random ra = new Random();
        int suffix = ra.nextInt(1000000);
        System.out.println(suffix);
    }

}

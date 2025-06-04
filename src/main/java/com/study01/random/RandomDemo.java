package com.study01.random;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;

import java.io.File;

public class RandomDemo {

    public static void main(String[] args) {
        // test1();
        test2();
    }

    public static void test1() {
        Random ra = new Random();
        int suffix = ra.nextInt(1000000);
        System.out.println(suffix);
    }

    public static void test2() {
        // Create a SecureRandom instance
        SecureRandom random = new SecureRandom();

        // Generate a random integer
        int randomInt = random.nextInt();
        System.out.println("Random Integer: " + randomInt);

        // Generate a random byte array
        byte[] randomBytes = new byte[16];
        random.nextBytes(randomBytes);
        System.out.println("Random Bytes: " + java.util.Arrays.toString(randomBytes));

        // Generate a random number within a range
        int randomWithinRange = random.nextInt(100); // Random number from 0 to 99
        System.out.println("Random Number within Range: " + randomWithinRange);
    }

    public static void test3() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[16];
        random.nextBytes(bytes);
    }
}

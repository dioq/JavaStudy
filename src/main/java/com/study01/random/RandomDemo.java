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

    public static File getNextCodePath(File targetDir, String packageName) {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[16];
        File firstLevelDir;
        do {
            random.nextBytes(bytes);
            String firstLevelDirName = RANDOM_DIR_PREFIX
                    + Base64.encodeToString(bytes, Base64.URL_SAFE | Base64.NO_WRAP);
            firstLevelDir = new File(targetDir, firstLevelDirName);
        } while (firstLevelDir.exists());

        random.nextBytes(bytes);
        String dirName = packageName + RANDOM_CODEPATH_PREFIX + Base64.encodeToString(bytes,
                Base64.URL_SAFE | Base64.NO_WRAP);
        final File result = new File(firstLevelDir, dirName);
        if (DEBUG && !Objects.equals(tryParsePackageName(result.getName()), packageName)) {
            throw new RuntimeException(
                    "codepath is off: " + result.getName() + " (" + packageName + ")");
        }
        return result;
    }

}

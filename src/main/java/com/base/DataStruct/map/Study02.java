package com.base.DataStruct.map;

import java.util.Iterator;
import java.util.TreeMap;

public class Study02 {

    public static void main(String[] args) {

        TreeMap<Integer, String> pairs = new TreeMap<>();
        pairs.put(2, "B");
        pairs.put(1, "A");
        pairs.put(3, "C");

        String value = pairs.get(3); // get method
        System.out.println(value);
        value = pairs.getOrDefault(5, "oops"); // getOrDefault method
        System.out.println(value);
        // Iteration example
        Iterator<Integer> iterator = pairs.keySet().iterator();
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            System.out.println("Key: " + key + ", Value: " + pairs.get(key));
        }

        // Remove example
        pairs.remove(3);
        System.out.println(pairs);
        System.out.println(pairs.containsKey(1)); // containsKey method
        System.out.println(pairs.containsValue("B")); // containsValue method
        System.out.println(pairs.ceilingKey(2));
    }
}

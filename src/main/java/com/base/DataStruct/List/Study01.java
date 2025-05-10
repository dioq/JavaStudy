package com.base.DataStruct.List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Study01 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add("g");
        arrayList.add("c");
        arrayList.add("a");
        arrayList.add("b");
        System.out.println(arrayList.toString());
        // 排序
        Collections.sort(arrayList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(arrayList.toString());
    }
}

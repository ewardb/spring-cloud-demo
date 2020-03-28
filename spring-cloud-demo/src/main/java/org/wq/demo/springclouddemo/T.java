package org.wq.demo.springclouddemo;

import java.util.HashSet;

public class T {


    public static void main(String[] args) {
        HashSet<String> stringHashSet = new HashSet<String>();


        stringHashSet.add("a");
        stringHashSet.add("b");
        stringHashSet.add("c");
        stringHashSet.add("=d");
        stringHashSet.add("a=e");
        stringHashSet.add("=");

        HashSet<String> strings = new HashSet<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");


        stringHashSet.remove(strings);
        for (String s : stringHashSet) {
            System.out.println(s);
        }

        stringHashSet.removeAll(strings);
        stringHashSet.forEach(vo -> {
            System.out.println(vo);
        });

    }
}

package com.atguigu.chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestDemo2 {

    public static void main(String[] args) {
        Integer a[] = {1,2,3};
        List<String> results = new ArrayList();
        int count = 0;
        for (int i=0; i < a.length; i++){
            List<Integer> list = new ArrayList<Integer>(Arrays.asList(a));
            printCode(a.length, list, i, list.get(i) + "", results);
        }
        for (String s : results) {
            if (s.charAt(a.length -2) == '5'){
                System.out.println(s + "-----");
                count++;
            }
        }
        System.out.print(count);
    }

    private static void printCode(int length, List list, int i, String o, List<String> results) {
        if (o.length() == length) {
            System.out.println(o + "===");
            results.add(o);
            return;
        }
        list.remove(i);
        List list1 = new ArrayList(list);
        for (int j=0; j < list1.size(); j++) {
            List list2 = new ArrayList(list);
            printCode(length, list2, j, o + list1.get(j), results);
        }
    }
}

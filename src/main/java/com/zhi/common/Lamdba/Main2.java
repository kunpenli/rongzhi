package com.zhi.common.Lamdba;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(23);
        list.add(34);
        list.add(45);
        list.add(56);
        eval(list, n -> true);
        System.out.println("-----------------------------------------");
        eval(list, n -> n>34);
        System.out.println("-----------------------------------------");
        eval(list, n -> n%2==0);
        System.out.println("---开始第二种写法-----------------------------------------");
        list.stream().filter(n -> n < 34).forEach(System.out::println); // filter筛选项，forEach遍历

    }

    public static void eval(List<Integer> integers, Predicate<Integer> predicate){
        for (Integer n : integers) {
            if ( predicate.test(n)){
                System.out.println(n);
            }
        }
    }
}

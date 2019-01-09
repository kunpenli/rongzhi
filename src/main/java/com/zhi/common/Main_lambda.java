package com.zhi.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main_lambda {
    public static void main(String[] args) {
        // 实现方法：saySomething
        Lam1 lam1 =() -> System.out.println("sfsd");
        lam1.saySomething();
        String [] as = {"1a","2a"};
        List<String> s = Arrays.asList(as);
        // 调用静态方法
        s.forEach(Lam2::tun);
        List<Lam2> list = new ArrayList<>();
        list.add(new Lam2());
        list.forEach(Lam2::tun1);
        // 构造对象1
        Lam2.con(() -> System.out.println("saf"));
        // 构造对象2
        // 如果不加上<T>的范型则使用不了::new这种方式
        Lam2.con(Lam2::new); //参数Lam2是有一定的接收作用
        // 调用实例方法
        list.forEach(Lam2::inst);
        // 调用其他对象的实例方法
        Lam2 lam2_xx = new Lam2();
        list.forEach(lam2_xx::inst2);// lam2_xx方法调用对象
    }
}
@FunctionalInterface
interface  Lam1<T>{
    void saySomething();
}
class Lam2{
    //
    public static void con(final Lam1<Lam2> lam1){
        System.out.println("构造对象");
    }
    public static void tun(final String s){
        System.out.println("调用静态方法1");
    }
    public static void tun1(final Lam2 lam2){
        System.out.println("调用静态方法2");
    }
    public void inst(){
        System.out.println("this is new instance " + this);
    }
    public void inst2(final Lam2 lam2){
        System.out.println("this is new instance " + this);
        System.out.println("this is new instance " + lam2);
    }
}

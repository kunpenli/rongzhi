package com.zhi.common;

/**
 * java8 初试
 */
public class Main {
    public static void main(String[] args) {
        Main tester = new Main();

        // 类型声明
        MathOperation ad = new MathOperation() {
            @Override
            public int operation(int a, int b) {
                return a + b;
            }
        };
        System.out.println(ad.operation(1, 2));
        MathOperation ad_l = (int a, int b) -> a + b;
        System.out.println(ad_l.operation(2, 3));

        // 不用类型声明
        MathOperation sb = new MathOperation() {
            @Override
            public int operation(int a, int b) {
                return a - b;
            }
        };
        System.out.println(sb.operation(3, 2));
        MathOperation sb_l = (a, b) -> a - b;
        System.out.println(sb_l.operation(4, 2));

        // 大括号中的返回语句
        MathOperation mp = new MathOperation() {
            @Override
            public int operation(int a, int b) {
                return a*b;
            }
        };
        System.out.println(mp.operation(1,5));
        MathOperation mp_l = (int a, int b) -> { return a * b; };
        System.out.println(mp_l.operation(1,9));

        GreetingService greetingService1 = message -> System.out.println("hello " + message);
        greetingService1.sayMessage("aab");

        GreetingService greetingService2 = (message) -> System.out.println("hello " + message);
        greetingService2.sayMessage("aab");
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }
}

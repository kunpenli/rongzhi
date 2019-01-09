package com.zhi.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface Supplier<T> {
    T get();
}

class Car {
    //Supplier是jdk1.8的接口，这里和lamda一起使用了
    public static Car create(final Supplier<Car> supplier) {
        return supplier.get();
    }

    public static void collide(final Car car) {
        System.out.println("Collided " + car.toString());
    }

    public void follow(final Car another) {
        System.out.println("Following the " + another.toString());
    }

    public void repair() {
        System.out.println("Repaired " + this.toString());
    }

    public static void main(String[] args) {
        Car car = create(Car::new); // 引用构造方法
        List<Car> list = Arrays.asList(car);

        list.forEach(Car::collide); // 引用静态方法

        list.forEach(Car::repair); // 引用势力方法

        Car car1 = create(Car::new);
        list.forEach(car1::follow); // 引用其他对象的方法

        List<String> names = new ArrayList<>();
        names.add("asdf");
        names.add("1234");
        names.add("7890");
        names.forEach(System.out::println); // 将System.out作为对象，引用println方法
    }
}


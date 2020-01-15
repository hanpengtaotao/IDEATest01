package com.han.prototype;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/***
 * @desription: TODO
 * @author    : hpt
 * @date      : 2020/1/15 23:13
 */
public class PrototypeTest {
    public static void main(String[] args) {
        //创建一个具体的需要克隆的对象
        ConcretePrototypeA concretePrototypeA = new ConcretePrototypeA();
        concretePrototypeA.setAge(19);
        concretePrototypeA.setName("han");
        List hobbies = new ArrayList<String>();
        concretePrototypeA.setHobbies(hobbies);
        System.out.println(concretePrototypeA);

        Client client = new Client(concretePrototypeA);
        ConcretePrototypeA concretePrototypeAClone = (ConcretePrototypeA) client.startClone(concretePrototypeA);
        System.out.println(concretePrototypeAClone);

        System.out.println("克隆对象中的引用类型地址值：" + concretePrototypeAClone.getHobbies());
        System.out.println("原对象中的应用类型地址值：" + concretePrototypeA.getHobbies());
        System.out.println("对象地址值比较：" + (concretePrototypeA.getHobbies() == concretePrototypeAClone.getHobbies()));

    }
}

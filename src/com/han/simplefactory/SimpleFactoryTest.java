package com.han.simplefactory;

public class SimpleFactoryTest {
    public static void main(String[] args) {
        WorkFactory workFactory = new WorkFactory();
        //IWork cs = workFactory.create("cs");
        IWork cs=workFactory.create("com.han.simplefactory.JavaWork");
        cs.createCode();
    }
}

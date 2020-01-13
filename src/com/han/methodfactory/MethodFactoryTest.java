package com.han.methodfactory;

import com.han.simplefactory.IWork;

public class MethodFactoryTest {
    public static void main(String[] args) {
        IWorkFactory workFactory = new JavaWorkFactory();
        IWork work = workFactory.create();
        work.createCode();
    }
}

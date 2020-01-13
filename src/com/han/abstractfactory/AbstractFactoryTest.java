package com.han.abstractfactory;

public class AbstractFactoryTest {
    public static void main(String[] args) {
        IWorkFactory workFactory = new JavaWorkFactory();
        workFactory.createCode().WriteCode();
        workFactory.createHelpDoc().writeHelpDoc();
    }
}

package com.han.abstractfactory;

import java.util.Scanner;

public class AbstractFactoryTest {
    public static void main(String[] args) {
        IWorkFactory workFactory = new JavaWorkFactory();
        workFactory.createCode().WriteCode();
        workFactory.createHelpDoc().writeHelpDoc();

        Scanner scanner=new Scanner(System.in);
        System.out.println(scanner.next());
    }
}

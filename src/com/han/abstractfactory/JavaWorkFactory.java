package com.han.abstractfactory;

public class JavaWorkFactory implements IWorkFactory {

    @Override
    public ICode createCode() {
        return new JavaCode();
    }

    @Override
    public IHelpDoc createHelpDoc() {
        return new JavaHelpDoc();
    }
}

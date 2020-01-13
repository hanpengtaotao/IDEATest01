package com.han.abstractfactory;

public class CsWorkFactory implements IWorkFactory {
    @Override
    public ICode createCode() {
        return new CsCode();
    }

    @Override
    public IHelpDoc createHelpDoc() {
        return new CsHelpDoc();
    }
}

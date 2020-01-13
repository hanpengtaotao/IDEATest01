package com.han.methodfactory;

import com.han.simplefactory.IWork;
import com.han.simplefactory.JavaWork;

public class JavaWorkFactory implements IWorkFactory {
    @Override
    public IWork create() {
        return new JavaWork();
    }
}

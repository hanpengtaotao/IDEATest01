package com.han.methodfactory;

import com.han.simplefactory.CSWork;
import com.han.simplefactory.IWork;

public class CSWorkFactory implements IWorkFactory {
    @Override
    public IWork create() {
        return new CSWork();
    }
}

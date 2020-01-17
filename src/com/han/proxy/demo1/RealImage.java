package com.han.proxy.demo1;

/**
 * @author HPT
 * @version 1.0
 * @package com.han.proxy.demo1
 * @date 2020/1/17 0017 14:13
 */
public class RealImage implements Image {
    private  String fileName;
    public RealImage(String fileName) {
        this.fileName = fileName;
        this.loadFromDisk(fileName);
    }

    private  void loadFromDisk(String fileName)
    {
        System.out.println("Loading:"+fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying:" + this.fileName);
    }
}

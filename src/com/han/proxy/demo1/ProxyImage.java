package com.han.proxy.demo1;

/**
 * @author HPT
 * @version 1.0
 * @package com.han.proxy.demo1
 * @date 2020/1/17 0017 14:16
 */
public class ProxyImage implements Image {
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (this.realImage == null) {
            this.realImage = new RealImage(this.fileName);
        }
        this.realImage.display();
    }
}

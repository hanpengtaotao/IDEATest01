package com.han.prototype;

/***
 * @desription: TODO
 * @author    : hpt
 * @date      : 2020/1/15 23:11
 */
public class Client {
    private Prototype prototype;

    public Client(Prototype prototype) {
        this.prototype = prototype;
    }

    public Prototype startClone(Prototype concretePrototype) {
        return (Prototype) concretePrototype.clone();
    }
}

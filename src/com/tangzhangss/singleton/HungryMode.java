package com.tangzhangss.singleton;

/**
 * 饿汉式单例
 */
public class HungryMode {
    private final static HungryMode single = new HungryMode();
    private HungryMode(){}
    public static HungryMode getInstance(){
        return single;
    }


    public static void main(String[] args) {
        System.out.println(HungryMode.getInstance()==HungryMode.getInstance());
    }
}

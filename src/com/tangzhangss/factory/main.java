package com.tangzhangss.factory;

public class main {
    public static void main(String[] args) {

        //利用多态的性质创建
        Letter letter = new A();
        Letter letter2 = new B();
        System.out.println(letter.get());
        System.out.println(letter2.get());

        //简单工厂模式 唯一工厂类，一个产品抽象类
        Letter letter3=LetterFactory.getLetter("A");
        Letter letter4=LetterFactory.getLetter("B");
        System.out.println(letter3.get());
        System.out.println(letter4.get());

        //工厂方法模式 多个工厂类，一个产品抽象类  如果不知道具体工厂也可以再用简单工厂模式套一下实现动态^_^
        LetterFactoryM letterFactoryMA = new LetterFactoryMA();
        LetterFactoryM letterFactoryMB = new LetterFactoryMB();
        Letter letter5=letterFactoryMA.getLetter();
        Letter letter6=letterFactoryMB.getLetter();
        System.out.println(letter5.get());
        System.out.println(letter6.get());
        //抽象工厂模式 多个工厂类，多个产品抽象类 不常用不写了...
    }
}

package com.tangzhangss.factory;

public class LetterFactoryMB implements LetterFactoryM{
    @Override
    public Letter getLetter() {
        return new B();
    }
}

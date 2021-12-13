package com.tangzhangss.factory;

public class LetterFactoryMA implements LetterFactoryM{
    @Override
    public Letter getLetter() {
        return new A();
    }
}

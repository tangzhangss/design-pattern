package com.tangzhangss.factory;

import java.util.HashMap;

/**
 * 字母工厂-工厂模式
 *
 * 工厂模式是创建型模式  策略模式是行为型模式
 *
 * 工厂模式运用了策略模式
 */
public class LetterFactory{

    public static Letter getLetter(String beanName){
        //这里模拟获取spring的bean
        //return applicationContextUtils.getBean(beanName);

        //or每次初始化就放入指定的Map里面就可以不用if else判断


        Letter letter=null;
        switch(beanName.toUpperCase()){
            case "A": letter=new A();break;
            case "B": letter=new B();break;
        }

        return letter;

    }
}

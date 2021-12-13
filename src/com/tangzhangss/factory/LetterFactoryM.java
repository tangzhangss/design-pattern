package com.tangzhangss.factory;

/**
 * 工厂方法--如果有修改，新增工厂就实现这个接口，省去了常规的if else判断
 */
public interface LetterFactoryM {
    Letter getLetter();
}

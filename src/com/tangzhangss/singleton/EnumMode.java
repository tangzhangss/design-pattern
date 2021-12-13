package com.tangzhangss.singleton;

/**
 * 枚举实现单例
 * 最简单
 */
public enum  EnumMode {
    Instance;
}

class Test{
    public static void main(String[] args) {
        System.out.println(EnumMode.Instance==EnumMode.Instance);//false
    }
}

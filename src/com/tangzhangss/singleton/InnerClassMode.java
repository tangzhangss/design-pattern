package com.tangzhangss.singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 静态内部类
 *
 * 可以实现懒加载
 *
 * 存在问题
 * 反序列化(static属性不会参与序列化)
 * 反射攻击问题(由于构造方法是private的所以在其他类中不能调用 , 但是通过反射却能在其他类中调用这个私有的构造方法 , 从而构造出新的实例对象)
 *
 *【除了枚举单例，其他的单例模式都存在以上的问题】
 *
 * readResolve可以解决序列化的问题
 *
 */
public class InnerClassMode implements Serializable{

    public String name="aaa";
    public String name2="vvv";

    private static final long serialVersionUID=1l;

    private static class SingletonHolder {
        private static InnerClassMode instance = new InnerClassMode();
    }

    private InnerClassMode() {

    }

    public static InnerClassMode getInstance() {
        return SingletonHolder.instance;
    }

    public static void main(String[] args) throws Exception {


        InnerClassMode singleton = InnerClassMode.getInstance();

        //反射
        Constructor<InnerClassMode> constructor = InnerClassMode.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        InnerClassMode newSingleton = constructor.newInstance();
        System.out.println(singleton == newSingleton);//false

        //序列化
        File file = new File("serialize.ser");
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(singleton);
            try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))){
                InnerClassMode newSingleton2 = (InnerClassMode) inputStream.readObject();

                System.out.println(newSingleton2==singleton);//false
            }
        }




    }
}

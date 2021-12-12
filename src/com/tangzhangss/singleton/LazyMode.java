package com.tangzhangss.singleton;

/**
 * 懒汉式单例（一般形式）
 * 这样写会出现多线程安全问题
 */
public class LazyMode {
    private static LazyMode single;
    private LazyMode(){}


    public static LazyMode getInstance(){
        if(single==null){
            try {
                //模式实例化 加长时间
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            single=new LazyMode();
        }
        return  single;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                //可以看出获取的对象并非一样
                System.out.println(LazyMode.getInstance().hashCode());;
            }).start();
        }
    }

}


/**
 * 懒汉式单例（同步模式1）
 */
class LazyModeSync {
    private static LazyModeSync single;
    private LazyModeSync(){}


    //由于在方法体加锁 效率低下（同时只能获取一个实例）
    public static synchronized LazyModeSync getInstance(){
        if(single==null){
            try {
                //模式实例化 加长时间
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            single=new LazyModeSync();
        }
        return  single;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(LazyModeSync.getInstance().hashCode());;
            }).start();
        }
    }

}

/**
 * 懒汉式单例（同步模式2 双重检索）
 */
class LazyModeSync2 {
    //保证可见性 禁止指令重排序
    private static volatile LazyModeSync2 single;
    private LazyModeSync2(){}


    public static  LazyModeSync2 getInstance(){
        if(single==null){
            synchronized(LazyModeSync2.class){
                if(single==null){
                    try {
                        //实例化 加长时间
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    single=new LazyModeSync2();
                }
            }
        }
        return  single;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(LazyModeSync2.getInstance().hashCode());;
            }).start();
        }
    }

}


package com.yibu.modulestudy.concurrent.死锁场景;


public class DeadLockDemo {

    // 1.创建资源
    private static Object resourceA = new Object();
    private static Object resourceB = new Object();

    public static void main(String[] args) {
        //2. 创建线程A
        Thread threadA = createThreadA();
        //3. 创建线程B
//        Thread threadB = createThreadB(); /*死锁*/
        Thread threadB = createThreadB_资源有序分配法(); /*使用资源有序分配法解决死锁问题*/
        //4. 启动线程
        threadA.start();
        threadB.start();
    }


    private static Thread createThreadA() {
        Thread threadA = new Thread(() -> {
            //2.1尝试获取资源A
            synchronized (resourceA) {
                System.out.println(Thread.currentThread() + " got ResourceA");
                //2.2休眠1s
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get ResourceB");
                //2.3尝试获取资源B
                synchronized (resourceB) {
                    System.out.println(Thread.currentThread() + "got ResourceB");
                }
            }
        }, "ThreadA");
        return threadA;
    }


    private static Thread createThreadB() {
        Thread threadB = new Thread(() -> {
            //3.1 尝试获取资源B
            synchronized (resourceB) {
                System.out.println(Thread.currentThread() + " got ResourceB");
                //3.2 休眠1s
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get ResourceA");
                //3.3 尝试获取资源A
                synchronized (resourceA) {
                    System.out.println(Thread.currentThread() + "got ResourceA");
                }
            }
        }, "ThreadB");
        return threadB;
    }


    private static Thread createThreadB_资源有序分配法() {
        Thread threadB = new Thread(() -> {
            //3.1 尝试获取资源A
            synchronized (resourceA) {
                System.out.println(Thread.currentThread() + " got ResourceA");
                //3.2 休眠1s
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get ResourceB");
                //3.3 尝试获取资源B
                synchronized (resourceB) {
                    System.out.println(Thread.currentThread() + "got ResourceB");
                }
            }
        }, "ThreadB");
        return threadB;
    }
}
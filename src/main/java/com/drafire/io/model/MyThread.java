package com.drafire.io.model;

/**
 * 自定义线程实体
 */
public class MyThread extends Thread {

    private int count = 5;

    public MyThread(String name) {
        super();
        this.setName(name);
    }

//    @Override
//    public void run() {
//        super.run();
//        while (count > 0) {
//            count--;
//            System.out.println("由 " + this.currentThread().getName()
//                    + " 计算，count=" + count);
//        }
//    }

    /**
     * 加上同步进行测试
     */
    @Override
    public synchronized void run() {
        super.run();
        while (count <10000) {
            count++;
            System.out.println("由 " + this.currentThread().getName()
                    + " 计算，count=" + count+"->"+this.currentThread().getId());
        }
    }

    public synchronized void service1(){
        System.out.println("进入锁1");
        //service1的锁还没释放，就执行了service()2，证明锁是可重入的。因为，这是统一把锁
        service2();
        System.out.println("进入锁11");
    }

    public synchronized void service2(){
        System.out.println("进入锁2");
        service3();
        System.out.println("进入锁22");
    }
    public synchronized void service3(){
        System.out.println("进入锁3");
    }

}

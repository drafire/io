package com.drafire.io.model;

import com.drafire.io.Service.ReentrantLockService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.locks.ReentrantLock;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyThreadTest {

    @Test
    public void test1() {
        MyThread a = new MyThread("A");
        MyThread b = new MyThread("B");
        MyThread c = new MyThread("C");
        a.start();
        b.start();
        c.start();
    }

    /**
     * 测试中断方法
     */
    @Test
    public void testInterrupt() throws InterruptedException {
        MyThread a = new MyThread("A");
        a.start();
        //Thread.sleep(2000);
        //调用interrupt()的时候，线程不会立即结束，而是run()执行完才会结束
        a.interrupt();
        System.out.println("中断线程，时间:" + System.currentTimeMillis());
    }

    /**
     * 测试可重入锁---因为锁是同一把锁，也就是说，是同一个对象的锁
     */
    @Test
    public void testReentryLock(){
        MyThread a = new MyThread("A");
        a.service1();
    }

    /**
     * 使用ReenTrantLock 测试可重入锁
     */
    @Test
    public void testReenTrantLock(){
        ReentrantLockService service=new ReentrantLockService();
        service.testMethod();
    }
}
package com.drafire.io.model;

public class Tee {
    public static void main(String[] args) {

        MyThread2[] mythreadArray = new MyThread2[100];
        for (int i = 0; i < 100; i++) {
            mythreadArray[i] = new MyThread2();
        }

        for (int i = 0; i < 100; i++) {
            mythreadArray[i].start();
        }
    }

}
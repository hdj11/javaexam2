package com.isoft;

import java.util.Scanner;

public class BoilThread extends  Thread {
    @Override
    public void run() {
        System.out.println("烧水。。。");
        try{
            Thread.sleep(15000);//睡眠状态
            System.out.println("水烧开了");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

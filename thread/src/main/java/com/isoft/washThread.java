package com.isoft;

import java.util.Scanner;

public class washThread implements  Runnable {
    public void run() {
        System.out.println("开始刷杯子");
        int i=1;
        while (true){
            try {
                Thread.sleep(1500);
                System.out.println("是否继续刷杯子");
                Scanner sc=new Scanner(System.in);
                int c=sc.nextInt();
                if(c==1){
                    System.out.println("刷了第" + i++ + "个杯");
                    if (i == 5)
                        break;
                }
                else {
                    System.out.println("杯子没刷完");
                    break;
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        System.out.println("杯子刷完了，可以泡茶了");

    }
}

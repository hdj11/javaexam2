package com.isoft.beam3;

import java.util.Scanner;

public class Bank implements  Runnable {
    Acconut acconut;
    Object obj;
   Scanner sc;
    public Bank(Acconut acconut,Object obj) {
        sc= new Scanner(System.in);
        this.acconut = acconut;
        this.obj=obj;
    }

    public void run() {
        synchronized (obj){
            while(acconut.getMoney()>0){
                System.out.println("请到"+Thread.currentThread().getName()+"去取款");
                System.out.println("请输入要取的金额");
                double drawmoney=sc.nextDouble();
                if(acconut.getMoney()<drawmoney){
                    System.out.println("账户余额不足，剩余金额为："+acconut.getMoney()+"元");
                }
                else{
                    acconut.draw(drawmoney);
                    System.out.println(acconut.getName()+"成功取了"+drawmoney+"元，剩余金额为"+acconut.getMoney()+"元");
                    break;
                }

            }
        }

    }
}

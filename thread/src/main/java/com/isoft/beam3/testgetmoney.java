package com.isoft.beam3;

import java.util.Scanner;

//模拟银行取款
class Acconut{
    String name;
    double money;
    public Acconut(){

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户姓名");
        name=sc.next();
        System.out.println("请输入开户金额");
        money=sc.nextDouble();
    }
    public void draw(double money){
        this.money-=money;
    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
public class testgetmoney {
    public static void main(String[] args) {
        Acconut acconut=new Acconut();
        Bank bank=new Bank(acconut,"中国银行");
        Thread t1=new Thread(bank);
        t1.setName("窗口一");
        Thread t2=new Thread(bank);
        t2.setName("窗口二");
        t1.start();
        t2.start();

    }


}

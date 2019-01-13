package com.isoft;

import jdk.internal.org.objectweb.asm.util.TraceAnnotationVisitor;

class  Wash{
    public synchronized void wash(String name){
        for(int i=100;i>=0;i--){
            System.out.println(Thread.currentThread().getName()+"还剩"+i+"个杯子");
            try{
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class T3 extends  Thread{
    Wash w;


    public T3(Wash wash) {
        this.w = wash;
    }

    @Override
    public void run() {
       w.wash(Thread.currentThread().getName());
    }
}
class T4 extends  Thread{

    Wash w;

    public T4(Wash wash) {
        this.w = wash;
    }

    @Override
    public void run() {
        w.wash(Thread.currentThread().getName());
    }
}
public class testSynchronized {
    public static void main(String[] args) {
        Wash wash=new Wash();
        new T3(wash).start();
        new T4(wash).start();
    }
}

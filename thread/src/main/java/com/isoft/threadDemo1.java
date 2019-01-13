package com.isoft;
class T1 extends  Thread{
    int i=0;
    public void run() {

        while (i<20) {
            System.out.println("T1");
            if(i>10)
            {
                Thread.yield();//有小问题
                System.out.println("yeild");
            }
            i++;
        }
        //System.out.println(Thread.interrupted());
    }
}
class T2 implements  Runnable{
    public void run() {
        try {
            Thread.sleep(10);
            System.out.println("T2");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
public class threadDemo1 {
    public static void main(String[] args) {
        T1 t1=new T1();
        t1.start();
        System.out.println(t1.getPriority());
        T2 t2=new T2();
        Thread t3=new Thread(t2);
        t3.setPriority(10);
        t3.start();
        System.out.println(t3.getPriority());
        Thread th=Thread.currentThread();
        System.out.println(th.getName()+","+th.getPriority()+","
                +th.getState()+","+th.getThreadGroup());

    }


}

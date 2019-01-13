package com.isoft;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.util.concurrent.SynchronousQueue;

class TicketOffice implements  Runnable {
    Object o;
    int ticketcount;

    public TicketOffice(Object o, int ticketcount) {
        this.o = o;
        this.ticketcount = ticketcount;
    }

    public void run() {

        while (ticketcount > 1) {
            synchronized (o) {

                if (ticketcount == 0) {
                    System.out.println("没有票了，终止售卖");
                    break;
                } else
                    System.out.println(Thread.currentThread().getName() + "窗口卖了一张票，还剩" + --ticketcount + "张票");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

    public class testtickt {
        public static void main(String[] args) {
            TicketOffice ticketOffice = new TicketOffice("中国高铁", 100);
            new Thread(ticketOffice, "天津高铁").start();
            new Thread(ticketOffice, "北京高铁").start();
            new Thread(ticketOffice, "重庆高铁").start();

        }
    }


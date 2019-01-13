package com.isoft;

public class testThread {
    public static void main(String[] args) {
        BoilThread boilThread = new BoilThread();//新建状态
        washThread wash = new washThread();
        Thread thread = new Thread(wash);
        boilThread.start();//运行状态
        thread.start();

    }


}

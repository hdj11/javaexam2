package com.isoft.bean;

import jdk.nashorn.internal.scripts.JO;
import org.testng.annotations.Test;

import javax.swing.*;
import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class studentsystem {
    List<Map<String,String>>userList;
    String filename = "studentinfo.txt";
    FileWriter fw;
    BufferedWriter bw;
    //FileReader fr;
    //BufferedReader br;
    Scanner sc;
    RandomAccessFile raf;

    public void login() throws IOException, InterruptedException {
        System.out.println("学生信息管理系统：");
        System.out.print("请输入用户名：");
        String uname=sc.next();
        System.out.println("请输入密码：");
        String upwd=sc.next();
        Map map=new Hashtable();
        map.put(uname,upwd);
        if(userList.contains(map)){
            System.out.print("欢迎");
            System.err.print(uname);
            System.out.println("登录成功");
            startsystem();
        }
        else{
            System.out.println("登录失败");
        }
    }

    public studentsystem() throws IOException {
        userList=new ArrayList<Map<String,String>>();
        Map map1=new Hashtable();
        map1.put("wangwu","1111111");
        userList.add(map1);
        Map map2=new Hashtable();
        map2.put("lisi","1865");
        userList.add(map2);
        Map map3=new Hashtable();
        map3.put("zhangsan","89265254");
        userList.add(map3);
        Map map4=new Hashtable();
        map4.put("xvliu","25254");
        userList.add(map4);

        fw = new FileWriter(filename, true);
        //fr = new FileReader(filename);
        bw = new BufferedWriter(fw);
        //br = new BufferedReader(fr);
        sc=new Scanner(System.in);
        raf=new RandomAccessFile(filename,"r");

    }

    @Test
    public void startsystem() throws IOException, InterruptedException {

        /*fw = new FileWriter(filename, true);
        fr = new FileReader(filename);
        bw = new BufferedWriter(fw);
        br = new BufferedReader(fr);*/
        /*InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);  */
        //sc=new Scanner(System.in);
       /* System.out.println("test System.in");
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.next()); */

        boolean temp = true;
        while (temp) {
            menu.startmenu();
           // String op = JOptionPane.showInputDialog("请输入用户选择");
            System.out.println();
            String op=sc.next();
            switch (op) {
                case "1":
                    addStudentInfo();
                    break;
                case "2":
                    findStudentInfo();
                    break;
                case "3":
                    findAllStudentInfo();
                    break;
                case "4":
                    deleteStudentInfo();
                    break;
                case "5":
                    exitsystem();
                    break;
            }
        }
            //int i = JOptionPane.showConfirmDialog(null, "是否继续使用本系统", "提示",
              //      JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
        System.out.println("是否继续使用本系统？（1：是，0：否）");
        int i=sc.nextInt();
            if (i == 0)
                temp = false;

        System.out.println("欢迎下次再来！");
        bw.close();
        fw.close();
        raf.close();
    }




    private void addStudentInfo() throws IOException {
        boolean temp=true;
        while (temp){
           /* String sid=JOptionPane.showInputDialog("请输入学号：");  //ctrl+d可以复制给下一行
            String name=JOptionPane.showInputDialog("请输入姓名：");
            String sex=JOptionPane.showInputDialog("请输入性别：");
            String score=JOptionPane.showInputDialog("请输入成绩："); */
           System.out.println("请输入学号：");
           String    sid=sc.next();
           System.out.println("请输入姓名：");
           String   name=sc.next();
           System.out.println("请输入性别：");
           String   sex=sc.next();
           System.out.println("请输入成绩：");
           String   score=sc.next();
           bw.write(sid+","+name+","+sex+","+score);
            bw.newLine();
            bw.flush();
            System.out.println("是否继续输入(1:是，0：否)");
            int i=sc.nextInt();
            //int i=JOptionPane.showConfirmDialog(null,"是否继续输入","提示",
              //      JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);
            if(i==0)
                temp=false;
        }

    }

    private void findStudentInfo() throws IOException, InterruptedException {

       // String sid= JOptionPane.showInputDialog("请输入学号：") ;
        raf.seek(0);
        System.out.println("请输入要查找的学号");
        String sid=sc.next();

        String str=raf.readLine();
        System.out.println("查找学生信息");
        System.out.println("--------------------");
        int temp = 0;
        while(str!=null) {
            String[] strarr = str.split(",");
            if (strarr[0].equalsIgnoreCase(sid)) {//字符串比较时，不用==，用equal
                temp += 1;
                System.out.println(temp + ",学号" + strarr[0] + ",姓名："
                        + CharSetConvertUtils.getUtf8(strarr[1]) + ",性别：" + CharSetConvertUtils.getUtf8(strarr[2]) + ",成绩：" + strarr[3]+"分");
            }
            str = raf.readLine();
            Thread.sleep(1000);
        }
        if(temp==0)
            System.out.println("没找到学生信息" );
        System.out.println("---------------");
    }

    private void findAllStudentInfo() throws InterruptedException, IOException {
        try{
            raf.seek(0);
            System.out.println("查找全部信息");
             System.out.println("----------------");
            String rowstr;
            int temp=0;
            while((rowstr=raf.readLine())!=null){
             temp++;
            String[] strarr = rowstr.split(",");
            System.out.println(temp + ",学号" + strarr[0] + ",姓名：" +CharSetConvertUtils.getUtf8( strarr[1])
                    + ",性别：" + CharSetConvertUtils.getUtf8(strarr[2]) + ",成绩：" + strarr[3]+"分");
            Thread.sleep(1000);

        }
        if(temp==0)
            System.out.println("没有任何信息");

        System.out.println("----------------");
    } catch (IOException e){
            e.printStackTrace();
        }

        }

    private void deleteStudentInfo() throws IOException {
        //String sid= JOptionPane.showInputDialog("请输入学号：");//ali+enter可以直接建变量
        raf.seek(0);
        System.out.println("请输入要删除的学号：");
        String sid=sc.next();
        String str=null;
        ArrayList<String> stulist=new ArrayList<>();
        while((str=raf.readLine())!=null){
            if(!str.split(",")[0].equalsIgnoreCase(sid)){
                stulist.add(str);
            }
        }

        fw=new FileWriter(filename);
        Iterator<String> iterator = stulist.iterator();
        while(iterator.hasNext()){
            String row=iterator.next();
            bw.write(row);
            bw.newLine();
        }



    }
    private void exitsystem() {
        /*int temp=JOptionPane.showConfirmDialog(null,"是否真要退出系统",
                "退出提示",JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE);*/
                System.out.println("是否继续使用本系统？（1：是，0：否）");
               int temp=sc.nextInt();

        if(temp==0)
            System.exit(0);
    }



}

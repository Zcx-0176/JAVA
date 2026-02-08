package com.cxz.exception;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class demo1 {
    public static void main(String[] args) {
        try {
            show2();
        } catch (ParseException e) {
           e.printStackTrace();
        }
    }
    public static void show(){
        //运行时异常
        int[] arr = {10,20,30};
        System.out.println(arr[3]);
        String name = null;
        System.out.println(name.length());
        System.out.println(10/0);
    }
    public static void show2() throws ParseException {
        //编译时异常
        String str = "2024-07-09 11:12:13";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = sdf.parse(str); //parse标红了，是编译时异常，提醒程序员这里容易出错
        System.out.println(date);
    }

}

package com.atguigu.chapter1;

/**
 * 多线程
 */
public class TryConcurrency {
    public static void main(String[] args) {

//        readFromDataBase();
//        writeDataToFile();
    }







    private static void readFromDataBase(){
        try {
            println("Begin read data from db");
            Thread.sleep(1000*10L);
            println("Begin read done and start handle it .");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static void writeDataToFile(){
        try {
            println("Begin write data to file");
            Thread.sleep(1000*10L);
            println("write finish .");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }



    private static void println(String message){
        System.out.println(message);
    }
}

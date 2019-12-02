package com.example.demo;

/**
 * Created by Loubing
 * Date 2019/12/2 16:31
 */
public class TestFun {

    public static void main(String args[]) {
        int i = 2;
        Deal.deal(i);
    }

}

class Deal{
    public static void deal(int i){
        Biz biz = new Biz();
        if(i == 1) {
            biz.d1();
        }
        else if (i == 2) {
            biz.d2();
        }
        else if (i == 3) {
            biz.d3();
        }
    }
}


class Biz {

    public void d1(){
        System.out.println("d1 deal biz");
    }

    public void d2(){
        System.out.println("d1 deal biz");
    }

    public void d3(){
        System.out.println("d1 deal biz");
    }

}

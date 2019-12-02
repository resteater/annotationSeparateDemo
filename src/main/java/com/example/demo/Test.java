package com.example.demo;

/**
 * Created by Loubing
 * Date 2019/12/2 16:04
 */
public class Test {


    public static void main(String args[]) {
        int i = 2;
        P obj = F.getObj(i);
        //处理具体业务
        obj.action();
    }

}


class F {
    /**
     * 工厂模式
     * 根据参数i  得到具体处理业务的类
     * @param i
     * @return
     */
    public static P getObj(int i) {
        if (i == 1) {
            return new S1();
        } else if (i == 2) {
            return new S2();
        } else if (i == 3) {
            return new S3();
        }
        return null;
    }
}

/**
 * 抽象父类P
 */
abstract class P {

    public abstract String action();

}

/**
 * 子类S1
 */
class S1 extends P {

    @Override
    public String action() {
        return "S1 deal biz";
    }
}

/**
 * 子类S2
 */
class S2 extends P {

    @Override
    public String action() {
        return "S2 deal biz";
    }
}

/**
 * 子类S3
 */
class S3 extends P {

    @Override
    public String action() {
        return "S3 deal biz";
    }
}


package com.example.demo;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Loubing
 * Date 2019/12/2 16:17
 */
public class TestNew {

    public static void main(String args[]) {
        int i = 2;
        PN pn = TestCfg.getTestHandler(i);
        pn.action();
    }

}


/**
 * 初始化
 * 如果这里不是用的spring框架，可以想其它办法识别TestAnnotation注解的类并初始化
 */
@Configuration
class TestCfg implements ApplicationContextAware {

    private static Map<Integer, PN> map = new HashMap<>();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, Object> beans = applicationContext.getBeansWithAnnotation(TestAnnotation.class);
        if (beans != null && beans.size() > 0) {
            beans.forEach((k, v) -> {
                Integer bs = v.getClass().getAnnotation(TestAnnotation.class).i();
                map.put(bs, (PN) v);
            });
        }
    }

    public static PN getTestHandler(Integer i) {
        return map.get(i);
    }

}

/**
 * 抽象父类P
 */
abstract class PN {

    public abstract String action();

}

/**
 * 子类S1
 */
@TestAnnotation(i=1)
class SN1 extends PN {

    @Override
    public String action() {
        return "S1 deal biz";
    }
}

/**
 * 子类S2
 */
@TestAnnotation(i=2)
class SN2 extends PN {

    @Override
    public String action() {
        return "S2 deal biz";
    }
}

/**
 * 子类S3
 */
@TestAnnotation(i=3)
class SN3 extends PN {

    @Override
    public String action() {
        return "S3 deal biz";
    }
}

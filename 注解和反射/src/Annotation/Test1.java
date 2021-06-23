package Annotation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LYJ
 * @create 2021-05-25 21:09
 * 什么是注解
 */
public class Test1 {
    // @Override 是重写的注解
    @Override
    public String toString() {
        return super.toString();
    }
    // @Deprecated不推荐使用，但是可以使用，不安全或者有更好的替代选择。
    @Deprecated
    public void test(){

    }
    @SuppressWarnings("all")
    public void test01(){
        List<Integer> list = new ArrayList<>();
    }
}

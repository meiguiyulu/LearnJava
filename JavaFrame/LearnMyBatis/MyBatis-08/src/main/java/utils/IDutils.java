package utils;

import java.util.UUID;

/**
 * @author LYJ
 * @create 2021-06-24 10:16
 */
public class IDutils {

    public static String getId(){
        return UUID.randomUUID().toString().replace("-","");
    }

    public static void main(String[] args) {
        System.out.println(getId());
        System.out.println(getId());
        System.out.println(getId());
    }

}

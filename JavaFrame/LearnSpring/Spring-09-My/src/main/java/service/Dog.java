package service;

/**
 * @author LYJ
 * @create 2021-06-29 19:37
 */
public class Dog implements Animal{

    @Override
    public void bark() {
        System.out.println("汪汪汪~");
    }
}

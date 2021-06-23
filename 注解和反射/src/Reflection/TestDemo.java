package Reflection;

import java.lang.reflect.Field;

/**
 * @author LYJ
 * @create 2021-06-15 9:13
 * 反馈注解与反射的学习
 */
public class TestDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {

        Dog dog = new Dog();
        Class c = Class.forName("Reflection.Dog");
        System.out.println(dog.getClass());
        System.out.println(Dog.class);
        System.out.println(c);
        System.out.println("===============================================");

        ClassLoader currLoader = c.getClassLoader();
        System.out.println("Dog类的类加载器:\t" + currLoader);
        ClassLoader currParent = currLoader.getParent();
        System.out.println("Dog类的类加载器的父类加载器:\t" + currParent);
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println("系统类加载器\t" + systemClassLoader);
        ClassLoader parentLoader = systemClassLoader.getParent();
        System.out.println("系统类加载器的父类加载器:\t" + parentLoader);
        System.out.println("===============================================");

        System.out.println("获取类的名字");
        System.out.println("getName:\t" + c.getName());
        System.out.println("getName:\t" + c.getSimpleName());

        System.out.println("获取类的属性");
        Field[] fields = c.getFields();
        for (Field field:fields){
            System.out.println("getFields:\t" + field);
        }
        fields = c.getDeclaredFields();
        for (Field field:fields){
            System.out.println("getDeclaredFields:\t" + field);
        }
        Field name = c.getDeclaredField("name");
        System.out.println(name);

        System.out.println("获取类的方法");


    }
}

class Dog{
    private String name;
    private int id;

    public Dog() {
    }

    public Dog(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}

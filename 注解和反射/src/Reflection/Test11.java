package Reflection;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * 反射操作注解
 */
public class Test11 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c = Class.forName("Reflection.Student2");
        //通过反射获取注解
        Annotation[] annotations = c.getAnnotations();
        for (Annotation annotation : annotations){
            System.out.println(annotation);
        }
        System.out.println("=================================");

        // 获取注解的value值
        Tablekuang tablekuang = (Tablekuang) c.getAnnotation(Tablekuang.class);
        String value = tablekuang.value();
        System.out.println(value);
        System.out.println("=================================");

        // 获得类指定的注解
        Field field = c.getDeclaredField("id");
        Fieldkuang annotation = field.getAnnotation(Fieldkuang.class);
        System.out.println(annotation.columnName());
        System.out.println(annotation.type());
        System.out.println(annotation.length());
        System.out.println("=================================");
    }
}

@Tablekuang("db_student")
class Student2{
    @Fieldkuang(columnName = "db_name", type = "varchar", length = 3)
    private String name;
    @Fieldkuang(columnName = "db_age", type = "int", length = 10)
    private int age;
    @Fieldkuang(columnName = "db_id", type = "int", length = 10)
    private int id;

    public Student2() {
    }

    public Student2(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}

// 类名的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Tablekuang{
    String value();
}

// 属性的注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Fieldkuang{
    String columnName();
    String type();
    int length();
}

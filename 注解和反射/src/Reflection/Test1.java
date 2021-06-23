package Reflection;

/**
 * @author LYJ
 * @create 2021-05-31 18:49
 * 测试Class类的创建方式
 */
public class Test1 {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Student();
        System.out.println("这个人是: " + person.name);

        // 方式一：通过类型.class获得
        Class c1 = Student.class;
        // 方式二：通过对象获得
        Class c2 = person.getClass();

        // 方式三：forName获得
        Class c3 = Class.forName("Reflection.Student");

        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());

        // 方式四：基本内置类型的包装类有一个TYPE属性
        Class<Integer> type = Integer.TYPE;
        System.out.println(type);

        // 获得父类类型
        System.out.println("父类属性：" + c1.getSuperclass());

        // 获得当前类的接口
        System.out.println("当前类的接口: " + c1.getInterfaces());

        // 获得当前Class对象所表示的实体
        System.out.println("当前类对象所表示的实体: " + c1.getName());
        // 获得该类的类加载器
        System.out.println("该类的类加载器：" + c1.getClassLoader());
    }
}

class Person{
    public String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Student extends Person{
    public Student() {
        this.name = "学生";
    }
}

class Teacher extends Person{
    public Teacher() {
        this.name = "老师";
    }
}

package pojo;

/**
 * @author LYJ
 * @create 2021-06-27 12:45
 */
public class User {
    private String name;

    //    public User(){
//        System.out.println("User类的无参构造!");
//    }
    public User(String name) {
        this.name = name;
        System.out.println("User类的有参构造!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void showName() {
        System.out.println("name\t=\t" + name);
    }
}

package LearnJUC.Stream;

/**
 * @author LYJ
 * @create 2021-05-10 18:39
 */
public class User {
    int id;
    String name;
    int age;
    public User(int id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }
    public int GetId(){
        return this.id;
    }
    public String GetName(){
        return this.name;
    }
    public int GetAge(){
        return this.age;
    }
}

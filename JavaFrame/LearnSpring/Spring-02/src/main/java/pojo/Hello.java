package pojo;

/**
 * @author LYJ
 * @create 2021-06-26 17:07
 */
public class Hello {
    private String name;

    public Hello(String name) {
        this.name = name;
    }

    public Hello() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "name='" + name + '\'' +
                '}';
    }
}

package pojo;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author LYJ
 * @create 2021-06-29 9:53
 */

public class User {

    private String name;

    public String getName() {
        return name;
    }

    @Value("刘云杰")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}

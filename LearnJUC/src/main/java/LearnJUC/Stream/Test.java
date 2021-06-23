package LearnJUC.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author LYJ
 * @create 2021-05-10 18:40
 */
public class Test {
    public static void main(String[] args) {
        User user1 = new User(1, "a", 21);
        User user2 = new User(2, "b", 22);
        User user3 = new User(3, "c", 23);
        User user4 = new User(4, "d", 24);
        User user5 = new User(5, "e", 25);
        User user6 = new User(6, "f", 26);
        // 集合就是存储
        List<User> list = Arrays.asList(user1, user2, user3, user4, user5, user6);
        // 计算交给Stream流
        list.stream()
                .filter(user -> {return user.GetId()%2==0;})  // id是偶数的
                .filter(user -> {return user.GetAge()>23;})   // 年龄大于23的
                .map(user -> {return user.GetName().toUpperCase();}) // 用户名变为大写
                .sorted((u1, u2)->{return u2.compareTo(u1);}) // 倒序排序
                .limit(1) // 只输出一个
                .forEach(System.out::println);

    }
}

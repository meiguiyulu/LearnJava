package jdbc;

import java.sql.*;

/**
 * @author LYJ
 * @create 2021-06-20 11:01
 * 我的第一个JDBC程序
 */
public class jdbcDemo1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        /**
         * 1、加载驱动
         * 固定写法
         * MySQL 8.0以上: Class.forName("com.mysql.cj.jdbc.Driver")
         *      以下: Class.forName("com.mysql.jdbc.Driver")
         */
        Class.forName("com.mysql.cj.jdbc.Driver");

        /**
         * 2、用户信息和url
         * useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=UTC
         */
        String url = "jdbc:mysql://localhost:3306/jdbcstudy?useUnicode=true&characterEncoding=utf8&useSSL=true";
        String username = "root";
        String password = "7012+2";

        /**
         * 3、连接成功，创建数据库对象
         * connection 代表数据库
         */
        Connection connection = DriverManager.getConnection(url, username, password);

        /**
         * 4、执行SQL对象
         * statement执行SQL语句
         */
        Statement statement = connection.createStatement();

        /**
         * 5、执行SQL语句
         */
        String sql ="SELECT * FROM users";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            System.out.println("id=\t" + resultSet.getObject("id"));
            System.out.println("name=\t" + resultSet.getObject("NAME"));
            System.out.println("password=\t" + resultSet.getObject("PASSWORD"));
            System.out.println("email=\t" + resultSet.getObject("email"));
            System.out.println("birthday=\t" + resultSet.getObject("birthday"));
            System.out.println("========================");
        }

        /**
         * 6、释放连接
         */
        resultSet.close();;
        statement.close();
        connection.close();
    }
}

package jdbc;

import jdbc.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author LYJ
 * @create 2021-06-21 20:08
 */
public class TestSQLInjection {
    public static void main(String[] args) {
        // 正常登录
//        Login("liuyun","123456");
        // 不正常登录
        Login(" ' or '1==1", "' or '1==1");
    }

    // 登陆业务
    public static void Login(String username, String password){

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = JdbcUtils.getConnection();
            statement = connection.createStatement();

            String sql = "SELECT * FROM users WHERE `NAME` = '" + username +
                    "' AND `PASSWORD` = '" + password + "'";

            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.println("name:\t" + resultSet.getString("NAME"));
                System.out.println("password:\t" + resultSet.getString("PASSWORD"));
                System.out.println("================================================");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.releaseConnection(connection, statement, resultSet);
        }

    }
}

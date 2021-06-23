package TestePrepareStament;

import jdbc.utils.JdbcUtils;

import java.sql.*;

/**
 * @author LYJ
 * @create 2021-06-21 21:31
 */
public class TestSQLInjection {
    public static void main(String[] args) {
        // 正常登录
//        Login("liuyun","123456");
        // 不正常登录
        Login("'' or 1==1", "'' or 1==1");
    }

    // 登陆业务
    public static void Login(String username, String password) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = JdbcUtils.getConnection();


            String sql = "SELECT * FROM users WHERE `NAME` = ? AND `PASSWORD` = ?";
            statement = connection.prepareStatement(sql);

            statement.setString(1, username);
            statement.setString(2, password);

            resultSet = statement.executeQuery();
            while (resultSet.next()) {
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

package jdbc;

import jdbc.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author LYJ
 * @create 2021-06-20 22:02
 * 测试修改
 */
public class TestUpdate {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // 获取数据库连接
            connection = JdbcUtils.getConnection();
            // 获得SQL的执行对象
            statement =connection.createStatement();
            String sql = "UPDATE users SET `NAME`='yunxiaojie', `email`='1609226090@qq.com'\n" +
                    "WHERE `id` = 1;";

            int i = statement.executeUpdate(sql);
            if (i>0){
                System.out.println("修改成功!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.releaseConnection(connection, statement, resultSet);
        }
    }
}

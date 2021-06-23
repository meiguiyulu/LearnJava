package jdbc;

import jdbc.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author LYJ
 * @create 2021-06-20 21:59
 * 测试删除数据
 */
public class TestDelete {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // 获取数据库连接
            connection = JdbcUtils.getConnection();
            // 获得SQL的执行对象
            statement =connection.createStatement();
            String sql = "delete from users where id = 4";

            int i = statement.executeUpdate(sql);
            if (i>0){
                System.out.println("删除成功!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.releaseConnection(connection, statement, resultSet);
        }
    }
}

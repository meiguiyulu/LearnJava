package jdbc;

import jdbc.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author LYJ
 * @create 2021-06-20 18:27
 * 测试插入数据
 */
public class TestInsert {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // 获取数据库连接
            connection = JdbcUtils.getConnection();
            // 获得SQL的执行对象
            statement =connection.createStatement();
            String sql = "INSERT INTO `users`(`id`,`NAME`,`PASSWORD`,`email`,`birthday`)\n" +
                    "VALUES(4,'liuyun','123456','liuyun@sina.com','1998-11-04')";

            int i = statement.executeUpdate(sql);
            if (i>0){
                System.out.println("插入成功!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.releaseConnection(connection, statement, resultSet);
        }

    }
}

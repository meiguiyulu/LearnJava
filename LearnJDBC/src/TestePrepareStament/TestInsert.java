package TestePrepareStament;

import jdbc.utils.JdbcUtils;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author LYJ
 * @create 2021-06-21 20:29
 */
public class TestInsert {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = JdbcUtils.getConnection();

            // 预编译SQL
            String sql = "INSERT INTO `users`(`id`,`NAME`,`PASSWORD`,`email`,`birthday`) " +
                    "VALUES(?,?,?,?,?)";
            statement = connection.prepareStatement(sql);
            // 手动传参
            statement.setInt(1, 5);
            statement.setString(2, "liuyunjie");
            statement.setString(3, "123123");
            statement.setString(4, "1609226090@qq.com");
            // 注意：sql.Date        java.sql.Date()
            // utils.Date           new Date().getTime() 获得时间戳
            statement.setDate(5, new java.sql.Date(new Date().getTime()));
            // 执行
            int i = statement.executeUpdate();
            if (i>0){
                System.out.println("插入成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.releaseConnection(connection, statement, null);
        }

    }
}

package TestePrepareStament;

import jdbc.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 * @author LYJ
 * @create 2021-06-21 21:16
 */
public class TestDelete {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = JdbcUtils.getConnection();

            String sql = "delete from users where id=?";
            statement = connection.prepareStatement(sql);

            // 手动传递参数
            statement.setInt(1, 5);

            // 执行
            int i = statement.executeUpdate();
            if (i>0){
                System.out.println("删除成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.releaseConnection(connection, statement, null);
        }
    }
}

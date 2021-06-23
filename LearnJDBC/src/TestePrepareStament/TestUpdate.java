package TestePrepareStament;

import jdbc.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author LYJ
 * @create 2021-06-21 21:20
 */
public class TestUpdate {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = JdbcUtils.getConnection();

            String sql = "update users set `NAME` = ?  where `id`=?;";
            statement = connection.prepareStatement(sql);

            // 手动传递参数
            statement.setString(1, "liuyunjie");
            statement.setInt(2, 4);

            // 执行
            int i = statement.executeUpdate();
            if (i>0){
                System.out.println("更新成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.releaseConnection(connection, statement, null);
        }
    }
}

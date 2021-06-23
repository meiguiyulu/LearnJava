package learntransaction;

import jdbc.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author LYJ
 * @create 2021-06-21 21:52
 */
public class TestTransaction {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = JdbcUtils.getConnection();
            // 关闭数据库自动提交，会自动开启事务
            connection.setAutoCommit(false);

            String sql1 = "update account set money = money - 100  where name='A';";
            statement = connection.prepareStatement(sql1);
            statement.executeUpdate();

            int x = 1 / 0;

            String sql2 = "update account set money = money + 100 where name = 'B' ;";
            statement = connection.prepareStatement(sql2);
            statement.executeUpdate();


            // 业务完毕，提交事务
            connection.commit();
            System.out.println("成功");


        } catch (SQLException e) {
            // 如果失败则回滚, 默认失败了就回滚
            connection.rollback();
            e.printStackTrace();
        } finally {
            JdbcUtils.releaseConnection(connection, statement, resultSet);
        }

    }
}

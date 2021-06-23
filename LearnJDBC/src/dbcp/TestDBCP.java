package dbcp;

import dbcp.utils.dbcpUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 * @author LYJ
 * @create 2021-06-22 9:26
 */
public class TestDBCP {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = dbcpUtils.getConnection();
            String sql = "insert into users (id, `NAME`, `PASSWORD`, `email`, `birthday`) values (?,?,?,?,?);";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, 5);
            statement.setString(2, "xiesi");
            statement.setString(3, "111111");
            statement.setString(4, "huanghuangk@gmails.com");
            statement.setDate(5, new java.sql.Date(new Date().getTime()));

            int i = statement.executeUpdate();
            if (i>0){
                System.out.println("插入成功");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbcpUtils.ReleaseConnection(connection, statement, null);
        }

    }
}

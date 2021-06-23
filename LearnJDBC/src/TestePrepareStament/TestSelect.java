package TestePrepareStament;

import jdbc.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author LYJ
 * @create 2021-06-21 21:23
 */
public class TestSelect {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = JdbcUtils.getConnection();
            
            String sql = "select * from users where id = ?;";
            statement = connection.prepareStatement(sql);

            statement.setInt(1, 1);
            
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                System.out.println("id:\t" + resultSet.getInt("id"));
                System.out.println("name:\t" + resultSet.getString("NAME"));
                System.out.println("password:\t" + resultSet.getString("PASSWORD"));
                System.out.println("email:\t" + resultSet.getString("email"));
                System.out.println("birthday:\t" + resultSet.getString("birthday"));
                System.out.println("=====================================");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.releaseConnection(connection, statement, resultSet);
        }
    }
}

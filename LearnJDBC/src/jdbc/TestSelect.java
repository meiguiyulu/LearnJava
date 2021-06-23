package jdbc;

import jdbc.utils.JdbcUtils;

import javax.swing.text.Utilities;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author LYJ
 * @create 2021-06-20 22:05
 */
public class TestSelect {
    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = JdbcUtils.getConnection();
            statement = connection.createStatement();
            String sql = "SELECT * FROM users where id = 1";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.println("id:\t" + resultSet.getObject("id"));
                System.out.println("name:\t" + resultSet.getObject("NAME"));
                System.out.println("password:\t" + resultSet.getObject("PASSWORD"));
                System.out.println("email:\t" + resultSet.getObject("email"));
                System.out.println("birthday:\t" + resultSet.getObject("birthday"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.releaseConnection(connection, statement, resultSet);
        }

    }
}

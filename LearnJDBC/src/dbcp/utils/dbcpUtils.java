package dbcp.utils;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author LYJ
 * @create 2021-06-22 9:17
 */
public class dbcpUtils {

    private static DataSource dataSource = null;

    static {
        try {
            InputStream asStream = dbcpUtils.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
            Properties properties = new Properties();
            properties.load(asStream);
            // 创建数据源 工程模式及-->创建对象
            dataSource = BasicDataSourceFactory.createDataSource(properties);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // 获取连接
    public static Connection getConnection() throws SQLException {
        // 从数据源中获取连接
        return dataSource.getConnection();
    }

    // 释放连接
    public static void ReleaseConnection(Connection connection, PreparedStatement statement, ResultSet resultSet) throws SQLException {
        if (resultSet!=null){
            resultSet.close();
        }
        if (statement!=null){
            statement.close();
        }
        if (connection!=null){
            connection.close();
        }
    }
}

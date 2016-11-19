package DatabaseUtil;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by ldy on 2016/11/19.
 */
public class CommonDataBaseUtil {
    private String driver="com.mysql.jdbc.Driver";
    private String url="jdbc:mysql://127.0.0.1:3306/ordersystem";
    private String user="ldy";
    private String pa="abcd1234";
    private static CommonDataBaseUtil commonDataBaseUtil;
    private CommonDataBaseUtil()
    {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static CommonDataBaseUtil getCommonDataBaseUtil()
    {
        if(commonDataBaseUtil==null)
            commonDataBaseUtil=new CommonDataBaseUtil();
        return commonDataBaseUtil;
    }
    public Connection getConnection()
    {
        Connection connection=null;
        try {
            connection= DriverManager.getConnection(url,user,pa);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  connection;
    }


}

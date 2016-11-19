package DatabaseUtil;

import DataObject.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by ldy on 2016/11/19.
 */
public class UserAdo {
    private static  UserAdo userAdo;
    private Connection connection;
    private CommonDataBaseUtil util;
    private UserAdo()
    {
            util=CommonDataBaseUtil.getCommonDataBaseUtil();
    }
    public static UserAdo getUserAdo()
    {
        if(userAdo==null)
            userAdo=new UserAdo();
        return userAdo;
    }

    public User getUserWithName(String name)
    {
        connection=util.getConnection();
        User user = null;
        if(connection!=null)
        {
            try {
                Statement statement=connection.createStatement();
                ResultSet resultSet=statement.executeQuery("SELECT  * FROM usertable  WHERE tname="+name);
                boolean isok=resultSet.next();
                if(!isok)
                    return null;
                user=new User();
                user.setName(resultSet.getString(resultSet.findColumn("tname")));
                user.setEmail(resultSet.getString(resultSet.findColumn("email")));
                user.setPassword(resultSet.getString(resultSet.findColumn("tpassword")));
                user.setIssuper(resultSet.getInt(resultSet.findColumn("issuper")));
                user.setUserid(resultSet.getInt(resultSet.findColumn("uid")));
                user.setProfile(resultSet.getString(resultSet.findColumn("tprofile")));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;

    }
    public User getUserWithEmail(String email)
    {
        connection=util.getConnection();
        User user = null;
        if(connection!=null)
        {
            try {
                Statement statement=connection.createStatement();
                ResultSet resultSet=statement.executeQuery("SELECT  * FROM usertable  WHERE email="+email);
              boolean t=  resultSet.next();
                if(!t)
                    return null;
                user=new User();
                user.setName(resultSet.getString(resultSet.findColumn("tname")));
                user.setEmail(resultSet.getString(resultSet.findColumn("email")));
                user.setPassword(resultSet.getString(resultSet.findColumn("tpassword")));
                user.setIssuper(resultSet.getInt(resultSet.findColumn("issuper")));
                user.setUserid(resultSet.getInt(resultSet.findColumn("uid")));
                user.setProfile(resultSet.getString(resultSet.findColumn("tprofile")));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    public boolean InsertUser(User one)
    {
        String name=one.getName();
        String password=one.getPassword();
        String email=one.getEmail();
        Connection con=util.getConnection();
        try {
            Statement sta=con.createStatement();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



}

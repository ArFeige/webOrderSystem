package DatabaseUtil;

import DataObject.User;
import HelperUtil.Md5Encryption;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by ldy on 2016/11/19.
 */
public class UserAdo {
    private static UserAdo userAdo;
    private Connection connection;
    private CommonDataBaseUtil util;

    private UserAdo() {
        util = CommonDataBaseUtil.getCommonDataBaseUtil();
    }

    public static UserAdo getUserAdo() {
        if (userAdo == null)
            userAdo = new UserAdo();
        return userAdo;
    }

    private User HelpGetUser(String tattr, String name) {
        connection = util.getConnection();
        User user = null;
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT  * FROM usertable  WHERE " + tattr + "=" +"\""+ name+"\"");
                boolean isok = resultSet.next();
                if (!isok)
                    return null;
                user = new User();
                user.setName(resultSet.getString(resultSet.findColumn("tname")));
                user.setEmail(resultSet.getString(resultSet.findColumn("email")));
                user.setPassword(resultSet.getString(resultSet.findColumn("tpassword")));
                user.setIssuper(resultSet.getInt(resultSet.findColumn("issuper")));
                user.setUserid(resultSet.getInt(resultSet.findColumn("uid")));
                user.setProfile(resultSet.getString(resultSet.findColumn("tprofile")));
                user.setAddress(resultSet.getString(resultSet.findColumn("address")));
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

    public User getUserWithName(String name) {
        return HelpGetUser("tname", name);

    }

    public User getUserWithEmail(String email) {
        return HelpGetUser("email", email);
    }

    public boolean InsertUser(User one) throws SQLException {
        String name = one.getName();
        String password = one.getPassword();
        String email = one.getEmail();
        Connection con = util.getConnection();
        boolean t = false;
        try {
            Statement sta = con.createStatement();
            String t1="Insert into usertable(tname,email,tpassword) values("+"\""+name+"\""+","+"\""+email+"\""+","+"\""+password+"\""+")";
//            System.out.println(t1);
            t = sta.execute(t1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        con.close();
        return t;
    }

    public boolean DeleteUserWithName(String name) {
        return HelpDeleteUser("tname", name);
    }

    public boolean DeleteUserWithEmail(String email) {
        return HelpDeleteUser("email", email);
    }

    private boolean HelpDeleteUser(String tname, String name) {
        boolean t = false;
        Connection connecion;
        connecion = util.getConnection();
        try {
            Statement sta = connecion.createStatement();
            t = sta.execute("DELETE  FROM usertable where " + tname + "=" + "\""+name+ "\"");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connecion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connecion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;
    }

    public int UpdateUser(User one) {
        int t = 0;
        String name = one.getName();
        String password = one.getPassword();
        int issuper = one.getIssuper();
        int uid = one.getUserid();
        String profile = one.getProfile();
        String address = one.getAddress();
        Connection con = util.getConnection();
        try {
            Statement sta = con.createStatement();
            String a1="UPDATE  usertable SET tpassword" + "=" + "\""+password+"\"" + "," + "issuper=" + issuper + ",tprofile=" + "\""+profile+"\"" + ",address=" + "\""+address+"\"" + " where " +
                    " uid=" + uid;
//            System.out.println(a1);
            t = sta.executeUpdate(a1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;
    }
    public static  void main(String []args)
    {
        UserAdo userado=UserAdo.getUserAdo();
        User one=new User();
        one.setName("小明");
        one.setEmail("123456@gmail.com");
        one.setPassword(Md5Encryption.stringMD5("no"));
        try {
            userado.InsertUser(one);
            one.setProfile("nothing");
            one.setUserid(8);
            userado.UpdateUser(one);
            userado.DeleteUserWithName("ok");
            User user=userado.getUserWithName("ldy");
            User user1=userAdo.getUserWithEmail("qq1098014590@gmail.com");
            user1.setPassword(Md5Encryption.stringMD5("abcd1234"));
            userado.UpdateUser(user1);
            System.out.println(user);
            System.out.println(user1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

package DatabaseUtil;

import DataObject.User;
import HelperUtil.Md5Encryption;

import javax.jws.soap.SOAPBinding;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ldy on 2016/11/19.
 */
public class UserDAO {
    private static UserDAO userDAO;
    private Connection connection;
    private CommonDataBaseUtil util;

    private UserDAO() {
        util = CommonDataBaseUtil.getCommonDataBaseUtil();
    }

    public static UserDAO getUserDAO() {
        if (userDAO == null)
            userDAO = new UserDAO();
        return userDAO;
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
        int b1=one.getIssuper();
        Connection con = util.getConnection();
        boolean t = false;
        try {
            Statement sta = con.createStatement();
            String t1="Insert into usertable(tname,email,tpassword,issuper) values("+"\""+name+"\""+","+"\""+email+"\""+","+"\""+password+"\""+","+b1+")";
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
        String phoneNumber=one.getPhoneNumber();
        Connection con = util.getConnection();
        try {
            Statement sta = con.createStatement();
            String a1="UPDATE  usertable SET tpassword" + "=" + "\""+password+"\"" + "," + "issuper=" + issuper + ",tprofile=" + "\""+profile+"\"" + ",address=" + "\""+address+"\""+"," +"phoneNumber="+"\""+phoneNumber+"\""+" where " +
                    " uid=" + uid;
//            System.out.println(a1);
            t = sta.executeUpdate(a1);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;
    }
    public List<Integer> getAllUserId()
    {
        List<Integer>lists=null;
        Connection connection=util.getConnection();
        try {
            Statement statement=connection.createStatement();
            ResultSet set=statement.executeQuery("SELECT uid from usertable");
            while (set.next())
            {
                if(lists==null)
                    lists=new ArrayList<>();
                lists.add(set.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lists;

    }
    public static  void main(String []args)
    {
        UserDAO userado= UserDAO.getUserDAO();
        User one=new User();
        one.setName("ldy");
        one.setPassword(Md5Encryption.stringMD5("abcd1234"));
        one.setIssuper(1);
        one.setEmail("qq1098014590@gmail.com");
        //            userado.InsertUser(one);
        one=new User();
        one.setName("hui");
        one.setPassword(Md5Encryption.stringMD5("hui"));
        one.setIssuper(1);
        one.setEmail("12345@qq.com");
//            userado.InsertUser(one);
        one.setName("lin");
        one.setPassword(Md5Encryption.stringMD5("lin"));
        one.setIssuper(1);
        one.setEmail("lin@qq.com");
//            userado.InsertUser(one);
    }


}

package DatabaseUtil;

import DataObject.Order;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ldy on 2016/11/19.
 */
public class OrderDAO {
    private CommonDataBaseUtil util;
    private static OrderDAO orderDAO;

    private OrderDAO() {
        util = CommonDataBaseUtil.getCommonDataBaseUtil();
    }

    public static OrderDAO getOrderDAO() {
        if (orderDAO == null)
            orderDAO = new OrderDAO();
        return orderDAO;
    }

    public List<Order> getOrderWithUid(int uid) {
        return HelpGetOrder("uid", uid);
    }

    public List<Order> getOrderWithPid(int pid) {
        return HelpGetOrder("pid", pid);
    }

    private List<Order> HelpGetOrder(String name, int tid) {
        Connection con = util.getConnection();
        List<Order> lists = null;
        try {
            Statement sta = con.createStatement();
            ResultSet set = sta.executeQuery("SELECT  * FROM  ordertable WHERE " + name + "=" + tid);
            while (set.next()) {
                int id = set.getInt(set.findColumn("id"));
                int pid = set.getInt(set.findColumn("pid"));
                int num = set.getInt(set.findColumn("num"));
                float price = set.getFloat(set.findColumn("price"));
                int isPay = set.getInt(set.findColumn("isPay"));
                int isReturn = set.getByte(set.findColumn("isReturn"));
                Order or = new Order();
                or.setOrderid(id);
                or.setNum(num);
                or.setPid(pid);
                or.setPrice(price);
                or.setIspay(isPay);
                or.setIsReturn(isReturn);
                or.setUid(set.getInt(set.findColumn("uid")));
                if(lists==null)
                    lists=new ArrayList<>();
                lists.add(or);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lists;
    }

    public void InsertAOrder(Order order) {
        Connection con = util.getConnection();
        try {
            Statement sta = con.createStatement();
            int id = order.getOrderid();
            int uid = order.getUid();
            int pid = order.getPid();
            int num = order.getNum();
            float price = order.getPrice();
            int isPay = order.getIspay();
            int isReturn = order.getIsReturn();
            sta.execute("INSERT INTO ordertable(id,uid,pid,num,price,isPay,isReturn) VALUES (" + id + "," + uid + "," + pid + "," + num + "," + price + "," + isPay + "," + isReturn + ")");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 这个是把所有uid相同的删掉，小心，不是一条记录
     */
    public void DeleteSomeOrderWithUid(int uid) {
        HelpDeleteOrders(uid, -1);

    }

    private void HelpDeleteOrders(int uid, int i) {
        Connection con = util.getConnection();
        try {
            Statement sta = con.createStatement();
            if (uid != -1 && i != -1) {
                sta.execute("DELETE FROM ordertable WHERE uid=" + uid + " AND " + "pid=" + i);
            } else if (uid != -1) {
                sta.execute("DELETE FROM ordertable WHERE uid=" + uid);
            } else {
                sta.execute("DELETE FROM ordertable WHERE pid=" + i);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 这个是把所有pid相同的删掉
     */
    public void DeleteSomeOrderWithPid(int pid) {
        HelpDeleteOrders(-1, pid);
    }

    public void DeleteOneOrder(int uid, int pid) {
        HelpDeleteOrders(uid, pid);
    }
    public void UpdateOrder(Order order)
    {
        Connection con=util.getConnection();
        try {
            Statement sta=con.createStatement();
            int orderid=order.getOrderid();
            int uid=order.getUid();
            int num=order.getNum();
            int pid=order.getPid();
            float price=order.getPrice();
            int isPay=order.getIspay();
            int isReturn=order.getIsReturn();
            sta.execute("UPDATE ordertable SET num="+num+","+"price"+"="+price+","+"isPay="+isPay+","+"isReturn="+isReturn+","+"pid="+pid+" WHERE uid="+uid);

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String []args)
    {
        OrderDAO dao=OrderDAO.getOrderDAO();
        Order o1=new Order();
        o1.setUid(16);
        o1.setNum(15);
        dao.InsertAOrder(o1);
        o1.setPrice(99);
        dao.UpdateOrder(o1);
        o1.setPrice(100);
        dao.UpdateOrder(o1);
        o1=new Order();
        o1.setPrice(1000);
        List<Order> o3=dao.getOrderWithUid(16);
        System.out.println(o3.size());
//        dao.DeleteSomeOrderWithUid(16);
    }
}

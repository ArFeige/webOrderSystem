package DatabaseUtil;

import DataObject.ShoppingcarProduct;
import DataObject.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ldy on 2016/11/19.
 */
public class ShoppingCarDAO {
    private static ShoppingCarDAO shoppingCarDAO;
    private CommonDataBaseUtil util;
    private ShoppingCarDAO(){util=CommonDataBaseUtil.getCommonDataBaseUtil();};
    public static ShoppingCarDAO getShoppingCarDAO()
    {
        if(shoppingCarDAO ==null)
            shoppingCarDAO =new ShoppingCarDAO();
        return shoppingCarDAO;
    }
    public List<ShoppingcarProduct> getShopingcarProducts(int uid)
    {
        Connection connection=util.getConnection();
        List<ShoppingcarProduct>lists=new ArrayList<>();
        try {
            Statement statement=connection.createStatement();
            ResultSet set=statement.executeQuery("SELECT * FROM shoppingcar WHERE uid="+uid);
            boolean t=set.next();
            if(!t) {
                return null;
            }
            ProductDAO productDAO = ProductDAO.getProductDAO();
            while (!set.isAfterLast())
            {
                int num=set.getInt(set.findColumn("num"));
                int pid=set.getInt(set.findColumn("pid"));
                Product p= productDAO.getProductWithId(pid);
                ShoppingcarProduct a1=new ShoppingcarProduct();
                a1.setNum(num);
                a1.setProduct(p);
                lists.add(a1);
                set.next();
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lists;
    }
    public void AddShopingCarProduct(ShoppingcarProduct product, int uid)
    {
        Product product1=product.getProduct();
        int n=product.getNum();
        int pid=product1.getId();
        Connection connection=util.getConnection();
        try {
            Statement statement=connection.createStatement();
            statement.execute("INSERT INTO shoppingcar (uid,pid,num) VALUES ("+uid+","+pid+","+n+")");
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void DeleteShoppingCarProductWithPid(int pid)
    {
        Connection connection=util.getConnection();
        try {
            Statement statement=connection.createStatement();
            statement.execute("DELETE  FROM  shoppingcar WHERE pid="+pid);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void UpdateShopingCarProduct(int uid, ShoppingcarProduct shopingcarProduct)
    {
        Connection connection=util.getConnection();
        try {
            Statement statement=connection.createStatement();
            int num=shopingcarProduct.getNum();
            int pid=shopingcarProduct.getProduct().getId();
            statement.execute("UPDATE  shoppingcar SET num"+"="+num+" where uid="+uid+" and "+"pid="+pid);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static  void main(String []args)
    {
        ShoppingCarDAO shoppingCarDAO = ShoppingCarDAO.getShoppingCarDAO();
        ShoppingcarProduct t=new ShoppingcarProduct();
        Product t1=new Product();
        t1.setId(99);
        t1.setName("猕猴桃");
        t1.setPrice(90);
        t.setProduct(t1);
        t.setNum(9);
        shoppingCarDAO.AddShopingCarProduct(t,16);
        t.setNum(99);
        shoppingCarDAO.UpdateShopingCarProduct(16,t);
        List<ShoppingcarProduct> plist= shoppingCarDAO.getShopingcarProducts(16);
        System.out.print(plist.size());
    }
}

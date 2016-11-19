package DatabaseUtil;

import DataObject.Product;
import DataObject.ShopingcarProduct;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ldy on 2016/11/19.
 */
public class ShoppingCarAdo {
    private static ShoppingCarAdo shoppingCarAdo;
    private CommonDataBaseUtil util;
    private ShoppingCarAdo(){util=CommonDataBaseUtil.getCommonDataBaseUtil();};
    public static ShoppingCarAdo getShoppingCarAdo()
    {
        if(shoppingCarAdo==null)
            shoppingCarAdo=new ShoppingCarAdo();
        return shoppingCarAdo;
    }
    public List<ShopingcarProduct> getShopingcarProducts(int uid)
    {
        Connection connection=util.getConnection();
        List<ShopingcarProduct>lists=new ArrayList<>();
        try {
            Statement statement=connection.createStatement();
            ResultSet set=statement.executeQuery("SELECT * FROM shoppingcar WHERE uid="+uid);
            boolean t=set.next();
            if(!t) {
                return null;
            }
            ProductAdo productAdo=ProductAdo.getProductAdo();
            while (!set.isAfterLast())
            {
                int num=set.getInt(set.findColumn("num"));
                int pid=set.getInt(set.findColumn("pid"));
                Product p=productAdo.getProductWithId(pid);
                ShopingcarProduct a1=new ShopingcarProduct();
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
    public void AddShopingCarProduct(ShopingcarProduct product,int uid)
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
    public void UpdateShopingCarProduct(int uid,ShopingcarProduct shopingcarProduct)
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
        ShoppingCarAdo shoppingCarAdo=ShoppingCarAdo.getShoppingCarAdo();
        ShopingcarProduct t=new ShopingcarProduct();
        Product t1=new Product();
        t1.setId(99);
        t1.setName("猕猴桃");
        t1.setPrice(90);
        t.setProduct(t1);
        t.setNum(9);
        shoppingCarAdo.AddShopingCarProduct(t,16);
        t.setNum(99);
        shoppingCarAdo.UpdateShopingCarProduct(16,t);
        List<ShopingcarProduct> plist=shoppingCarAdo.getShopingcarProducts(16);
        System.out.print(plist.size());
    }
}

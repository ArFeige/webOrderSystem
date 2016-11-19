package DatabaseUtil;

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
public class ProductAdo {
    private CommonDataBaseUtil util;
    private static ProductAdo productAdo;
    private  ProductAdo(){
        util=CommonDataBaseUtil.getCommonDataBaseUtil();
    }
    public static ProductAdo getProductAdo()
    {
        if(productAdo==null)
            productAdo=new ProductAdo();
        return productAdo;
    }
    public List<Integer>getAllProductId()
    {
        List<Integer>list = null;
        Connection connection=util.getConnection();
        try {
            Statement statement=connection.createStatement();
            ResultSet  set=statement.executeQuery("SELECT pid FROM product");
            while(set.next())
            {
                if(list==null)
                    list=new ArrayList<>();
                list.add(set.getInt(set.findColumn("pid")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }
    public void InsertNewProduct(Product product)
    {
        Connection con=util.getConnection();
        String na=product.getName();
        if(IsProductExistWithName(na))
            return;
        String title=product.getTitle();
        String headicon=product.getHeadicon();
        int stocknum=product.getStocknumber();
        String des=product.getDesdetail();
        float price=product.getPrice();
        float discountprice=product.getDiscountPrice();
        try {
            Statement sta=con.createStatement();
            sta.execute("INSERT INTO product (tname,title,headicon,stocknumber,des,price,discountprice) VALUES ("+"\""+na+"\""+","
            +"\""+title+"\""+","+"\""+headicon+"\""+","+"\""+stocknum+"\""+","+"\""+des+"\""+","+"\""+price+"\""+","+"\""+discountprice+"\""+")");
            if(product.getDespictures()!=null) {
                for (String m : product.getDespictures()) {
                    sta.execute("INSERT INTO des_pictures(pid,despicture) VALUES (" + product.getId() + "," + "\"" + m + "\"");
                }
            }
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Product getProductWithName(String name)
    {
        return HelpWithGetProduct("tname",name);

    }


    private Product HelpWithGetProduct(String tname, String name) {
      Connection con=util.getConnection();
        Product pro=new Product();
        try {
            Statement sta=con.createStatement();
            ResultSet set=sta.executeQuery("SELECT * from product WHERE "+tname+"="+"\""+name+"\"");
            boolean t=set.next();
            if(!t)
                return null;
            else
            {
                pro.setName(set.getString(set.findColumn("tname")));
                pro.setTitle(set.getString(set.findColumn("title")));
                pro.setId(set.getInt(set.findColumn("pid")));
                pro.setHeadicon(set.getString(set.findColumn("headicon")));
                pro.setStocknumber(set.getInt(set.findColumn("stocknumber")));
                pro.setDesdetail(set.getString(set.findColumn("des")));
                pro.setPrice(set.getFloat(set.findColumn("price")));
                pro.setDiscountPrice(set.getFloat(set.findColumn("discountprice")));

            }
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    return pro;

    }

    public Product getProductWithId(int id)
    {
        return HelpWithGetProduct("pid",id+"");
    }
    public void UpdateProduct(Product product)
    {
        int id=product.getId();
        if(id==0)
        {
            InsertNewProduct(product);
        }
        Connection connection=util.getConnection();
        try {
            Statement sta=connection.createStatement();
            String m="UPDATE product SET title"+"="+"\""+product.getTitle()+"\""+","+"headicon="+"\""+product.getHeadicon()+"\""+
                    ","+"stocknumber="+"\""+product.getStocknumber()+"\""+","+"des"+"="+"\""+product.getDesdetail()+"\""+","+"price"+"="+"\""+product.getPrice()+"\""
                    +","+"discountprice"+"="+"\""+product.getDiscountPrice()+"\""+"WHERE pid="+id;
            System.out.println(m);
            sta.executeUpdate(m);
            List<String > list=product.getDespictures();
            if(list!=null)
            {
                for(String t:list)
                {
                    sta.executeUpdate("UPDATE  des_prictures SET pid"+"="+id+","+"despicture="+"\""+t+"\"");
                }
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void DeleteProductWithName(String name)
    {
         HelpDelete("tname",name);
    }
    public void DeleteProductWithId(int id)
    {
        HelpDelete("pid",id+"");
    }

    private void HelpDelete(String tname, String name) {
        boolean t;
        Connection con=util.getConnection();
        try {
            Statement sta=con.createStatement();
            sta.execute("DELETE  FROM product WHERE "+tname+"="+name);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public boolean IsProductExistWithName(String name) {
        boolean t=false;
        Connection con=util.getConnection();
        try {
            Statement sta=con.createStatement();
            ResultSet set=sta.executeQuery("SELECT * FROM product where tname="+"\""+name+"\"");
            t=set.next();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;
    }
    public static void main(String []args)
    {
        ProductAdo pro=ProductAdo.getProductAdo();
        Product pr=new Product();
        pr.setName("啤酒");
        pro.InsertNewProduct(pr);
        pr=new Product();
        pr.setName("天津啤酒");
        pr.setPrice(88);
        pr.setDiscountPrice(40);
        pr.setStocknumber(90);
        pro.InsertNewProduct(pr);
        Product a1=pro.getProductWithId(1);
        System.out.println(a1);
        Product a2=pro.getProductWithName("天津啤酒");
        System.out.println(a2);
        a2.setPrice(1999);
        pro.UpdateProduct(a2);
        pro.DeleteProductWithId(1);
        pr=new Product();
        pr.setName("奥丁");
        pro.DeleteProductWithId(2);
        pro.InsertNewProduct(pr);
    }

}

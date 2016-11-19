package DatabaseUtil;

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



}

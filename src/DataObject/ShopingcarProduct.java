package DataObject;

/**
 * Created by ldy on 2016/11/19.
 */
public class ShopingcarProduct {
    private Product product;
    private int num;

    public ShopingcarProduct()
    {

    }
    public ShopingcarProduct(Product t,int n)
    {
        product=t;
        num=n;
    }

    @Override
    public String toString() {
        return "ShopingcarProduct{" +
                "product=" + product +
                ", num=" + num +
                '}';
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}

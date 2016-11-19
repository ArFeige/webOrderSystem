package DataObject;

import java.util.List;

/**
 * Created by ldy on 2016/11/19.
 */
public class Product {
    private String name;
    private String desdetail;
    private String title;
    private int id;
    private String headicon;
    private List<String> despictures;
    private int stocknumber;
    private boolean isPay;
    private boolean isReturn;
    private float discountPrice;
    private float price;

    public Product(String name) {
        this.name = name;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", desdetail='" + desdetail + '\'' +
                ", title='" + title + '\'' +
                ", id=" + id +
                ", headicon='" + headicon + '\'' +
                ", despictures=" + despictures +
                ", stocknumber=" + stocknumber +
                ", isPay=" + isPay +
                ", isReturn=" + isReturn +
                ", discountPrice=" + discountPrice +
                ", price=" + price +
                '}';
    }

    public float getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(float discountPrice) {
        this.discountPrice = discountPrice;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isPay() {
        return isPay;
    }

    public void setPay(boolean pay) {
        isPay = pay;
    }

    public boolean isReturn() {
        return isReturn;
    }

    public void setReturn(boolean aReturn) {
        isReturn = aReturn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesdetail() {
        return desdetail;
    }

    public void setDesdetail(String desdetail) {
        this.desdetail = desdetail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeadicon() {
        return headicon;
    }

    public void setHeadicon(String headicon) {
        this.headicon = headicon;
    }

    public List<String> getDespictures() {
        return despictures;
    }

    public void setDespictures(List<String> despictures) {
        this.despictures = despictures;
    }

    public int getStocknumber() {
        return stocknumber;
    }

    public void setStocknumber(int stocknumber) {
        this.stocknumber = stocknumber;
    }
}

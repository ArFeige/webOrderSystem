package DataObject;

/**
 * Created by ldy on 2016/11/19.
 */
public class Order {
    private int orderid;
    private int uid;
    private int pid;
    private int num;
    private float price;
    private int ispay;
    private int isReturn;

    @Override
    public String toString() {
        return "Order{" +
                "orderid=" + orderid +
                ", uid=" + uid +
                ", pid=" + pid +
                ", num=" + num +
                ", price=" + price +
                ", ispay=" + ispay +
                ", isReturn=" + isReturn +
                '}';
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getIspay() {
        return ispay;
    }

    public void setIspay(int ispay) {
        this.ispay = ispay;
    }

    public int getIsReturn() {
        return isReturn;
    }

    public void setIsReturn(int isReturn) {
        this.isReturn = isReturn;
    }
}

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

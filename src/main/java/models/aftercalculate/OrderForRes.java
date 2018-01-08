package models.aftercalculate;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import models.BaseModel;

import java.util.ArrayList;
import java.util.List;

@XStreamAlias("Orders")
public class OrderForRes extends BaseModel {

    @XStreamAlias("Name")
    private String name;
    @XStreamImplicit(itemFieldName = "product")
    private List<String> products;

    @XStreamAlias("Price")
    private String price;


    public OrderForRes() {
        products = new ArrayList<>();
        price = "0";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getProducts() {
        return products;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }

    public void addToProducts(String product) {
        products.add(product);
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderForRes{" +
                "name='" + name + '\'' +
                ", products=" + products.toString() +
                ", price='" + price + '\'' +
                '}';
    }
}

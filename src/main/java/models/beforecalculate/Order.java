package models.beforecalculate;

import models.BaseModel;

import java.util.ArrayList;
import java.util.List;

public class Order extends BaseModel {

    private String name;
    private List<String> products;

    public Order() {
        products = new ArrayList<>();
    }

    public void addToProducts(String product) {
        products.add(product);
    }

    public void removeFromProducts(String product) {
        products.remove(product);
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

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", products=" + products.toString() +
                '}';
    }
}

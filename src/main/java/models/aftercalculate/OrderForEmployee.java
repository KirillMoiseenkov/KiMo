package models.aftercalculate;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import models.BaseModel;

@XStreamAlias("Orders")
public class OrderForEmployee extends BaseModel {

    @XStreamAlias("Name")
    private String name;

    @XStreamAlias("Count")
    private String weight;

    @XStreamAlias("Price")
    private String price;


    public OrderForEmployee() {

        weight = "0";
        price = "0";

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderForEmployee{" +
                "name='" + name + '\'' +
                ", count='" + weight + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}

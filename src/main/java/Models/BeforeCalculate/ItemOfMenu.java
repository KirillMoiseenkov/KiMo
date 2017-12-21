package Models.BeforeCalculate;

import Models.BaseModel;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class ItemOfMenu extends BaseModel {


    private String name;

    private int weight;

    private int price;


    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ItemOfMenu{" +
                "name='" + name + '\'' +
                ", weight='" + weight + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
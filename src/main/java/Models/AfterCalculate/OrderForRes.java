package Models.AfterCalculate;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
@XStreamAlias("Orders")
public class OrderForRes {

    @XStreamAlias("Name")
    private String name;
    @XStreamImplicit(itemFieldName="product")
    private List<String> products;

    @XStreamAlias("Price")
    private String price;




    public  OrderForRes(){
        products = new ArrayList<>();
        price = "0";
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<String> getProducts() { return products; }
    public void setProducts(List<String> products) { this.products = products; }
    public void addToProducts(String product){products.add(product);}
    public String getPrice() { return price; }
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

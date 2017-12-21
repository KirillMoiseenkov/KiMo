package Controllers;

import DAO.ItemOfMenuDAOImp;
import DAO.OrdersDAOImp;
import Models.AfterCalculate.OrderForEmployee;
import Models.AfterCalculate.OrderForRes;
import Models.BeforeCalculate.ItemOfMenu;
import XmlParsers.Creater.XMLOrdersForEmpCreater;
import XmlParsers.Creater.XMLOrdersForResCreater;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreaterReportService {

    private ItemOfMenuDAOImp itemOfMenuDAOImp;
    private OrdersDAOImp ordersDAOImp;
    private List<ItemOfMenu> itemOfMenus;
    private Map<String,Integer> countProducts;
    private List<OrderForEmployee> orderForEmployeeList;
    private List<OrderForRes> orderForResList;

    public CreaterReportService(String URLMenu, String URLOrders) {

        itemOfMenuDAOImp = new ItemOfMenuDAOImp("menu",URLMenu);
        ordersDAOImp = new OrdersDAOImp("employee",URLOrders);
        countProducts = new HashMap<>();
    }

    public void prepare(){
        List<Models.BeforeCalculate.Order> orderList = ordersDAOImp.getAll();
        orderForEmployeeList = new ArrayList<>();
        orderForResList = new ArrayList<>();

        orderList.forEach(order ->{
            OrderForRes orderForRes = new OrderForRes();
            orderForRes.setName(order.getName());
            orderForRes.setProducts(order.getProducts());
            order.getProducts().forEach(product->
                   {
                      orderForRes.setPrice(String.valueOf(Integer.parseInt(orderForRes.getPrice()) + itemOfMenuDAOImp.getByName(product).getPrice()));
                       if(countProducts.containsKey(product))
                            countProducts.put(product,countProducts.get(product)+1);
                        else countProducts.put(product,1);
                   }
                   );
            orderForRes.setPrice(orderForRes.getPrice() + " руб");
            orderForResList.add(orderForRes);
        });

        countProducts.forEach((Name, count) ->{
            OrderForEmployee orderForEmployee = new OrderForEmployee();

            orderForEmployee.setWeight(String.valueOf(itemOfMenuDAOImp.getByName(Name).getWeight()*count) + " г");
            orderForEmployee.setPrice(String.valueOf(count *itemOfMenuDAOImp.getByName(Name).getPrice())+ " руб");

            orderForEmployee.setName(Name);

            orderForEmployeeList.add(orderForEmployee);
        });
    }

    public void createFirstReport(){
        XMLOrdersForEmpCreater xmlOrdersForEmpCreater = new XMLOrdersForEmpCreater();
        xmlOrdersForEmpCreater.parsing(orderForEmployeeList);
    }

        public void createSecondReport(){
            XMLOrdersForResCreater xmlOrdersForResCreater = new XMLOrdersForResCreater();
            xmlOrdersForResCreater.parsing(orderForResList);
        }
}

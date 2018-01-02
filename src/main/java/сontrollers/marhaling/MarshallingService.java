package сontrollers.marhaling;

import DAO.ItemOfMenuDAOImp;
import DAO.OrdersDAOImp;
import models.aftercalculate.OrderForEmployee;
import models.aftercalculate.OrderForRes;
import models.beforecalculate.ItemOfMenu;
import xmlparsers.creater.XMLOrdersForEmpCreater;
import xmlparsers.creater.XMLOrdersForResCreater;

import java.util.*;

public class MarshallingService {

    private ItemOfMenuDAOImp itemOfMenuDAOImp;
    private OrdersDAOImp ordersDAOImp;
    private List<ItemOfMenu> itemOfMenus;
    private Map<String, Integer> countProducts;
    private List<OrderForEmployee> orderForEmployeeList;
    private List<OrderForRes> orderForResList;

    public MarshallingService(String URLMenu, String URLOrders) {

        itemOfMenuDAOImp = new ItemOfMenuDAOImp("menu", URLMenu);
        ordersDAOImp = new OrdersDAOImp("employee", URLOrders);
        countProducts = new HashMap<>();
    }

    public void prepare() {
        List<models.beforecalculate.Order> orderList = ordersDAOImp.getAll();
        orderForEmployeeList = new ArrayList<>();
        orderForResList = new ArrayList<>();

        orderList.forEach(order -> {
            OrderForRes orderForRes = new OrderForRes();
            orderForRes.setName(order.getName());
            orderForRes.setProducts(order.getProducts());
            order.getProducts().forEach(product ->
                    {
                        orderForRes.setPrice(String.valueOf(Integer.parseInt(orderForRes.getPrice()) + itemOfMenuDAOImp.getByName(product).getPrice()));
                        countProducts.merge(product, 1, (last, iterator) -> last + iterator);

                    }
            );
            orderForRes.setPrice(orderForRes.getPrice() + " руб");
            orderForResList.add(orderForRes);
        });

        countProducts.forEach((Name, count) -> {
            OrderForEmployee orderForEmployee = new OrderForEmployee();

            orderForEmployee.setWeight(String.valueOf(itemOfMenuDAOImp.getByName(Name).getWeight() * count) + " г");
            orderForEmployee.setPrice(String.valueOf(count * itemOfMenuDAOImp.getByName(Name).getPrice()) + " руб");

            orderForEmployee.setName(Name);

            orderForEmployeeList.add(orderForEmployee);
        });
    }

    public void createFirstReport() {
        XMLOrdersForEmpCreater xmlOrdersForEmpCreater = new XMLOrdersForEmpCreater();
        xmlOrdersForEmpCreater.parsing(orderForEmployeeList);
    }

    public void createSecondReport() {
        XMLOrdersForResCreater xmlOrdersForResCreater = new XMLOrdersForResCreater();
        xmlOrdersForResCreater.parsing(orderForResList);
    }
}

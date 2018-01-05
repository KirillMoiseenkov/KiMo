package сontrollers.calculate;

import DAO.ItemOfMenuDAOImp;
import DAO.OrdersDAOImp;
import DAO.interfaces.IDAO;
import models.aftercalculate.OrderForEmployee;
import models.beforecalculate.Order;
import org.apache.log4j.Logger;
import сontrollers.interfaces.calculate.ICalculateTargetService;
import сontrollers.interfaces.calculate.ICalculateService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderForEmployeeCalculateService implements ICalculateService<IDAO>, ICalculateTargetService<OrderForEmployee> {

    private OrdersDAOImp ordersDAOImp;
    private ItemOfMenuDAOImp itemOfMenuDAOImp;
    private Map<String, Integer> countProducts;
    private List<OrderForEmployee> orderForEmployeeList;
    private static final Logger log = Logger.getLogger(OrderForEmployeeCalculateService.class);


    @Override
    public void setDAO(IDAO... dao) {
        itemOfMenuDAOImp = (ItemOfMenuDAOImp) dao[0];
        ordersDAOImp = (OrdersDAOImp) dao[1];
    }

    @Override
    public List<OrderForEmployee> exexute() {

        orderForEmployeeList = new ArrayList<>();
        countProducts = new HashMap<>();

        List<Order> orderList = ordersDAOImp.getAll();

        orderList.forEach(order -> {
            order.getProducts().forEach(product ->
                    {
                        countProducts.merge(product, 1, (last, iterator) -> last + iterator);
                    }
                    );
        });
        countProducts.forEach((Name, count) -> {
            OrderForEmployee orderForEmployee = new OrderForEmployee();
            orderForEmployee.setWeight(String.valueOf(itemOfMenuDAOImp.getByName(Name).getWeight() * count) + " г");
            orderForEmployee.setPrice(String.valueOf(count * itemOfMenuDAOImp.getByName(Name).getPrice()) + " руб");
            orderForEmployee.setName(Name);

            orderForEmployeeList.add(orderForEmployee);
            if(orderForEmployeeList.size() == 0){
                log.warn("item size equals 0, something go wrong");

            }


        });

        log.info("Calculate succes");
        return orderForEmployeeList;
    }
}

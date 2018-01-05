package сontrollers;

import DAO.ItemOfMenuDAOImp;
import DAO.OrdersDAOImp;
import DAO.interfaces.IDAO;
import models.aftercalculate.OrderForRes;
import org.apache.log4j.Logger;
import сontrollers.calculate.OrderForEmployeeCalculateService;
import сontrollers.interfaces.calculate.ICalculateTargetService;
import сontrollers.interfaces.calculate.ICalculateService;

import java.util.ArrayList;
import java.util.List;

public class OrderForResCalculateService implements ICalculateService<IDAO> , ICalculateTargetService<OrderForRes> {


    private ItemOfMenuDAOImp itemOfMenuDAOImp;
    private OrdersDAOImp ordersDAOImp;
    private List<OrderForRes> orderForResList;
    private static final Logger log = Logger.getLogger(OrderForResCalculateService.class);

    @Override
    public void setDAO(IDAO... dao) {
        itemOfMenuDAOImp = (ItemOfMenuDAOImp) dao[0];
        ordersDAOImp = (OrdersDAOImp) dao[1];
    }

    @Override
    public List<OrderForRes> exexute() {
        List<models.beforecalculate.Order> orderList = ordersDAOImp.getAll();
        orderForResList = new ArrayList<>();

        orderList.forEach(order -> {
            OrderForRes orderForRes = new OrderForRes();
            orderForRes.setName(order.getName());
            orderForRes.setProducts(order.getProducts());
            order.getProducts().forEach(product ->
                    {
                        orderForRes.setPrice(String.valueOf(Integer.parseInt(orderForRes.getPrice()) + itemOfMenuDAOImp.getByName(product).getPrice()));

                    }
            );
            orderForRes.setPrice(orderForRes.getPrice() + " руб");
            orderForResList.add(orderForRes);
            if(orderForResList.size() == 0) {
                log.warn("item size equals 0, something go wrong");

            }
            });

            log.info("Calculate succes");
        return orderForResList;
    }
}

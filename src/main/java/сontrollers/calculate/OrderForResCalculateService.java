package сontrollers;

import DAO.ItemOfMenuDAOImp;
import DAO.OrdersDAOImp;
import DAO.interfaces.IDAO;
import models.aftercalculate.OrderForRes;
import сontrollers.interfaces.calculate.ICalculateTargetService;
import сontrollers.interfaces.calculate.ICalculateService;

import java.util.ArrayList;
import java.util.List;

public class OrderForResCalculateService implements ICalculateService<IDAO> , ICalculateTargetService<OrderForRes> {


    ItemOfMenuDAOImp itemOfMenuDAOImp;
    OrdersDAOImp ordersDAOImp;
    List<OrderForRes> orderForResList;

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
        });


        return orderForResList;
    }
}

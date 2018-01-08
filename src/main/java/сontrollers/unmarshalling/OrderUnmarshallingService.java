package сontrollers.unmarshalling;

import DAO.OrdersDAOImp;
import сontrollers.interfaces.unmarhaling.IDefoultUnmarshalingService;

public class OrderUnmarshallingService implements IDefoultUnmarshalingService<OrdersDAOImp> {

    private final String nameCollection = "employee";
    private OrdersDAOImp ordersDAOImp;

    public OrderUnmarshallingService(String URLMenu) {

        ordersDAOImp = new OrdersDAOImp();
        ordersDAOImp.setListByParsing(URLMenu);
    }

    @Override
    public OrdersDAOImp execute() {
        return ordersDAOImp;
    }
}

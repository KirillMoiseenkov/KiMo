package сontrollers.unmarshaling;

import DAO.OrdersDAOImp;
import сontrollers.interfaces.unmarhaling.IDefoultUnmarshalingService;

public class OrderUnmarshalingUnmarshalingService implements IDefoultUnmarshalingService<OrdersDAOImp> {

    private OrdersDAOImp ordersDAOImp;
    private final String nameCollection = "employee";

    public OrderUnmarshalingUnmarshalingService(String URLMenu){

        ordersDAOImp = new OrdersDAOImp(nameCollection, URLMenu);

    }

    @Override
    public OrdersDAOImp execute() {
        return ordersDAOImp;
    }
}

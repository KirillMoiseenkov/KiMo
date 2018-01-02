package сontrollers.unmarshaling;

import DAO.OrdersDAOImp;
import сontrollers.interfaces.unmarhaling.IDefoultUnmarshalingService;

public class OrderUnmarshalingUnmarshalingService implements IDefoultUnmarshalingService<OrdersDAOImp> {

    OrdersDAOImp ordersDAOImp;

    public OrderUnmarshalingUnmarshalingService(String URLMenu){

        ordersDAOImp = new OrdersDAOImp("employee", URLMenu);

    }

    @Override
    public OrdersDAOImp execute() {
        return ordersDAOImp;
    }
}

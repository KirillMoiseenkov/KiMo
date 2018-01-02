package DAO.interfaces;

import models.beforecalculate.Order;

import java.util.List;

public interface IDAOOrders extends IDAO<Order> {

    List<Order> getByProduct(String product);


}

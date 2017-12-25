package DAO.Interface;

import Models.BeforeCalculate.Order;

import java.util.List;

public interface IDAOOrders extends IDAO<Order> {

    List<Order> getByProduct(String product);


}

package DAO;

import DAO.interfaces.IDAOOrders;
import models.beforecalculate.Order;
import xmlparsers.getter.XMLOredersGetter;

import java.util.List;
import java.util.stream.Collectors;

public class OrdersDAOImp implements IDAOOrders {

    private List<Order> orders;
    private XMLOredersGetter xmlOredersGetter;


    @Override
    public void setList(List<Order> items) {
        orders = items;
    }

    @Override
    public void setListByParsing(String URL) {
        xmlOredersGetter = new XMLOredersGetter(URL);
        orders = xmlOredersGetter.parse();

    }


    @Override
    public List<Order> getByProduct(String product) {
        return orders.stream().filter(i -> i.getProducts().contains(product)).collect(Collectors.toList());
    }

    @Override
    public Order getByName(String name) {
        return orders.stream().filter(i -> i.getName().equals(name)).findFirst().get();
    }

    @Override
    public List<Order> getAll() {
        return orders;
    }
}

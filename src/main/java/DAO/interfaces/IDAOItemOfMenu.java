package DAO.interfaces;

import models.beforecalculate.ItemOfMenu;

import java.util.List;

public interface IDAOItemOfMenu extends IDAO<ItemOfMenu> {


    List<ItemOfMenu> getByPrice(int price);

    List<ItemOfMenu> getByWeigh(int Weight);


}

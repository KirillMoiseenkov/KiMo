package DAO;

import DAO.interfaces.IDAOItemOfMenu;
import models.beforecalculate.ItemOfMenu;
import xmlparsers.getter.XMLMenuGetter;

import java.util.List;
import java.util.stream.Collectors;

public class ItemOfMenuDAOImp implements IDAOItemOfMenu {

    private XMLMenuGetter xmlMenuGetter;
    private List<ItemOfMenu> items;

    @Override
    public void setList(List<ItemOfMenu> items) {
        this.items = items;
    }

    @Override
    public void setListByParsing(String URL) {
        xmlMenuGetter = new XMLMenuGetter(URL);
        items = xmlMenuGetter.parse();

    }

    @Override
    public List<ItemOfMenu> getByPrice(int price) {
        return items.stream().filter(i -> i.getPrice() == price).collect(Collectors.toList());
    }

    @Override
    public List<ItemOfMenu> getByWeigh(int weight) {
        return items.stream().filter(i -> i.getWeight() == weight).collect(Collectors.toList());
    }

    @Override
    public ItemOfMenu getByName(String name) {
        return items.stream().filter(i -> i.getName().equals(name)).findFirst().get();
    }

    @Override
    public List<ItemOfMenu> getAll() {
        return items;
    }
}

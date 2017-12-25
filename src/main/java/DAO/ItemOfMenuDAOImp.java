package DAO;

import DAO.Interface.IDAOItemOfMenu;
import Models.BeforeCalculate.ItemOfMenu;
import XmlParsers.Getter.XMLMenuGetter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ItemOfMenuDAOImp implements IDAOItemOfMenu {

    private XMLMenuGetter xmlMenuGetter;
    private List<ItemOfMenu> items;

    public ItemOfMenuDAOImp(String nameCollection, String URL, List<String> attr) {
        xmlMenuGetter = new XMLMenuGetter(URL);
        items = xmlMenuGetter.parse(nameCollection, attr);
    }

    public ItemOfMenuDAOImp(String nameCollection, String URL) {
        xmlMenuGetter = new XMLMenuGetter(URL);
        items = xmlMenuGetter.parse(nameCollection, new ArrayList<String>() {{
            add("name");
            add("weight");
            add("price");
        }});
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

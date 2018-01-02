package xmlparsers.getter;

import models.beforecalculate.ItemOfMenu;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.List;

public class XMLMenuGetter extends XMLGetter<ItemOfMenu> {

    public XMLMenuGetter(String XMLURL) {
        super(XMLURL);
    }

    public List<ItemOfMenu> parse(String nameCollection, List<String> attr) {
        this.nameCollection = nameCollection;
        nList = doc.getElementsByTagName(nameCollection);

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;

                ItemOfMenu itemOfMenu = new ItemOfMenu();
                String name;
                String price;
                String weight;

                name = eElement.getElementsByTagName(attr.get(0)).item(0).getTextContent();
                weight = eElement.getElementsByTagName(attr.get(1)).item(0).getTextContent();
                price = eElement.getElementsByTagName(attr.get(2)).item(0).getTextContent();

                itemOfMenu.setName(name);
                itemOfMenu.setPrice(Integer.parseInt(price.substring(0, price.indexOf(" "))));
                itemOfMenu.setWeight(Integer.parseInt(weight.substring(0, weight.indexOf(" "))));

                this.items.add(itemOfMenu);

            }
        }
        System.out.println("Item succes parse");
        return this.items;
    }

}

package xmlparsers.getter;

import models.beforecalculate.Order;
import org.apache.log4j.Logger;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;


public class XMLOredersGetter extends XMLGetter<Order> {

    private static final Logger log = Logger.getLogger(XMLOredersGetter.class);
    private String nameCollection = "employee";
    private List<String> attr;


    public XMLOredersGetter(String XMLURL) {
        super(XMLURL);

        attr = new ArrayList<String>() {{
            add("name");
            add("item");
        }};

    }

    @Override
    public void setProperties(String nameCollection, List<String> attr) {
        this.nameCollection = nameCollection;
        this.attr = attr;
    }


    public List<Order> parse() {

//        this.nameCollection = nameCollection;

        nList = doc.getElementsByTagName(nameCollection);

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Order order = new Order();
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element eElement = (Element) nNode;
                order.setName(eElement.getElementsByTagName(attr.get(0)).item(0).getTextContent());
                NodeList nodeList = eElement.getElementsByTagName(attr.get(1));
                for (int i = 0; i < nodeList.getLength(); i++) {
                    Node node = nodeList.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) nNode;
                        order.addToProducts(eElement
                                .getElementsByTagName(attr.get(1))
                                .item(i)
                                .getTextContent());
                    }
                }
            }
            items.add(order);
            if (items.size() == 0)
                log.warn("size of elements equals zero");

        }
        log.debug("file have been ummarhaled");

        return items;

    }

}

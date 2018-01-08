package xmlparsers.getter;

import org.junit.Test;

public class XMLOredersGetterTest {

    @Test
    public void parse() {


        XMLOredersGetter xmlOredersGetter = new XMLOredersGetter("Orders.xml");
        xmlOredersGetter.parse().forEach(itemOfMenu -> System.out.println(itemOfMenu.toString()));

    }
}
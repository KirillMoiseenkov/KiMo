package xmlparsers.getter;

import org.junit.Test;

public class XMLMenuGetterTest {

    @Test
    public void parse() {

        XMLMenuGetter xmlMenuGetter = new XMLMenuGetter("Menu.xml");
        xmlMenuGetter.parse().forEach(itemOfMenu -> System.out.println(itemOfMenu.toString()));

    }
}
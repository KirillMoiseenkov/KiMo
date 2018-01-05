package xmlparsers.getter;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class XMLMenuGetterTest {

    @Test
    public void parse() {

        XMLMenuGetter xmlMenuGetter = new XMLMenuGetter("Menu.xml");
        xmlMenuGetter.parse("menu", new ArrayList<String>() {{
            add("name");
            add("weight");
            add("price");
        }}).forEach(itemOfMenu -> System.out.println(itemOfMenu.toString()));

    }
}
package xmlparsers.getter;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class XMLOredersGetterTest {

    @Test
    public void parse() {



        XMLOredersGetter xmlOredersGetter = new XMLOredersGetter("Orders.xml");
        xmlOredersGetter.parse("employee", new ArrayList<String>() {{
            add("name");
            add("item");
        }}).forEach(itemOfMenu -> System.out.println(itemOfMenu.toString()));

    }
}
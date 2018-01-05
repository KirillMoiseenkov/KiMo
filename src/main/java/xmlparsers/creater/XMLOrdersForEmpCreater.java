package xmlparsers.creater;

import models.aftercalculate.OrderForEmployee;
import models.aftercalculate.OrderForRes;
import com.thoughtworks.xstream.XStream;
import org.apache.log4j.Logger;
import xmlparsers.getter.XMLMenuGetter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class XMLOrdersForEmpCreater implements IXMLCreater<OrderForEmployee> {

    private static final Logger log = Logger.getLogger(XMLOrdersForEmpCreater.class);
    private    String fileName;
    private   String itemName;

    public XMLOrdersForEmpCreater(String fileName, String itemName){
        this.fileName =fileName;
        this.itemName = itemName;
    }

    public void parsing(List<OrderForEmployee> orderForEmployees) {


        XStream xstream = new XStream();
        xstream.processAnnotations(OrderForEmployee.class);
        xstream.alias(itemName, OrderForRes.class);
        try {
            Files.write(Paths.get(fileName), xstream.toXML(orderForEmployees).getBytes());
            log.info("file created : " + fileName);
        } catch (IOException e) {
            log.error("problem with creating file" + fileName + " : "  + e);
        }

    }


}

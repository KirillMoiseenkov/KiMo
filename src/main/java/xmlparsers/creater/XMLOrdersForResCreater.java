package xmlparsers.creater;

import models.aftercalculate.OrderForRes;
import com.thoughtworks.xstream.XStream;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class XMLOrdersForResCreater implements IXMLCreater<OrderForRes> {

    private static final Logger log = Logger.getLogger(XMLOrdersForResCreater.class);
    private String fileName;
    private String itemName;

    public XMLOrdersForResCreater(String fileName, String itemName){
        this.fileName =fileName;
        this.itemName = itemName;
    }
    public void parsing(List<OrderForRes> orderForResList) {


        XStream xstream = new XStream();
        xstream.processAnnotations(OrderForRes.class);
        xstream.alias(itemName, OrderForRes.class);
        try {
            Files.write(Paths.get(fileName), xstream.toXML(orderForResList).getBytes());
            log.info("file created : " + fileName);
        } catch (IOException e) {
            log.error("problem with creating file" + fileName + " : "  + e);
        }


    }


}


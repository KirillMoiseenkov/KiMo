package xmlparsers.creater;

import models.aftercalculate.OrderForRes;
import com.thoughtworks.xstream.XStream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class XMLOrdersForResCreater implements IXMLCreater<OrderForRes> {


    public void parsing(List<OrderForRes> orderForResList) {


        XStream xstream = new XStream();
        xstream.processAnnotations(OrderForRes.class);
        xstream.alias("Orders", OrderForRes.class);
        try {
            Files.write(Paths.get("SecondReport.xml"), xstream.toXML(orderForResList).getBytes());
        } catch (IOException e) {
            System.out.println("problem with file" + e);
        }

    }


}


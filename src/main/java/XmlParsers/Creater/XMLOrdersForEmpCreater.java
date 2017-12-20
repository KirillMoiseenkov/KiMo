package XmlParsers.Creater;

import Models.AfterCalculate.OrderForEmployee;
import Models.AfterCalculate.OrderForRes;
import com.thoughtworks.xstream.XStream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class XMLOrdersForEmpCreater {

    public void Parsing(List<OrderForEmployee> orderForEmployees)  {


        XStream xstream = new XStream();
        xstream.processAnnotations(OrderForEmployee.class);
        xstream.alias("Orders", OrderForRes.class);
        try {
            Files.write(Paths.get("FirstReport.xml"), xstream.toXML(orderForEmployees).getBytes());
        } catch (IOException e) {
            System.out.println("problem with file" + e);
        }

    }


}

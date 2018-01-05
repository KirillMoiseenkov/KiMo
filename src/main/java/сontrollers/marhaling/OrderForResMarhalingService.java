package сontrollers.marhaling;

import models.aftercalculate.OrderForRes;
import org.apache.log4j.Logger;
import xmlparsers.creater.XMLOrdersForResCreater;
import сontrollers.interfaces.marshaling.IDefoultMarshaling;

import java.util.List;

public class OrderForResMarhalingService implements IDefoultMarshaling<OrderForRes> {

     private  List<OrderForRes> orderForRes;
     private static final Logger log = Logger.getLogger(OrderForEmployeeMarhalingService.class);
     private final String fileName = "SecondReport.xml" ;
     private final String itemName = "Orders";



    @Override
    public void setList(List<OrderForRes> list) {

        orderForRes = list;

    }

    @Override
    public void execute() {

        XMLOrdersForResCreater xmlOrdersForResCreater = new XMLOrdersForResCreater(fileName,itemName);
        xmlOrdersForResCreater.parsing(orderForRes);

    }
}

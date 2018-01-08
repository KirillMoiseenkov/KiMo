package сontrollers.marhalling;

import models.aftercalculate.OrderForEmployee;
import org.apache.log4j.Logger;
import xmlparsers.creater.XMLOrdersForEmpCreater;
import сontrollers.interfaces.marshaling.IDefoultMarshaling;

import java.util.List;

public class OrderForEmployeeMarhallingService implements IDefoultMarshaling {

    private static final Logger log = Logger.getLogger(OrderForEmployeeMarhallingService.class);
    private final String fileName = "FirstReport.xml";
    private final String itemName = "Orders";
    private List<OrderForEmployee> orderForEmployee;

    @Override
    public void setList(List list) {

        orderForEmployee = list;

    }

    @Override
    public void execute() {


        XMLOrdersForEmpCreater xmlOrdersForEmpCreater = new XMLOrdersForEmpCreater(fileName, itemName);
        xmlOrdersForEmpCreater.parsing(orderForEmployee);


    }
}

package сontrollers.marhaling;

import models.BaseModel;
import models.aftercalculate.OrderForEmployee;
import org.apache.log4j.Logger;
import xmlparsers.creater.XMLOrdersForEmpCreater;
import сontrollers.OrderForResCalculateService;
import сontrollers.interfaces.marshaling.IDefoultMarshaling;

import java.util.List;

public class OrderForEmployeeMarhalingService implements IDefoultMarshaling{

   private List<OrderForEmployee> orderForEmployee;
   private static final Logger log = Logger.getLogger(OrderForEmployeeMarhalingService.class);
   private final String fileName = "FirstReport.xml" ;
   private final String itemName = "Orders";





    @Override
    public void setList(List list) {

        orderForEmployee = list;

    }

    @Override
    public void execute() {


        XMLOrdersForEmpCreater xmlOrdersForEmpCreater = new XMLOrdersForEmpCreater(fileName,itemName);
        xmlOrdersForEmpCreater.parsing(orderForEmployee);



    }
}

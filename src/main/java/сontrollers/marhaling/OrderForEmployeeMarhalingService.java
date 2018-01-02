package сontrollers.marhaling;

import models.BaseModel;
import models.aftercalculate.OrderForEmployee;
import xmlparsers.creater.XMLOrdersForEmpCreater;
import сontrollers.interfaces.marshaling.IDefoultMarshaling;

import java.util.List;

public class OrderForEmployeeMarhalingService implements IDefoultMarshaling{

    List<OrderForEmployee> orderForEmployee;





    @Override
    public void setList(List list) {

        orderForEmployee = list;
        orderForEmployee.forEach(orderForEmployee1 -> System.out.println(orderForEmployee1.toString()));
    }

    @Override
    public void execute() {

        XMLOrdersForEmpCreater xmlOrdersForEmpCreater = new XMLOrdersForEmpCreater();
        xmlOrdersForEmpCreater.parsing(orderForEmployee);


    }
}

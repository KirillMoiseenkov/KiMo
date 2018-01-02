package сontrollers.marhaling;

import models.aftercalculate.OrderForRes;
import xmlparsers.creater.XMLOrdersForResCreater;
import сontrollers.interfaces.marshaling.IDefoultMarshaling;

import java.util.List;

public class OrderForResMarhalingService implements IDefoultMarshaling<OrderForRes> {

    List<OrderForRes> orderForRes;

    @Override
    public void setList(List<OrderForRes> list) {

        orderForRes = list;

    }

    @Override
    public void execute() {

        XMLOrdersForResCreater xmlOrdersForResCreater = new XMLOrdersForResCreater();
        xmlOrdersForResCreater.parsing(orderForRes);

    }
}

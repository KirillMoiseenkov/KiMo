import DAO.ItemOfMenuDAOImp;
import DAO.OrdersDAOImp;
import models.aftercalculate.OrderForEmployee;
import models.aftercalculate.OrderForRes;
import routes.parsers.URLPareser;
import сontrollers.OrderForResCalculateService;
import сontrollers.marhaling.OrderForEmployeeMarhalingService;
import сontrollers.marhaling.OrderForResMarhalingService;
import сontrollers.unmarshaling.MenuUnmarshallingUnmarshalingService;
import сontrollers.calculate.OrderForEmployeeCalculateService;
import сontrollers.unmarshaling.OrderUnmarshalingUnmarshalingService;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        /*try
        {


            URLPareser urlPareser = new URLPareser();
            MarshallingService marshallingService = new MarshallingService(urlPareser.getUrls().get(0),
                    urlPareser.getUrls().get(1));

            marshallingService.prepare();
            marshallingService.createFirstReport();
            marshallingService.createSecondReport();

        } catch (NullPointerException e)
        {
            System.out.println("NPE =  " + e);
        }

*/
        URLPareser urlPareser = new URLPareser();


        MenuUnmarshallingUnmarshalingService menuUnmarshallingService = new MenuUnmarshallingUnmarshalingService(urlPareser.getUrls().get(0));
        OrderUnmarshalingUnmarshalingService orderUnmarshalingService = new OrderUnmarshalingUnmarshalingService(urlPareser.getUrls().get(1));

        ItemOfMenuDAOImp itemOfMenuDAOImp;
        OrdersDAOImp ordersDAOImp;

        itemOfMenuDAOImp = menuUnmarshallingService.execute();
        ordersDAOImp = orderUnmarshalingService.execute();

        OrderForEmployeeCalculateService orderForEmployeeCalculateService = new OrderForEmployeeCalculateService();
        OrderForResCalculateService orderForResCalculateService = new OrderForResCalculateService();

        orderForEmployeeCalculateService.setDAO(itemOfMenuDAOImp, ordersDAOImp);
        orderForResCalculateService.setDAO(itemOfMenuDAOImp, ordersDAOImp);

        List<OrderForEmployee> orderForEmployees = orderForEmployeeCalculateService.exexute();
        List<OrderForRes> orderForRes = orderForResCalculateService.exexute();


        OrderForEmployeeMarhalingService orderForEmployeeMarhalingService = new OrderForEmployeeMarhalingService();
        OrderForResMarhalingService orderForResMarhalingService = new OrderForResMarhalingService();

        orderForEmployeeMarhalingService.setList(orderForEmployees);
        orderForResMarhalingService.setList(orderForRes);

        orderForResMarhalingService.execute();
        orderForEmployeeMarhalingService.execute();

        /*orderForEmployees.forEach(orderForEmployee -> System.out.println(orderForEmployee.toString()));
        orderForRes.forEach(orderForRes1 -> System.out.println(orderForRes1.toString()));
*/


    }


}



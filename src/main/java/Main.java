import DAO.ItemOfMenuDAOImp;
import DAO.OrdersDAOImp;
import models.aftercalculate.OrderForEmployee;
import models.aftercalculate.OrderForRes;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
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

    private static final Logger log = Logger.getLogger(Main.class);


    public static void main(String[] args) throws IOException {

            log.info("start project");

        try
        {


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



        } catch (NullPointerException e)
        {
            System.out.println("NPE =  " + e);
        }

        URLPareser urlPareser = new URLPareser();




        log.info("project finihed");

    }


}



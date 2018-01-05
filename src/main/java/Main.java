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

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class Main {

    private static final Logger log = Logger.getLogger(Main.class);
    private static Properties properties;

    private static String Menu = "Menu";
    private static String Orders = "Orders";

    public static void main(String[] args) throws IOException {

            log.info("start project");





        try
        {
            properties = new Properties();
            InputStream inputStream = Main.class.getResourceAsStream("routes.properties");
            properties.load(inputStream);


            URLPareser urlPareser = new URLPareser();

            MenuUnmarshallingUnmarshalingService menuUnmarshallingService = new MenuUnmarshallingUnmarshalingService(properties.getProperty(Menu));
            OrderUnmarshalingUnmarshalingService orderUnmarshalingService = new OrderUnmarshalingUnmarshalingService(properties.getProperty(Orders));

            OrderForEmployeeCalculateService orderForEmployeeCalculateService = new OrderForEmployeeCalculateService();
            OrderForResCalculateService orderForResCalculateService = new OrderForResCalculateService();

            OrderForEmployeeMarhalingService orderForEmployeeMarhalingService = new OrderForEmployeeMarhalingService();
            OrderForResMarhalingService orderForResMarhalingService = new OrderForResMarhalingService();


            ItemOfMenuDAOImp itemOfMenuDAOImp;
            OrdersDAOImp ordersDAOImp;

            itemOfMenuDAOImp = menuUnmarshallingService.execute();
            ordersDAOImp = orderUnmarshalingService.execute();


            orderForEmployeeCalculateService.setDAO(itemOfMenuDAOImp, ordersDAOImp);
            orderForResCalculateService.setDAO(itemOfMenuDAOImp, ordersDAOImp);

            List<OrderForEmployee> orderForEmployees = orderForEmployeeCalculateService.exexute();
            List<OrderForRes> orderForRes = orderForResCalculateService.exexute();



            orderForEmployeeMarhalingService.setList(orderForEmployees);
            orderForResMarhalingService.setList(orderForRes);

            orderForResMarhalingService.execute();
            orderForEmployeeMarhalingService.execute();




        } catch (NullPointerException e)
        {
            log.error("NPE" + e);
        }





        log.info("project finihed");

    }


}



import DAO.ItemOfMenuDAOImp;
import DAO.OrdersDAOImp;
import models.aftercalculate.OrderForEmployee;
import models.aftercalculate.OrderForRes;
import org.apache.log4j.Logger;
import routes.parsers.URLPareser;
import сontrollers.OrderForResCalculateService;
import сontrollers.calculate.OrderForEmployeeCalculateService;
import сontrollers.marhalling.OrderForEmployeeMarhallingService;
import сontrollers.marhalling.OrderForResMarhallingService;
import сontrollers.unmarshalling.MenuUnmarshallingService;
import сontrollers.unmarshalling.OrderUnmarshallingService;

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


        try {
            properties = new Properties();
            InputStream inputStream = Main.class.getResourceAsStream("routes.properties");
            properties.load(inputStream);


            URLPareser urlPareser = new URLPareser();

            MenuUnmarshallingService menuUnmarshallingService = new MenuUnmarshallingService(properties.getProperty(Menu));
            OrderUnmarshallingService orderUnmarshallingService = new OrderUnmarshallingService(properties.getProperty(Orders));

            OrderForEmployeeCalculateService orderForEmployeeCalculateService = new OrderForEmployeeCalculateService();
            OrderForResCalculateService orderForResCalculateService = new OrderForResCalculateService();

            OrderForEmployeeMarhallingService orderForEmployeeMarhallingService = new OrderForEmployeeMarhallingService();
            OrderForResMarhallingService orderForResMarhallingService = new OrderForResMarhallingService();


            ItemOfMenuDAOImp itemOfMenuDAOImp;
            OrdersDAOImp ordersDAOImp;

            itemOfMenuDAOImp = menuUnmarshallingService.execute();
            ordersDAOImp = orderUnmarshallingService.execute();


            orderForEmployeeCalculateService.setDAO(itemOfMenuDAOImp, ordersDAOImp);
            orderForResCalculateService.setDAO(itemOfMenuDAOImp, ordersDAOImp);

            List<OrderForEmployee> orderForEmployees = orderForEmployeeCalculateService.exexute();
            List<OrderForRes> orderForRes = orderForResCalculateService.exexute();


            orderForEmployeeMarhallingService.setList(orderForEmployees);
            orderForResMarhallingService.setList(orderForRes);

            orderForResMarhallingService.execute();
            orderForEmployeeMarhallingService.execute();


        } catch (NullPointerException e) {
            log.error("NPE" + e);
        }


        log.info("project finihed");

    }


}



import Controllers.CreaterReportService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        CreaterReportService createrReportService = new CreaterReportService("Menu.xml",
                "Orders.xml");

        createrReportService.prepare();
        createrReportService.createFirstReport();
        createrReportService.createSecondReport();


    }

}



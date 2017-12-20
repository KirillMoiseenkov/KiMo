import Controllers.CreaterReportService;

public class Main {
    public static void main(String[] args) {

        CreaterReportService createrReportService = new CreaterReportService("Menu.xml",
                "Orders.xml");

        createrReportService.prepare();
        createrReportService.createFirstReport();
        createrReportService.createSecondReport();



 }

}



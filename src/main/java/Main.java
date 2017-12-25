import Controllers.CreaterReportService;
import Routes.Parsers.URLPareser;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {


        URLPareser urlPareser = new URLPareser();


        CreaterReportService createrReportService = new CreaterReportService(urlPareser.getUrls().get(0),
                urlPareser.getUrls().get(1));

        createrReportService.prepare();
        createrReportService.createFirstReport();
        createrReportService.createSecondReport();


    }


}



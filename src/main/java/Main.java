import Controllers.CreaterReportService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;

public class Main {
    public static void main(String[] args) throws IOException {

        CreaterReportService createrReportService = new CreaterReportService("Menu.xml",
                "Orders.xml");

        createrReportService.prepare();
        createrReportService.createFirstReport();
        createrReportService.createSecondReport();





 }

}



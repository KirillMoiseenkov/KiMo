package xmlparsers.getter;

import models.BaseModel;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class XMLGetter<T extends BaseModel> {

    protected File inputFile;
    protected DocumentBuilderFactory dbFactory;
    protected DocumentBuilder dBuilder;
    protected Document doc;
    protected NodeList nList;
    protected String nameCollection;
    protected List<T> items = new ArrayList<>();

    protected static final Logger log = Logger.getLogger(XMLGetter.class);

    public XMLGetter(String XMLURL) {

        inputFile = new File(XMLURL); //(XMLURL);

        dbFactory = DocumentBuilderFactory.newInstance();

        try {


            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
        } catch (SAXException ignored) {

        } catch (ParserConfigurationException e) {
           log.warn("problem with parse or adress file" + e);

        } catch (FileNotFoundException e)
        {
           log.warn("file not found");

        } catch (IOException e) {

            log.error(e);

        }
    }

}

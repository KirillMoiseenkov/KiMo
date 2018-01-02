package routes.parsers;

import routes.models.Url;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class URLPareser {

    private List<String> urls;


    public URLPareser()   {

        JsonReader reader;
        List<Url> items;

        try {
            reader = new JsonReader(new FileReader("routes.json"));
            Gson gson = new Gson();
            Url[] urls = gson.fromJson(reader, Url[].class);
            items = Arrays.asList(urls);

            this.urls = items.stream().map(i -> i.getURL()).collect(Collectors.toList());

        } catch (FileNotFoundException e) {
            System.out.println("problem with file::" + e);
        }



    }

    public List<String> getUrls() {
        return urls;
    }
}


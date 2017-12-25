package Routes.Models;

public class Url {

    private String URL;

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    @Override
    public String toString() {
        return "Url{" +
                "URL='" + URL + '\'' +
                '}';
    }
}

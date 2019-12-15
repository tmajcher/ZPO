package lab10;

public class Model {
    private String name;
    private String url;

    Model(String name, String url){
        this.name = name;
        this.url = url;
    }

    @Override
    public String toString() {
        return getName() + " " + getUrl();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

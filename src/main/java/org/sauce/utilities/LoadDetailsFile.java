package org.sauce.utilities;

import java.util.Properties;

public class LoadDetailsFile {

    String URL;
    String IMPLICIT_TIME;

    String EXPLICIT_TIME;

    public LoadDetailsFile() {
        Properties properties = Generic.getPropertiesObject("src/main/resources/AppDetails/Details.properties");
        this.URL = properties.getProperty("URL");
        this.IMPLICIT_TIME = properties.getProperty("IMPLICIT_TIME");
        this.EXPLICIT_TIME= properties.getProperty("EXPLICIT_TIME");
    }

    public String getURL() {
        return URL;
    }

    public String getIMPLICIT_TIME() {
        return IMPLICIT_TIME;
    }

    public String getEXPLICIT_TIME() {
        return EXPLICIT_TIME;
    }
}

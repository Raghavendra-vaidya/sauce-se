package org.sauce.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Generic {
    public static Properties getPropertiesObject(String filePath){

        Properties prop = new Properties();
        FileInputStream fis;

        try {
            fis = new FileInputStream(new File(filePath));
            prop.load(fis);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return prop;
    }
}

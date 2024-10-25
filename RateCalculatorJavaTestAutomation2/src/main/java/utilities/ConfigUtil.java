package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtil {
    public String loadEnvProfileData(String field) {

        String profileData = "";
        try{
            FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir") +"/src/resources/configurations/dev_config.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            profileData = properties.getProperty(field);
        }catch(IOException e){
            System.out.println(e.getMessage());
            throw new RuntimeException("......... some issue while loading config properties.....");

        }
        return profileData;
    }
}

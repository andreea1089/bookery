package utils;

import com.sun.org.apache.xerces.internal.impl.PropertyManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileManager {
    private static PropertyFileManager instance;
    private static final Object lock = new Object();
    private static final String propertyFilePath = "D://bookery//src//test//resources//config.properties";
    private static String browserType;
    private static String url;
    private static String userName;
    private static String password;
    private static String driverLocation;
    private static Integer implicitWait;

    public static PropertyFileManager getInstance() {
        if (instance == null) {
            synchronized (lock) {
                instance = new PropertyFileManager();
                instance.loadData();
            }
        }
        return instance;
    }

    private void loadData() {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(propertyFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        url = prop.getProperty("url");
        browserType = prop.getProperty("browserType");
        userName = prop.getProperty("user");
        password = prop.getProperty("password");
        driverLocation = prop.getProperty("driverLocation");
        implicitWait = Integer.parseInt(prop.getProperty("implicitWait"));
    }

    public static String getBrowserType() {
        return browserType;
    }

    public static Integer getImplicitWait() {
        return implicitWait;
    }

    public static String getUrl() {
        return url;
    }

    public static String getUserName() {
        return userName;
    }

    public static String getDriverLocation() {
        return driverLocation;
    }

    public static String getPassword() {
        return password;
    }
}

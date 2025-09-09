
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    
    private static Properties properties;
    private static final String CONFIG_FILE_PATH = System.getProperty("user.dir") + "/src/test/resources/config.properties";
    
    static {
        loadProperties();
    }
    
    private static void loadProperties() {
        properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream(CONFIG_FILE_PATH);
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            System.err.println("Error loading configuration file: " + e.getMessage());
            throw new RuntimeException("Configuration file not found at: " + CONFIG_FILE_PATH);
        }
    }
    
    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new RuntimeException("Property '" + key + "' not found in configuration file");
        }
        return value;
    }
    
    public static String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
    
    // Specific getter methods for commonly used properties
    public static String getApplicationUrl() {
        return getProperty("app.url");
    }
    
    public static String getBrowser() {
        return getProperty("browser");
    }
    
    public static int getImplicitWait() {
        return Integer.parseInt(getProperty("implicit.wait"));
    }
    
    public static int getExplicitWait() {
        return Integer.parseInt(getProperty("explicit.wait"));
    }
    
    public static int getPageLoadTimeout() {
        return Integer.parseInt(getProperty("page.load.timeout"));
    }
    
    public static boolean isHeadless() {
        return Boolean.parseBoolean(getProperty("headless", "false"));
    }
    
    public static boolean shouldMaximize() {
        return Boolean.parseBoolean(getProperty("maximize", "true"));
    }
    
    public static String getTestDataPath() {
        return System.getProperty("user.dir") + getProperty("test.data.path");
    }
    
    public static String getTestDataSheet() {
        return getProperty("test.data.sheet");
    }
    
    public static String getReportPath() {
        return getProperty("report.path");
    }
    
    public static String getScreenshotPath() {
        return getProperty("screenshot.path");
    }
    
    public static String getValidEmail() {
        return getProperty("valid.email");
    }
    
    public static String getValidPassword() {
        return getProperty("valid.password");
    }
    
    public static String getInvalidEmail() {
        return getProperty("invalid.email");
    }
    
    public static String getInvalidPassword() {
        return getProperty("invalid.password");
    }
    
    public static int getMaxRetryCount() {
        return Integer.parseInt(getProperty("max.retry.count", "2"));
    }
}

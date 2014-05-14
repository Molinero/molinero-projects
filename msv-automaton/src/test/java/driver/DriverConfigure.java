package driver;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import tools.TestLogger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverConfigure {
    private WebDriver webDriver;
    private TestLogger logger = new TestLogger();
    private Properties properties = new Properties();
    private int width;
    private int height;

    public DriverConfigure(){
        setAutoTestProperties();
        if(getProperties().getProperty("browser").equals("firefox")) {
            webDriver = new FirefoxDriver();
        }
        if(getProperties().getProperty("browser").equals("chrome")) {
            webDriver = new ChromeDriver();
        }
        if(getProperties().getProperty("browser").equals("ie")) {
            webDriver = new InternetExplorerDriver();
        }

        width = new Integer(getProperties().getProperty("browser_window_width"));
        height = new Integer(getProperties().getProperty("browser_window_height"));
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public Properties getProperties() {
        return properties;
    }

    public TestLogger getLogger(){
        return logger;
    }

    @BeforeSuite
    public void setWebDriver(){
        getLogger().setLogFileBeginning();
        getWebDriver().manage().window().setPosition(new Point(200,200));
        getWebDriver().manage().window().setSize(new Dimension(width,height));
        getWebDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void closeWebDriver(){
        getWebDriver().quit();
        getLogger().setLogFileEnding();
    }

    private void setAutoTestProperties(){
        try {
            getProperties().load(new FileInputStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
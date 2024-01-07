package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;

import java.io.FileReader;
import java.net.URL;
import java.util.Properties;

public class BaseTest {
    public static ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir") + "\\src\\test\\resources\\myreports\\MyReport.html");
    public static ExtentReports extent = new ExtentReports();
    public static Properties prop = new Properties();
    public static Properties loc = new Properties();
    public static FileReader fr_p;
    public static FileReader fr_l;
    public static AppiumDriver driver;


    @BeforeSuite
    public void setUp() throws Exception {
        if (driver == null) {

            //Appium Setup

            fr_p = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\configfiles\\config.properties");
            fr_l = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\configfiles\\locators.properties");
            prop.load(fr_p);
            loc.load(fr_l);

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", prop.getProperty("platformName"));
            caps.setCapability("platformVersion", prop.getProperty("platformVersion"));
            caps.setCapability("deviceName", prop.getProperty("deviceName"));
            caps.setCapability("automationName", prop.getProperty("automationName"));
            caps.setCapability("appPackage", prop.getProperty("appPackage"));
            caps.setCapability("appActivity", prop.getProperty("appActivity"));

            URL url = new URL(prop.getProperty("appium_server"));
            driver = new AppiumDriver(url, caps);

            Thread.sleep(5000);

            System.out.println("Application started");

        } else {

            System.out.println("Driver is set");
        }
    }


    public void tearDown() {
        driver.close();
        System.out.println("Tear Down Successful");
    }


}

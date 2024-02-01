package tipeandocodigo.com.basetest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

import java.time.Duration;

public class WebDriverFactory {
    //singleton design pattern for the creation of the web driver
    private static final WebDriverFactory instance = new WebDriverFactory();
    private WebDriverFactory(){
    }
    public static WebDriverFactory getInstance(){
        return instance;
    }

    private static ThreadLocal<WebDriver> threadedDriver = new ThreadLocal<WebDriver>();
    public WebDriver getDriver(String browser){
        WebDriver driver = null;
        if(threadedDriver.get()==null) {
            switch (browser) {
                case "chrome": {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(getChromeOptions());
                    break;
                }
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(getFFOptions());
                    break;
                }
                case "ie": {
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver(getIEOptions());
                    break;
                }
                case "opera": {
                    WebDriverManager.operadriver().setup();
                    driver = new OperaDriver(getOperaOptions());
                    break;
                }
                case "edge": {
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver(getEdgeOptions());
                    break;
                }
            }
            threadedDriver.set(driver);
            threadedDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            threadedDriver.get().manage().window().maximize();

        }
        return threadedDriver.get();
    }

    public void quitDriver(){
        threadedDriver.get().quit();
        threadedDriver.set(null);
    }

    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        return options;
    }
    private FirefoxOptions getFFOptions(){
        FirefoxOptions options = new FirefoxOptions();
        return options;
    }

    private InternetExplorerOptions getIEOptions() {
        InternetExplorerOptions options = new InternetExplorerOptions();
        options.setCapability(InternetExplorerDriver.NATIVE_EVENTS,false);
        options.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING,false);
        options.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS,false);
        options.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION,true);
        options.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING,true);
        options.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
        return options;
    }
    private OperaOptions getOperaOptions() {
        OperaOptions options = new OperaOptions();
        return options;
    }

    private EdgeOptions getEdgeOptions() {
        EdgeOptions options = new EdgeOptions();
        return options;
    }

}

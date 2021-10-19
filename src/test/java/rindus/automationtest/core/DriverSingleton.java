package rindus.automationtest.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {
	
    public final String FIREFOX = "Firefox";
    public final String CHROME = "Chrome";
    public WebDriver driver;
    private static DriverSingleton instance;

    private DriverSingleton() {
    }

    public static DriverSingleton getInstance() {
        if (instance == null) {
            instance = new DriverSingleton();
        }
        return instance;
    }

    public void cleanDriver() {
        this.driver = null;
    }

    /**
     * This method is to get the driver selecting a specific browser
     *
     * @return the driver selected
     */
    public WebDriver getDriver()
    {
        if (driver == null) 
        {
        	System.setProperty("webdriver.chrome.driver", "D:\\Java\\chromedriver.exe");
            driver = new ChromeDriver();
            String browserType = "CHROME";
            switch (browserType) 
            {
                case FIREFOX:
                    driver = new FirefoxDriver();
                    break;
                case CHROME:
                    driver = new ChromeDriver();
                    break;
            }
        }
        return driver;
    }
}

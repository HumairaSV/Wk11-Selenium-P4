package saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowser {
    static String baseUrl = "https://www.saucedemo.com/";
    static String browser = "Firefox";
    static WebDriver driver;

    public static void main(String[] args) {

        if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.ghecko.driver", "drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }else {
            System.out.println("Incorrect browser name-Select from Chrome or Edge or Firefox");
        }

        //launching the url
        driver.get(baseUrl);
        //maximising the window
        driver.manage().window().maximize();
        //giving implicit wait time to the driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Print the title of the page
        System.out.println("Page title: " + driver.getTitle());
        //Print the current url
        System.out.println("Current url: " + driver.getCurrentUrl());
        //Print the title of the page
        System.out.println("Page source: " + driver.getPageSource());

        //Find the username field and send data to the field
        WebElement userField = driver.findElement(By.id("user-name"));
        userField.sendKeys("standard_user");

        //Find the password field and send data to the field
        WebElement passField = driver.findElement(By.id("password"));
        passField.sendKeys("secret_sauce");

        //closing the browser
        driver.quit();


    }

}


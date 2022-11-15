package saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class EdgeBrowser {

    public static void main(String[] args) {
        String baseUrl = "https://www.saucedemo.com/";
        System.setProperty("webdriver.edge.driver","drivers/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();

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


        //finding the username field and sending data to the field
        WebElement userField = driver.findElement(By.id("user-name"));
        userField.sendKeys("standard_user");
        //finding the password field and sending data to the field
        WebElement passField = driver.findElement(By.id("password"));
        passField.sendKeys("secret_sauce");

        //closing the browser
        driver.quit();
    }
}

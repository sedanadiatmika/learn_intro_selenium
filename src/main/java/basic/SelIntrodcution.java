package basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelIntrodcution {
    public static void main(String[] args){

        //Invoking Browser
        //Chrome - ChromeDriver --> Methods]pyrew
        //Firefox - FirefoxDriver --> Methods
        //Safari - SafariDriver --> Methods

        System.setProperty("webdriver.gecko.driver", "C:/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.quit();



    }
}

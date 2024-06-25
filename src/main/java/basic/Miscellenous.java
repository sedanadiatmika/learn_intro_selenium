package basic;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.commons.io.FileUtils;



import java.io.File;
import java.io.IOException;

public class Miscellenous {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.manage().deleteAllCookies();
//        driver.manage().deleteCookieNamed("sessionKey");
        //session
        //click on any link
        //login page verify login url
        driver.get("https://google.com/");
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, new File("D://screenshot.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}

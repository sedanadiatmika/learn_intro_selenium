package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ass5 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame(driver.findElement(By.cssSelector("frame[src='/frame_top']")));
        driver.switchTo().frame(driver.findElement(By.cssSelector("frame[src='/frame_middle']")));
        System.out.println(driver.findElement(By.id("content")).getText());
    }
}

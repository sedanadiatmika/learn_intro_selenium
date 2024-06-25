package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.security.Key;

public class Assign2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        driver.findElement(By.xpath("(//input[@name='name'])[1]")).sendKeys("Miko");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("miko@miko.com");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("miko1234");
        driver.findElement(By.xpath("//input[@id='exampleCheck1']")).click();

        WebElement staticDropdown = driver.findElement(By.xpath("//select[@id='exampleFormControlSelect1']"));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByVisibleText("Male");

        driver.findElement(By.xpath("//input[@id='inlineRadio2']")).click();
        driver.findElement(By.xpath("//input[@name='bday']")).sendKeys("0604");
        driver.findElement(By.xpath("//input[@name='bday']")).sendKeys(Keys.ARROW_RIGHT);
        driver.findElement(By.xpath("//input[@name='bday']")).sendKeys("2000");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText());



    }
}

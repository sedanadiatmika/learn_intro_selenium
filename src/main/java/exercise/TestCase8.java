package exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TestCase8 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        System.out.println("Begin Test");

        driver.get("https://automationexercise.com/");
        Assert.assertTrue(driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']")).isDisplayed());
        System.out.println("Home page is visible");

        driver.findElement(By.xpath("//a[@href='/products']")).click();
        driver.findElement(By.xpath("//h2[@class='title text-center']")).getText();

        driver.findElement(By.xpath("//a[@href='/product_details/1']")).click();

        System.out.println(driver.findElement(By.xpath("//div[@class='product-information']/h2")).getText());
        System.out.println(driver.findElement(By.xpath("//div[@class='product-information']/p[contains(text(), 'Category')]")).getText());
        System.out.println(driver.findElement(By.xpath("//div[@class='product-information']/span/span")).getText());
        System.out.println(driver.findElement(By.xpath("(//div[@class='product-information']/p)[2]")).getText());
        System.out.println(driver.findElement(By.xpath("(//div[@class='product-information']/p)[3]")).getText());
        System.out.println(driver.findElement(By.xpath("(//div[@class='product-information']/p)[4]")).getText());

        System.out.println("Test Finished");


    }
}

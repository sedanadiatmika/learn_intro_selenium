package exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TestCase5 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        System.out.println("Begin Test");

        driver.get("https://automationexercise.com/");

        Assert.assertTrue(driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']")).isDisplayed());
        System.out.println("Home page is visible");

        driver.findElement(By.cssSelector("a[href='/login']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("div[class='login-form'] h2")).isDisplayed());
        System.out.println("Login page is visible");

        String name = "Sedana Diatmika";
        String email = "sedanadiatmika2@tes.com";

        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(name);
        driver.findElement(By.xpath("(//input[@placeholder='Email Address'])[2]")).sendKeys(email);

        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
        Thread.sleep(3000);

        Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Email Address already exist!']")).isDisplayed());
        System.out.println("Email Address already exist");






    }
}

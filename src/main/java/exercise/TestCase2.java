package exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import javax.swing.*;

public class TestCase2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        System.out.println("Begin Test");

        driver.get("https://automationexercise.com/");

        driver.findElement(By.cssSelector("a[href='/login']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("div[class='login-form'] h2")).isDisplayed());
        driver.findElement(By.cssSelector("input[data-qa='login-email']")).sendKeys("sedanadiatmika2@tes.com");
        driver.findElement(By.cssSelector("input[data-qa='login-password']")).sendKeys("miko1234");
        driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//a/i[@class='fa fa-user']")).isDisplayed());

        driver.findElement(By.cssSelector("a[href='/logout']")).click();

    }
}

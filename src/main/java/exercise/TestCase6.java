package exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TestCase6 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        System.out.println("Begin Test");

        driver.get("https://automationexercise.com/");
        Assert.assertTrue(driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']")).isDisplayed());
        System.out.println("Home page is visible");

        driver.findElement(By.xpath("//a[@href='/contact_us']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='contact-form']/h2")).isDisplayed());
        System.out.println("Contact us page is visible");

        String name = "Miko";
        String email = "sedanadiatmika@test.com";
        String subject = "Test Test";
        String message = "Halo ini adalah suatu test yang saya lakukan";
        String file = "D:\\ProjekIntellij\\IntroSel\\file\\file.png";

        driver.findElement(By.xpath("//input[@data-qa='name']")).sendKeys(name);
        driver.findElement(By.xpath("//input[@data-qa='email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@data-qa='subject']")).sendKeys(subject);
        driver.findElement(By.xpath("//textarea[@data-qa='message']")).sendKeys(message);
        WebElement uploadFile = driver.findElement(By.xpath("//input[@name='upload_file']"));
        uploadFile.sendKeys(file);
        driver.findElement(By.xpath("//input[@data-qa='submit-button']")).click();
        driver.switchTo().alert().accept();

        System.out.println(driver.findElement(By.xpath("//div[@class='status alert alert-success']")).getText());

        driver.findElement(By.xpath("//a[@href='/']/i")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']")).isDisplayed());
        System.out.println("Home page is visible");

        System.out.println("Test Finished");
    }
}

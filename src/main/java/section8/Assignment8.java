package section8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Assignment8 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Duration d = Duration.ofSeconds(5);
        WebDriverWait w = new WebDriverWait(driver, d);
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot", "Carrot"};

        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("password")).sendKeys("learning");
        driver.findElement(By.xpath("//span[contains(.,'User')]")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
        driver.findElement(By.id("okayBtn")).click();

        WebElement staticDropdown = driver.findElement(By.xpath("//select"));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByValue("consult");

        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("signInBtn")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-info']")));
        int numberOfProducts = driver.findElements(By.xpath("//button[@class='btn btn-info']")).size();

        for(int i = 1; i <= numberOfProducts; i++) {
            String buttonXpath = "(//button[@class='btn btn-info'])[" + i + "]";
            driver.findElement(By.xpath(buttonXpath)).click();
        }

        driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
    }
}

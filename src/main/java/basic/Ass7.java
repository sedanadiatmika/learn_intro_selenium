package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Ass7 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

        List<WebElement> rows = driver.findElements(By.cssSelector(".table-display tr"));
        List<WebElement> columns = driver.findElements(By.cssSelector(".table-display th"));
        List<WebElement> secondRow = driver.findElements(By.cssSelector(".table-display tr:nth-child(3) td"));

        System.out.println(rows.size());
        System.out.println(columns.size());

        for (int i = 0; i < secondRow.size(); i++) {
            System.out.println(secondRow.get(i).getText());
        }
    }
}

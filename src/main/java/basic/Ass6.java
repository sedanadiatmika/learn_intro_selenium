package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class Ass6 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.id("checkBoxOption2")).click();
        String option = driver.findElement(By.cssSelector("label[for='benz']")).getText();

        WebElement staticDropdown = driver.findElement(By.id("dropdown-class-example"));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByVisibleText(option);
        driver.findElement(By.id("name")).sendKeys(option);

        driver.findElement(By.id("alertbtn")).click();
        String alertText = driver.switchTo().alert().getText();
        String[] alertSplit = alertText.split(" ");
        String name = alertSplit[1].replace(",","");

        if(name.equals(option)) {
            System.out.println("Code is correct");
        } else {
            System.out.println("Code is incorrect");
        }

    }
}

package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class JavaScriptExecutorDemo {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

        int b = 0;
        List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
        for(int i = 0; i < values.size(); i++) {
            int a = Integer.parseInt(values.get(i).getText());
            System.out.println(a);
            b = b + a;
        }
        System.out.println(b);

        String[] words = driver.findElement(By.cssSelector(".totalAmount")).getText().split(" ");
        if (b == Integer.parseInt(words[3])) {
            System.out.println("value is correct");
        } else {
            System.out.println("value is incorrect");
        }

    }
}

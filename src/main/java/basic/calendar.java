package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class calendar {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.path2usa.com/travel-companion/");

        // Scroll the Page
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,800)");

        Thread.sleep(2000);

        driver.findElement(By.id("form-field-travel_comp_date")).click();


        while (!driver.findElement(By.xpath("//div[@class='flatpickr-current-month']")).getText().contains("November")) {
            driver.findElement(By.xpath("//span[@class='flatpickr-next-month']")).click();
            Thread.sleep(2000);
        }

        List<WebElement> dates = driver.findElements(By.xpath("//span[@class='flatpickr-day ']"));

        for(int i = 0; i < dates.size(); i++){
            String text = driver.findElements(By.xpath("//span[@class='flatpickr-day ']")).get(i).getText();
            if(text.equalsIgnoreCase("30")) {
                driver.findElements(By.xpath("//span[@class='flatpickr-day ']")).get(i).click();
                break;
            }

        }
    }
}

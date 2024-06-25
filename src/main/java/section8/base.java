package section8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class base {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Duration d = Duration.ofSeconds(5);
        WebDriverWait w = new WebDriverWait(driver, d);
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot", "Carrot"};

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        addItems(driver, itemsNeeded);

        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[contains(text(), 'PROCEED TO CHECKOUT')]")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();

        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());


    }

    public static void addItems(WebDriver driver, String[] itemsNeeded){
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        int j = 0;
        for(int i = 0; i < products.size(); i++){
            //Brocolli - 1 Kg
            String[] name = products.get(i).getText().split("-");
            String formattedName = name[0].trim();
            // format it to get actual vegetable name
            // check weather name you extracted is present in array or not
            // convert array into array list for easy search

            List<String> itemsNeededList = Arrays.asList(itemsNeeded);


            if(itemsNeededList.contains(formattedName)){
                //click on add the cart
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                j++;
                if(j==itemsNeeded.length){
                    break;
                }
            }
        }
    }

}


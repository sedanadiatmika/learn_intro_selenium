package exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCase9 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        System.out.println("Begin Test");

        driver.get("https://automationexercise.com/");

        driver.findElement(By.xpath("//a[@href='/products']")).click();
        System.out.println(driver.findElement(By.xpath("//h2[@class='title text-center']")).getText());
        driver.findElement(By.id("search_product")).sendKeys("shirt");
        driver.findElement(By.id("submit_search")).click();

        List<WebElement> productsName = driver.findElements(By.xpath("//div[@class='productinfo text-center']/p"));
        System.out.println(productsName);

        ArrayList<String> productsNameText = new ArrayList<>();

        for(WebElement option :productsName){
            productsNameText.add(option.getText().toLowerCase());
        }

        int j = 0;
        for(int i = 0; i < productsNameText.size(); i++){

            if(productsNameText.get(i).contains("shirt")) {
                j += 1;
            }
        }

        System.out.println("The number of products name that have searched keyword: " + j);
        System.out.println("The number of products name that don't have searched keyword: " + (productsNameText.size() - j));

    }
}

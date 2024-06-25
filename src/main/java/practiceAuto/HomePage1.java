package practiceAuto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HomePage1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        System.out.println("Begin Test");

        driver.get("http://practice.automationtesting.in/");
        driver.manage().window().maximize();

        driver.findElement(By.id("menu-item-40")).click();
        driver.findElement(By.xpath("//nav[@class='woocommerce-breadcrumb']/a")).click();

        int slilders = driver.findElements(By.xpath("//div[@class='n2-ss-slider-3']/div")).size();
        System.out.println("Number of slider: " + slilders);
        Assert.assertEquals(slilders, 3);



    }
}

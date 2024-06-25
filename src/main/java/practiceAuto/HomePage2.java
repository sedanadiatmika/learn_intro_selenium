package practiceAuto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HomePage2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        System.out.println("Begin Test");

        driver.get("http://practice.automationtesting.in/");
        driver.manage().window().maximize();

        driver.findElement(By.id("menu-item-40")).click();
        driver.findElement(By.xpath("//nav[@class='woocommerce-breadcrumb']/a")).click();

        int arrivals = driver.findElements(By.cssSelector(".sub_row_1-0-2>div")).size();
        System.out.println("Number of arrivals: " + arrivals);
        Assert.assertEquals(arrivals, 3);

        driver.findElement(By.xpath("(//img[contains(@class, 'wp-post-image')])[1]")).click();
        System.out.println(driver.findElement(By.cssSelector(".product_title")).getText());

        driver.findElement(By.xpath("//a[@href='#tab-description']")).click();
        System.out.println(driver.findElement(By.id("tab-description")).getText());
        Assert.assertTrue(driver.findElement(By.id("tab-description")).isDisplayed());



    }
}

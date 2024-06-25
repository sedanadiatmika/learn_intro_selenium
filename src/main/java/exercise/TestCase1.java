package exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class TestCase1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        System.out.println("Begin Test");

        driver.get("https://automationexercise.com/");

        driver.findElement(By.linkText("Signup / Login")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(text(),'New User Signup!')]")).isDisplayed());

        String name = "Sedana Diatmika";
        String email = "sedanadiatmika2@tes.com";

        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(name);
        driver.findElement(By.xpath("(//input[@placeholder='Email Address'])[2]")).sendKeys(email);
        driver.findElement(By.xpath("//button[contains(text(), 'Signup')]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//b[contains(text(), 'Enter Account Information')]")).isDisplayed());

        driver.findElement(By.id("id_gender1")).click();
        Assert.assertEquals(driver.findElement(By.id("name")).getAttribute("value"), name);
        Assert.assertEquals(driver.findElement(By.id("email")).getAttribute("value"), email);
        driver.findElement(By.id("password")).sendKeys("miko1234");

        //date of birth
        WebElement staticDropdown1 = driver.findElement(By.id("days"));
        Select dropdown1 = new Select(staticDropdown1);
        dropdown1.selectByValue("6");

        WebElement staticDropdown2 = driver.findElement(By.id("months"));
        Select dropdown2 = new Select(staticDropdown2);
        dropdown2.selectByVisibleText("April");

        WebElement staticDropdown3 = driver.findElement(By.id("years"));
        Select dropdown3 = new Select(staticDropdown3);
        dropdown3.selectByVisibleText("2000");
        //end date of birth

        driver.findElement(By.id("newsletter")).click();
        driver.findElement(By.id("optin")).click();

        //address information
        driver.findElement(By.id("first_name")).sendKeys("Sedana");
        driver.findElement(By.id("last_name")).sendKeys("Diatmika");
        driver.findElement(By.id("company")).sendKeys("Timedoor");
        driver.findElement(By.id("address1")).sendKeys("Jl. Tukad Yeh Aya");
        WebElement staticDropdown4 = driver.findElement(By.id("country"));
        Select dropdown4 = new Select(staticDropdown4);
        dropdown4.selectByVisibleText("Singapore");
        driver.findElement(By.id("state")).sendKeys("Bali");
        driver.findElement(By.id("city")).sendKeys("Denpasar");
        driver.findElement(By.id("zipcode")).sendKeys("80511");
        driver.findElement(By.id("mobile_number")).sendKeys("082657645970");
        driver.findElement(By.xpath("//button[contains(text(), 'Create Account')]")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//b[contains(text(), 'Account Created!')]")).isDisplayed());
        driver.findElement(By.xpath("//a[contains(text(), 'Continue')]")).click();

        driver.findElement(By.xpath("//a/i[@class='fa fa-user']")).isDisplayed();
        driver.findElement(By.xpath("//a/i[@class='fa fa-trash-o']")).click();

        // web error


        System.out.println("Testing Over");

    }
}

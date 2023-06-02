package testrunners;

import com.qa.factory.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.qa.factory.DriverFactory.getDriver;

public class AutoSuggestionDropdown {
    private  static WebDriver driver;
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        System.out.println(System.getProperty("user.dir")+"/test.pdf");
        WebDriverManager.chromedriver().setup();
        tlDriver.set(new ChromeDriver());

        driver = tlDriver.get();
        driver.get("https://www.goibibo.com/");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div[1]/div/div/div[2]/span/span")).click();
        Thread.sleep(1000);

        driver.findElement(By.cssSelector(".dVpEne > div:nth-child(1) > p:nth-child(2)")).click();

        //type pune in From

        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("tunis");

        driver.findElement(By.xpath("//ul[@id='autoSuggest-list']/li/div/div/div/p[2]")).click();


        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("nagpur");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//ul[@id='autoSuggest-list']/li/div/div/div/p[2]")).click();

        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div/div/div[1]/div[3]/div[2]/div[2]/div/div/div[2]/div[2]/div[3]/div[4]/div[4]/p")).click();
        //select pune
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div/div/div[1]/div[3]/div[2]/div[3]/span[2]"));


        driver.close();
        }
}

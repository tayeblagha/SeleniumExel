package testrunners;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PdfUpload {
    private  static WebDriver driver;
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        System.out.println(System.getProperty("user.dir")+"/test.pdf");
        WebDriverManager.chromedriver().setup();
        tlDriver.set(new ChromeDriver());

        driver = tlDriver.get();
        driver.get("https://www.w3schools.com/howto/howto_html_file_upload_button.asp");

        driver.manage().window().maximize();

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement fileInput = driver.findElement(By.xpath("//input[@id='myFile']"));
        fileInput.sendKeys(System.getProperty("user.dir") + "/test.pdf");


        driver.close();
        }
}

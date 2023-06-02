package testrunners;

import java.io.IOException;

import java.net.*;

import java.time.Duration;

import java.util.List;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.hc.core5.annotation.Contract;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class BrokenLinks {
    private static Proxy proxy ;
    private  static WebDriver driver;
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public static void main(String[] args)  {


        // Create a new ChromeOptions object.
        ChromeOptions options = new ChromeOptions();

        WebDriverManager.chromedriver().setup();
        tlDriver.set(new ChromeDriver(options));

        driver = tlDriver.get();

        driver.get("https://whatismyipaddress.com/");

        driver.manage().window().maximize();




        List<WebElement> links=driver.findElements(By.xpath("//a[contains(@href,'.')]"));

        //for(WebElement link : links){System.out.println(link.getText());}
        for (WebElement link : links) {
            try {
                String url = link.getAttribute("href");
                HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
                con.setRequestMethod("HEAD");
                con.connect();

                int respcode = con.getResponseCode();

                if (respcode >= 400 && respcode!=999) {
                    System.out.println("Link Text: " + link.getText() + " Response Code: " + respcode +link.getAttribute("href"));
                }
            } catch (Exception ex) {
                System.out.println("Exception occurred for link: " + link.getAttribute("href"));
                System.out.println(ex);
               // ex.printStackTrace();
            }
        }



        driver.quit();


    }


}

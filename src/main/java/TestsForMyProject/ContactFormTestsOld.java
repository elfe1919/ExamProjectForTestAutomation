package TestsForMyProject;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by Kleine-Hexe on 16.07.2017.
 */
public class ContactFormTestsOld {
    WebDriver webDriver;
    @Test
    public void validContactFormMessage(){
        File fileFF = new File("D:\\AutomationTests\\ExamAutomation\\drivers\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        webDriver.get("https://45.77.53.253/contacts/");
        webDriver.findElement(By.xpath(".//input[@class='wpcf7-form-control wpcf7-text wpcf7-validates-as-required' and @name='your-name']")).sendKeys("Tatiana");
        webDriver.findElement(By.xpath(".//input[@name='your-email']")).sendKeys("test1@test.ua");
        webDriver.findElement(By.xpath(".//select[@id='City']//option[@value='city 1']")).click();
        webDriver.findElement(By.xpath(".//input[@name='date-833']")).sendKeys("1983-07-19");
        webDriver.findElement(By.xpath(".//input[@name='your-subject']")).sendKeys("Hello Test");
        webDriver.findElement(By.xpath(".//textarea[@name='your-message']")).sendKeys("Text in textarea");
        webDriver.findElement(By.xpath(".//input[@name='checkbox-705[]' and @value='var 1']")).click();
        webDriver.findElement(By.xpath(".//input[@class='wpcf7-form-control wpcf7-submit' and @type='submit']")).click();
        System.out.println("Contact Form message was sent");

        //webDriver.quit();

    }



    }




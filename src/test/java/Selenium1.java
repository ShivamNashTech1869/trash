import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;

public class Selenium1 {
    WebDriver driver ;
    WebDriverWait wait;
    File source;

    @BeforeMethod
    public void invokeDriver(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);   //implicit-Wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));                //Explicit-Wait

        this.source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    }

    @Test
    public void run() {


        driver.get("https://www.amazon.in/?tag=admpdesktopin-21&ref=pd_sl_f4d5625d72894547d09c03957ae723dc1913da7d2fea672ae96e67d7&mfadid=adm");
        System.out.println("Title : " + driver.getTitle());

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("B085G717XG");

        driver.findElement(By.id("nav-search-submit-button")).click();

        System.out.println("url : " + driver.getCurrentUrl());

        String currentWindow = driver.getWindowHandle();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class=\"a-section aok-relative s-image-square-aspect\"]")));

        driver.findElement(By.cssSelector("div[class=\"a-section aok-relative s-image-square-aspect\"]")).click();



        //Navigate to new window

        Set<String> windows = driver.getWindowHandles();

        for(String actualWindow : windows)
        {
            if(!actualWindow.equalsIgnoreCase(currentWindow)) {
                driver.switchTo().window(actualWindow);
                break;
            }
        }
//
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id='add-to-cart-button']")));

        System.out.println("url : " + driver.getCurrentUrl());


    }

    @AfterMethod
    public void tearDown() throws IOException {
        FileUtils.copyFile(source, new File("screenshot(last pick).png"));  //Take screenshot
        driver.quit();
    }
}
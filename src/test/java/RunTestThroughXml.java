import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
public class RunTestThroughXml {
    public static WebDriver driver;

    @BeforeTest
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterTest
    void close() {
        driver.close();
    }

    @Test
    void openMainPageAndApplyCookies() {
        driver.get("https://www.seznam.cz/");
        driver.findElement(By.xpath("//button[@data-dot='firmy']")).click();
        driver.findElement(By.xpath("//not_valid")).click();
    }
}

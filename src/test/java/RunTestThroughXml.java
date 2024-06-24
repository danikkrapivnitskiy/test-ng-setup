import org.openqa.selenium.By;
import org.testng.annotations.Test;
public class RunTestThroughXml extends BaseTest {
    @Test
    void openMainPageAndApplyCookies() {
        driver.get("https://www.seznam.cz/");
        driver.findElement(By.xpath("//button[@data-dot='firmy']")).click();
        driver.findElement(By.xpath("//not_valid")).click();
    }
}

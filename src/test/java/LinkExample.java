import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinkExample {

    public class LinkExampleTest {

        WebDriver driver;

        @BeforeMethod
        public void openTestLink() {

            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.leafground.com/link.xhtml");
        }

        @Test
        public  void testLink() {
            // Take me to the Dashboard
            WebElement homeLink = driver.findElement(By.linkText("Go to Dashboard"));
            homeLink.click();
            driver.navigate().back();

        }
    }
}

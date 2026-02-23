import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxExample {

    WebDriver driver;

    @BeforeMethod
    public void openTextBoxPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/input.xhtml");
    }

    @Test
    public  void testTextBox() {
        // 01. Type the name


        // 02. Append Country to the City



        // 03. Verify if text box is disabled



        // 04. Clear the typed text.






        // 05. Retrieve the typed text.




        // 06. Type email and Tab. Confirm control moved to next element.





        // 07. Type about yourself




        // 08. Text Editor





        // 09. Just Press Enter and confirm error message*


        // 10. Type your name and choose the third option

        // 11. Type your DOB (mm/dd/yyyy) and confirm date chosen.

        // 12. Type number and spin to confirm value changed.

        // 13. Type random number (1-100) and confirm slider moves correctly.

        // 14. Click and Confirm Label Position Changes

        // 15. Type your name and choose the third option.

        // 16. Type your DOB (mm/dd/yyyy) and confirm date chosen.

        // 17. Type number and spin to confirm value changed.

        //  18. Type random number (1-100) and confirm slider moves correctly.

        // 19. Click and Confirm Keyboard appears

        // 20. Custom Toolbar



    }



}

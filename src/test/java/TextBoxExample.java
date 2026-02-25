import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import java.util.List;

public class TextBoxExample {

    WebDriver driver;

    @BeforeMethod
    public void openTextBoxPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/input.xhtml");
    }

//    @AfterMethod
//    public void tearDown() {
//        if (driver != null) {
//            try { driver.quit(); } catch (Exception ignored) {}
//        }
//    }

    @Test
    public  void testTextBox() {
        // 01. Type the name
        WebElement typeName = driver.findElement(By.id("j_idt88:name"));
        typeName.sendKeys("Numesh Jayamanne");

        // 02. Append Country to the City
        WebElement appendCountry = driver.findElement(By.id("j_idt88:j_idt91"));
        appendCountry.sendKeys(" India");

        // 03. Verify if text box is disabled
        WebElement isDisabled = driver.findElement(By.id("j_idt88:j_idt93"));
        if (isDisabled.isEnabled()) {
            System.out.println("The box is enabled");
        } else {
        System.out.println("The box is disabled"); }

        // 04. Clear the typed text.
        WebElement clearText = driver.findElement(By.id("j_idt88:j_idt95"));
        clearText.clear();

        // 05. Retrieve the typed text.
        WebElement retrieveText = driver.findElement(By.id("j_idt88:j_idt97"));
        String text = retrieveText.getAttribute("value");
        System.out.println("The typed text is: " + text);

        // 06. Type email and Tab. Confirm control moved to next element.
        WebElement typeEmail = driver.findElement(By.id("j_idt88:j_idt99"));
        typeEmail.sendKeys("numesh@gmail.com" + Keys.TAB + "Confirmed control moved to next element. "+Keys.ENTER);


        // 07. Type about yourself (textarea)
        try {
            WebElement typeAbout = driver.findElement(By.id("j_idt88:j_idt101"));
            typeAbout.sendKeys("I am a test automation engineer. I like writing simple, reliable Selenium tests.");
            System.out.println("07: Typed about myself.");
        } catch (Exception e) {
            System.out.println("07: About textarea not found.");
        }


        // 08. Text Editor (try contenteditable or iframe)
        try {
            WebElement textEditor = driver.findElement(By.xpath("//div[@id='j_idt88:j_idt103_editor']//p"));
            textEditor.sendKeys("Regular Text");
            textEditor.sendKeys(Keys.ENTER);
            textEditor.sendKeys(Keys.chord(Keys.CONTROL, "b") + "Bold Text by Ctrl + B");
            textEditor.sendKeys(Keys.CONTROL + "b");
            textEditor.sendKeys(Keys.ENTER);

            WebElement boltKey = driver.findElement(By.className("ql-bold"));
            boltKey.click();
            textEditor.sendKeys("Bold Text by Button");
            boltKey.click();
            textEditor.sendKeys(Keys.ENTER);

            WebElement italicKey = driver.findElement(By.className("ql-stroke"));
            italicKey.click();
            textEditor.sendKeys("Italic Text by Button");
            italicKey.click();
            textEditor.sendKeys(Keys.ENTER);





         } catch (Exception e) {
             driver.switchTo().defaultContent();
             System.out.println("08: Error - " + e.getMessage());
         }
//
//        // 09. Just Press Enter and confirm error message*
//        try {
//            // find an input that might require Enter (look for placeholder or label text)
//            WebElement enterInput = null;
//            List<WebElement> inputs = driver.findElements(By.xpath("//input"));
//            if (!inputs.isEmpty()) enterInput = inputs.get(0);
//            if (enterInput != null) {
//                enterInput.sendKeys(Keys.ENTER);
//                // wait a short time and try to find an error message
//                Thread.sleep(500);
//                List<WebElement> msgs = driver.findElements(By.cssSelector(".ui-message, .ui-messages, .error, .ui-error"));
//                if (!msgs.isEmpty()) {
//                    System.out.println("09: Found message after Enter: " + msgs.get(0).getText());
//                } else {
//                    System.out.println("09: No error message found after Enter (may not apply on this page).");
//                }
//            } else {
//                System.out.println("09: No input found to press Enter on.");
//            }
//        } catch (Exception e) {
//            System.out.println("09: Error - " + e.getMessage());
//        }
//
//        // 10. Type your name and choose the third option (autocomplete)
//        try {
//            WebElement ac = null;
//            // try to find an autocomplete-like input
//            List<WebElement> acInputs = driver.findElements(By.cssSelector("input.ui-autocomplete-input, input[role='combobox']"));
//            if (!acInputs.isEmpty()) ac = acInputs.get(0);
//            if (ac == null) {
//                // fallback: try a text input after the email field
//                List<WebElement> allText = driver.findElements(By.xpath("//input[@type='text']"));
//                if (allText.size() > 2) ac = allText.get(2);
//            }
//            if (ac != null) {
//                ac.clear();
//                ac.sendKeys("Numesh");
//                // wait for suggestions
//                Thread.sleep(700);
//                List<WebElement> suggestions = driver.findElements(By.cssSelector("ul.ui-autocomplete-list li, ul.ui-autocomplete-items li, .ui-autocomplete-results li"));
//                if (suggestions.size() >= 3) {
//                    suggestions.get(2).click();
//                    System.out.println("10: Selected third autocomplete option.");
//                } else {
//                    System.out.println("10: Less than 3 suggestions available (found " + suggestions.size() + ").");
//                }
//            } else {
//                System.out.println("10: Autocomplete input not found.");
//            }
//        } catch (Exception e) {
//            System.out.println("10: Error - " + e.getMessage());
//        }
//
//        // 11. Type your DOB (mm/dd/yyyy) and confirm date chosen.
//        try {
//            WebElement dateInput = null;
//            List<WebElement> dates = driver.findElements(By.cssSelector("input[type='date'], input.ui-date, input.hasDatepicker, input[placeholder*='date'], input[placeholder*='DOB']"));
//            if (!dates.isEmpty()) dateInput = dates.get(0);
//            if (dateInput == null) {
//                List<WebElement> textInputs = driver.findElements(By.xpath("//input[@type='text']"));
//                for (WebElement el : textInputs) {
//                    String id = el.getAttribute("id");
//                    if (id != null && id.toLowerCase().contains("date")) { dateInput = el; break; }
//                }
//            }
//            if (dateInput != null) {
//                dateInput.clear();
//                dateInput.sendKeys("01/01/1990");
//                dateInput.sendKeys(Keys.TAB);
//                System.out.println("11: Entered DOB into date field.");
//            } else {
//                System.out.println("11: Date input not found.");
//            }
//        } catch (Exception e) {
//            System.out.println("11: Error - " + e.getMessage());
//        }
//
//        // 12. Type number and spin to confirm value changed.
//        try {
//            WebElement num = null;
//            List<WebElement> numbers = driver.findElements(By.cssSelector("input[type='number'], input.ui-spinner-input"));
//            if (!numbers.isEmpty()) num = numbers.get(0);
//            if (num == null) {
//                // fallback: find any input with numeric-like id
//                List<WebElement> all = driver.findElements(By.xpath("//input"));
//                for (WebElement el : all) {
//                    String id = el.getAttribute("id");
//                    if (id != null && id.toLowerCase().contains("number")) { num = el; break; }
//                }
//            }
//            if (num != null) {
//                num.clear();
//                num.sendKeys("5");
//                // try arrow up to spin
//                num.sendKeys(Keys.ARROW_UP);
//                System.out.println("12: Set number input and attempted spin.");
//            } else {
//                System.out.println("12: Number input not found.");
//            }
//        } catch (Exception e) {
//            System.out.println("12: Error - " + e.getMessage());
//        }
//
//        // 13. Type random number (1-100) and confirm slider moves correctly.
//        try {
//            WebElement slider = null;
//            List<WebElement> sliders = driver.findElements(By.cssSelector("div.ui-slider, .ui-slider"));
//            if (!sliders.isEmpty()) slider = sliders.get(0);
//            if (slider != null) {
//                // move slider by offset
//                actions.clickAndHold(slider).moveByOffset(50, 0).release().perform();
//                System.out.println("13: Attempted to move slider.");
//            } else {
//                System.out.println("13: Slider not found.");
//            }
//        } catch (Exception e) {
//            System.out.println("13: Error - " + e.getMessage());
//        }
//
//        // 14. Click and Confirm Label Position Changes
//        try {
//            // find an input with a label sibling
//            WebElement inputWithLabel = null;
//            List<WebElement> inputs = driver.findElements(By.xpath("//input"));
//            if (!inputs.isEmpty()) inputWithLabel = inputs.get(0);
//            if (inputWithLabel != null) {
//                // find the label for it (by for=)
//                String id = inputWithLabel.getAttribute("id");
//                WebElement label = null;
//                if (id != null) {
//                    try { label = driver.findElement(By.cssSelector("label[for='" + id + "']")); } catch (Exception ignored) {}
//                }
//                // click input and check label location/class
//                int beforeY = -1; int afterY = -1;
//                if (label != null) {
//                    beforeY = label.getLocation().getY();
//                }
//                inputWithLabel.click();
//                Thread.sleep(300);
//                if (label != null) afterY = label.getLocation().getY();
//                System.out.println("14: Label Y before=" + beforeY + " after=" + afterY);
//            } else {
//                System.out.println("14: No input found to test label position.");
//            }
//        } catch (Exception e) {
//            System.out.println("14: Error - " + e.getMessage());
//        }
//
//        // 15-18. Repeat/variations of earlier behaviors (kept minimal)
//        try {
//            System.out.println("15: Typing name into next available text input if present.");
//            List<WebElement> texts = driver.findElements(By.xpath("//input[@type='text']"));
//            if (texts.size() > 3) {
//                texts.get(3).sendKeys("Test Name 15");
//            }
//        } catch (Exception e) { System.out.println("15: Error - " + e.getMessage()); }
//
//        try { System.out.println("16: Attempting to type DOB into next date-like field.");
//            List<WebElement> dateInputs = driver.findElements(By.cssSelector("input[type='date']"));
//            if (!dateInputs.isEmpty()) { dateInputs.get(0).sendKeys("02/02/1992"); }
//        } catch (Exception e) { System.out.println("16: Error - " + e.getMessage()); }
//
//        try { System.out.println("17: Incrementing number-like field if present.");
//            List<WebElement> numInputs = driver.findElements(By.cssSelector("input[type='number']"));
//            if (!numInputs.isEmpty()) { numInputs.get(0).sendKeys(Keys.ARROW_UP); }
//        } catch (Exception e) { System.out.println("17: Error - " + e.getMessage()); }
//
//        try { System.out.println("18: Attempting another slider move if available.");
//            List<WebElement> moreSliders = driver.findElements(By.cssSelector(".ui-slider"));
//            if (!moreSliders.isEmpty()) { actions.clickAndHold(moreSliders.get(0)).moveByOffset(30,0).release().perform(); }
//        } catch (Exception e) { System.out.println("18: Error - " + e.getMessage()); }
//
//        // 19. Click and Confirm Keyboard appears (best-effort: focus and check activeElement)
//        try {
//            List<WebElement> inputsAll = driver.findElements(By.xpath("//input|//textarea"));
//            if (!inputsAll.isEmpty()) {
//                WebElement el = inputsAll.get(0);
//                el.click();
//                Object active = js.executeScript("return document.activeElement === arguments[0];", el);
//                System.out.println("19: Element focused? " + active);
//            } else {
//                System.out.println("19: No focusable input found.");
//            }
//        } catch (Exception e) { System.out.println("19: Error - " + e.getMessage()); }
//
//        // 20. Custom Toolbar (check presence)
//        try {
//            List<WebElement> toolbars = driver.findElements(By.cssSelector(".ui-toolbar, .toolbar, .ql-toolbar, .editor-toolbar"));
//            if (!toolbars.isEmpty()) {
//                System.out.println("20: Found a toolbar element.");
//            } else {
//                System.out.println("20: No custom toolbar found on the page.");
//            }
//        } catch (Exception e) { System.out.println("20: Error - " + e.getMessage()); }

    }


}

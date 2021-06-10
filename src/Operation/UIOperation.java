package Operation;

import java.util.ArrayList;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UIOperation {

    WebDriver driver;

    public void perform(String keyword, String testData, String expectResult, String xpath) throws Exception {
        //System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
        switch (keyword) {
            case "openBrowser":
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;

            case "navigate":
                driver.get(testData);
                break;

            case "verifyWebTitle":
                driver.getTitle();
                assertEquals(driver.getTitle(), expectResult);
                break;

            case "verifyElementIsDisplay":
                assertTrue(driver.findElement(By.xpath(xpath)).isDisplayed());
                break;

            case "inputText":
                driver.findElement(By.xpath(xpath)).sendKeys(testData);
                break;

            case "clickElement":
                driver.findElement(By.xpath(xpath)).sendKeys(Keys.ENTER);

                break;

            case "verityListContainsText":
                ArrayList<WebElement> listResult = new ArrayList<>(driver.findElements(By.xpath(xpath)));
                for (WebElement element : listResult) {
                    String result = element.getText();
                    assertTrue(result.toLowerCase().contains(expectResult.toLowerCase()));
                }
                break;

            case "closeBrowser":
                driver.close();
                break;

        }
    }
}

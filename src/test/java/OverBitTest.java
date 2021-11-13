import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.OverBitPage;

public class OverBitTest {
    private WebDriver driver;
    private OverBitPage overBitPage;
    private final String email = "podrez2002@gmail.com";
    private final String password = "Qwerty01";

    @BeforeMethod
    public void initializeBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        overBitPage = new OverBitPage(driver).openPage()
                .enterSystem()
                .enterEmail(email)
                .enterPassword(password)
                .enterLogIn()
                .clickSettings()
                .clickGoToDemoTrader()
                .chooseLimit()
                .checkOrder();
    }

    @Test
    public void findNewOrderTest() {
        int numOrderBeforeAdd = overBitPage.countOrder();
        int numOrderAfterAdd;
        overBitPage.clickCheckBoxProfit()
                .clickBuyBTC()
                .clickConfirmOrder()
                .checkOrder();
        numOrderAfterAdd = overBitPage.countOrder();

        Assert.assertEquals(numOrderAfterAdd - numOrderBeforeAdd, 1);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
        driver = null;
    }
}

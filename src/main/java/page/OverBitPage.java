package page;

import org.openqa.selenium.*;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class OverBitPage extends AbstractPage {
    private final String siteUrl = "https://www.overbit.com/en/";
    private final By buttonSystem = By.xpath("//div[contains(@class, 'loginButton') and contains(@class, 'elementor-hidden-phone')]//span[@class='elementor-button-text']");
    private final By buttonEnterEmail = By.name("email");
    private final By buttonPassword = By.name("password");
    private final By buttonLogIn = By.xpath("//form[@id='Login-Login-Email-Form']/div[@class='Login-Card-Item Login-Main-Action Action-Button']");
    private final By buttonSettings = By.xpath("//*[contains(text(), 'Settings')]");
    private final By buttonGoToDemoTrader = By.xpath("//*[contains(text(), 'Go to Demo Trader')]");
    private final By buttonChooseLimit = By.xpath("//*[contains(text(), 'Limit')]");
    private final By buttonCheckBoxProfit = By.xpath("//div[@class='MarketOrder-Quantity-Key' and text()='Take Profit']//input");
    private final By buttonBuyBTC = By.xpath("//div[@class='MarketOrder-Action-Buy']");
    private final By buttonConfirmOrder = By.xpath("//div[@class='MarketOrder-Confirm-Paper-Buttons-Confirm']");
    private final By buttonCheckOrder = By.xpath("//*[contains(text(), 'Active Orders')]/parent::button");
    private final By locatorForNewOrder = By.xpath("//div[contains(@class, 'Tables-Tour')]//div[@class='Tables-Table']//tbody/*");
    private final By locatorForOpenOrderNotification = By.xpath("//div[contains(@class, 'notification-container')]//div[text()='Order Opened']");

    public OverBitPage(WebDriver driver) {
        super(driver);
    }

    public OverBitPage openPage() {
        driver.get(siteUrl);
        return this;
    }

    public OverBitPage enterSystem() {
        WebElement waitingButton  = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(buttonSystem));
        waitingButton.click();
        return this;
    }

    public OverBitPage enterEmail(String email) {
        WebElement waitingButton  = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(buttonEnterEmail));
        waitingButton.sendKeys(email);
        return this;
    }

    public OverBitPage enterPassword(String password) {
        WebElement waitingButton  = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(buttonPassword));
        waitingButton.sendKeys(password);
        return this;
    }

    public OverBitPage enterLogIn() {
        WebElement waitingButton  = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(buttonLogIn));
        waitingButton.click();
        return this;
    }

    public OverBitPage clickSettings() {
        WebElement waitingButton  = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(buttonSettings));
        waitingButton.click();
        return this;
    }

    public OverBitPage clickGoToDemoTrader() {
        WebElement waitingButton  = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(buttonGoToDemoTrader));
        waitingButton.click();
        return this;
    }

    public OverBitPage chooseLimit() {
        WebElement waitingButton  = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(buttonChooseLimit));
        waitingButton.click();
        return this;
    }

    public OverBitPage clickCheckBoxProfit() {
        WebElement waitingButton  = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(buttonCheckBoxProfit));
        waitingButton.click();
        return this;
    }

    public OverBitPage clickBuyBTC() {
        WebElement waitingButton  = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(buttonBuyBTC));
        waitingButton.click();
        return this;
    }

    public OverBitPage clickConfirmOrder() {
        WebElement waitingButton  = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(buttonConfirmOrder));
        waitingButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(locatorForOpenOrderNotification));
        return this;
    }

    public OverBitPage checkOrder() {
        WebElement waitingButton  = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(buttonCheckOrder));
        waitingButton.click();
        return this;
    }

    public int countOrder(){
        int numPositions;
        try {
            List<WebElement> containerForNewOrder = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                    .until(ExpectedConditions.presenceOfAllElementsLocatedBy(locatorForNewOrder));
            numPositions = containerForNewOrder.size();
        } catch (TimeoutException timeoutException) {
            numPositions = 0;
        }
        return numPositions;
    }
}

import io.qameta.allure.Attachment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.UUID;

public class MainPage {

    private WebDriver webDriver;
    private WebDriverWait wait;

    @FindBy(css = ".wg-header__free-trial-form:nth-child(1) > .wg-header__free-trial-button")
    WebElement startedMainButton;
    @FindBy(css = ".modal-form-trial__input")
    WebElement fieldEmailMain;
    @FindBy(css = ".modal-form-trial__submit")
    WebElement createAccountButton;

    public MainPage(WebDriver driver){

        webDriver = driver;
        wait = new WebDriverWait(webDriver, 10, 500);

        PageFactory.initElements(webDriver, this);

    }

    public void clickStartedForFree(){

        startedMainButton.click();
    }

    public void enterRandomEmail(){

        fieldEmailMain.clear();
        fieldEmailMain.sendKeys(generateRandomString() + "+wpt@wriketask.qaa");

    }

    public void clickCreateAccount(){

        createAccountButton.click();

    }

    @Attachment
    private String generateRandomString(){

        String uuid = UUID.randomUUID().toString().replace("-", "");
        int left = (int) (Math.random()*uuid.length());
        int right = (int) (Math.random()* (uuid.length() - left) + left);

        return uuid.substring(left,right);

    }

}

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class MainPageSteps {

    private WebDriver webDriver;
    private MainPage mainPage;

    public MainPageSteps(WebDriver webDriver){

        this.webDriver = webDriver;
        mainPage = new MainPage(this.webDriver);

    }

    @Step("Opening wrike.com")
    public void openMainPageStep(){

        webDriver.get("https://www.wrike.com/");

    }

    @Step("Generating random email and creating an account with it")
    public void createAccountWithRandomEmailStep(){

        mainPage.clickStartedForFree();
        mainPage.enterRandomEmail();
        mainPage.clickCreateAccount();

    }


}

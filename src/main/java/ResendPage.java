import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class ResendPage {

    private WebDriver webDriver;
    private WebDriverWait wait;

    @FindBy(css = ".RveJvd.snByac")
    private WebElement googleAnswerNo;
    @FindBy(css = "iframe[ng-non-bindable]")
    private WebElement additionalFrame;

    @FindAll({
            @FindBy(css = "[for='interest_in_solution_1'] button.switch__button"),
            @FindBy(css = "[for='interest_in_solution_2'] button.switch__button")
    })
    private List<WebElement> interestQuestion;

    @FindAll({
            @FindBy(css = "[data-code='team_members'] > .switch:nth-child(1) .switch__button"),
            @FindBy(css = "[data-code='team_members'] > .switch:nth-child(2) .switch__button"),
            @FindBy(css = "[data-code='team_members'] > .switch:nth-child(3) .switch__button"),
            @FindBy(css = "[data-code='team_members'] > .switch:nth-child(4) .switch__button"),
            @FindBy(css = "[data-code='team_members'] > .switch:nth-child(5) .switch__button")
    })
    private List<WebElement> teamQuestion;

    @FindAll({
            @FindBy(css = "[data-code='primary_business'] > .switch:nth-child(1) .switch__button"),
            @FindBy(css = "[data-code='primary_business'] > .switch:nth-child(2) .switch__button"),
            @FindBy(css = "[data-code='primary_business'] > .switch:nth-child(3) .switch__button")
    })
    private List<WebElement> primaryBusinessQuestion;
    @FindBy(css = ".switch__input")
    private WebElement otherAnswer;

    @FindBy(css = ".js-survey-submit")
    private WebElement submitResultsButton;
    @FindBy(css = ".survey-form")
    private WebElement formQA;

    @FindBy(css = ".wg-btn--hollow.js-button")
    private WebElement resendEmailButton;
    @FindAll({
            @FindBy(css = ".wg-btn--hollow.js-button span")
    })
    private List<WebElement> emailCheck;
    @FindAll({
        @FindBy(css = "[href='https://twitter.com/wrike'] use")
    })
    private List<WebElement> twitterButton;

    public ResendPage (WebDriver driver){

        webDriver = driver;
        wait = new WebDriverWait(webDriver, 10, 500);

        PageFactory.initElements(webDriver, this);

    }

    public boolean correctURLResendPage(){

        wait.until(ExpectedConditions.visibilityOf(formQA));

        return webDriver.getCurrentUrl().contains("https://www.wrike.com/resend/");

    }

    public void closeGoogleQuestion(){

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(additionalFrame));

        try {
            Thread.sleep(2500);
        } catch (Exception e){
            e.printStackTrace();
        }

        googleAnswerNo.click();

        webDriver.switchTo().defaultContent();

    }

    public void randomFillInterestsSection(){

        interestQuestion.get((int) (Math.random() * interestQuestion.size())).click();

    }

    public void randomFillTeamSection(){

        teamQuestion.get((int) (Math.random() * teamQuestion.size())).click();

    }

    public void randomFillBusinessSection(){

        int businessRand = (int) (Math.random() * primaryBusinessQuestion.size());
        primaryBusinessQuestion.get(businessRand).click();

        if(businessRand == primaryBusinessQuestion.size() - 1){
            otherAnswer.sendKeys("Random text");
        }

    }

    public void clickSubmitResultsAndWaitSubmit(){

        submitResultsButton.click();
        wait.until(ExpectedConditions.attributeContains(formQA,  "style", "display: none;"));

    }

    public boolean checkSubmitResult(){

        return !(formQA.isDisplayed());

    }

    public void clickResendEmail(){

        resendEmailButton.click();

    }

    public boolean checkResendEmail(){

        return emailCheck.size() > 0;

    }

    public boolean constainsTwitterButton(){

        return twitterButton.size() > 0;

    }

    public boolean checkIconTwitter(){

        return twitterButton.get(0).getAttribute("xlink:href").contains("/content/themes/wrike/dist/img/sprite/vector/footer-icons.symbol.svg?v1#twitter");

    }

}

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class ResendPageSteps {

    private WebDriver webDriver;
    private ResendPage resendPage;
    private String relativeTwitterImageLink = "/content/themes/wrike/dist/img/sprite/vector/footer-icons.symbol.svg?v1#twitter";

    public ResendPageSteps(WebDriver webDriver){

        this.webDriver = webDriver;
        resendPage = new ResendPage(this.webDriver);

    }

    @Step("Closing Google question")
    public void closeGoogleQuestionStep(){

        resendPage.closeGoogleQuestion();

    }

    @Step("Filling in the Q&A section at the left part of page")
    public void randomFillQASectionStep(){

        resendPage.randomFillInterestsSection();
        resendPage.randomFillTeamSection();
        resendPage.randomFillBusinessSection();

    }

    @Step("Checking with assertion that answers are submitted")
    public void submitResultsQASectionStep(){

        resendPage.clickSubmitResultsAndWaitSubmit();
        Assert.assertTrue(resendPage.checkSubmitResult());

    }

    @Step("Checking with assertion that we are moved to the next page")
    public void checkURLResendPageStep(){

        Assert.assertTrue(resendPage.correctURLResendPage());

    }

    @Step("Checking  resend email after clicked on \"Resend email\"")
    public void checkResendEmailStep(){

        resendPage.clickResendEmail();
        Assert.assertTrue(resendPage.checkResendEmail());

    }

    @Step("Checking that section \"Follow us\" at the site footer contains the \"Twitter\" button that leads to the correct url")
    public void checkTwitterButtonStep(){

        Assert.assertTrue(resendPage.constainsTwitterButton());

    }

    @Step("Checking that \"Twitter\" button has the correct icon")
    public void checkIconTwitterStep(){

        Assert.assertTrue(resendPage.checkIconTwitter(relativeTwitterImageLink));

    }


}

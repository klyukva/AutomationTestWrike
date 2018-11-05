import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WrikeTests {

    WebDriver webDriver;
    MainPage mainPage;
    ResendPage resendPage;

    @Before
    public void setUp(){

        webDriver = new ChromeDriver();
        mainPage = new MainPage(webDriver);
        resendPage = new ResendPage(webDriver);

        System.out.println("Open url: wrike.com");
        webDriver.get("https://www.wrike.com/");

        System.out.println("Click \"Get started for free\" button near \"Login\" button");
        mainPage.clickStartedForFree();

        System.out.println("Fill in the email field with random generated value of email with mask “<random_text>+wpt@wriketask.qaa”");
        mainPage.enterRandomEmail();

        System.out.println("Click on \"Create my Wrike account\" button");
        mainPage.clickCreateAccount();

    }

    @Test
    public void testQASection(){

        System.out.println("Close Google question");
        resendPage.closeGoogleQuestion();

        System.out.println("Fill in the Q&A section at the left part of page");
        resendPage.randomFillInterestsSection();
        resendPage.randomFillTeamSection();
        resendPage.randomFillBusinessSection();

        System.out.println("Check with assertion that your answers are submitted");
        resendPage.clickSubmitResultsAndWaitSubmit();
        Assert.assertTrue(resendPage.checkSubmitResult());

    }

    @Test
    public void testMovedToResendPage(){

        System.out.println("Check with assertion that you are moved to the next page");
        Assert.assertTrue(resendPage.correctURLResendPage());

    }

    @Test
    public void testResendEmail(){

        System.out.println("Close Google question");
        resendPage.closeGoogleQuestion();

        System.out.println("Click on \"Resend email\"");
        resendPage.clickResendEmail();

        System.out.println("Check resend email");
        Assert.assertTrue(resendPage.checkResendEmail());

    }

    @Test
    public void testFollowTwitter(){

        System.out.println("Close Google question");
        resendPage.closeGoogleQuestion();

        System.out.println("Check that section \"Follow us\" at the site footer contains the \"Twitter\" button that leads to the correct url");
        Assert.assertTrue(resendPage.constainsTwitterButton());

        System.out.println("Check that \"Twitter\" button has the correct icon");
        Assert.assertTrue(resendPage.checkIconTwitter());

    }

    @After
    public void tearDown(){

        if(webDriver != null)
            webDriver.quit();

    }

}

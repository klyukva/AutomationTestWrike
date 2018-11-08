import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestWrike {

    WebDriver webDriver;
    MainPageSteps mainPageSteps;
    ResendPageSteps resendPageSteps;

    @Before
    public void setUp(){

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        webDriver = new ChromeDriver();
        mainPageSteps = new MainPageSteps(webDriver);
        resendPageSteps = new ResendPageSteps(webDriver);

        mainPageSteps.openMainPageStep();
        mainPageSteps.createAccountWithRandomEmailStep();

    }


    @Test
    public void testQASection(){

        resendPageSteps.closeGoogleQuestionStep();
        resendPageSteps.randomFillQASectionStep();
        resendPageSteps.submitResultsQASectionStep();

    }

    @Test
    public void testMovedToResendPage(){

        resendPageSteps.checkURLResendPageStep();

    }

    @Test
    public void testResendEmail(){

        resendPageSteps.closeGoogleQuestionStep();
        resendPageSteps.checkResendEmailStep();

    }

    @Test
    public void testFollowTwitter(){

       resendPageSteps.closeGoogleQuestionStep();
       resendPageSteps.checkTwitterButtonStep();
       resendPageSteps.checkIconTwitterStep();

    }

    @After
    public void tearDown(){

        if(webDriver != null)
            webDriver.quit();

    }

}

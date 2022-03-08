package tests;

import static org.junit.Assert.assertTrue;
import java.text.ParseException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.CommonConditions;
import pages.SectionComplicatedButtons;
import pages.SectionComplicatedRandomStuff;
import pages.SectionComplicatedSocialMedia;
import pages.PageHome;

public class AutomationTest extends CommonConditions {

    private String webpage = "https://ultimateqa.com/automation/";

    @Before
    public void NavigateToWebPage() {

        PageHome pageHome = new PageHome(driver);
        pageHome.navigate(webpage);

        try {
            pageHome.selectOption();

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }
        assertTrue("Title is not matching with expected value.", pageHome.getTitle());
    }

    @Test
    public void ButtonsSection() throws InterruptedException, ParseException {

        SectionComplicatedButtons sectionComplicatedButtons = new SectionComplicatedButtons(driver);

        Assert.assertEquals("Section of Buttons", sectionComplicatedButtons.buttonsText());

        Assert.assertEquals("Section of Social Media Follows", sectionComplicatedButtons.socialMediaText());

        Assert.assertEquals("Section of Random Stuff", sectionComplicatedButtons.randomStuffText());

        sectionComplicatedButtons.clickToAllButtons();

    }

    @Test
    public void SocialMediaSection() {

        SectionComplicatedSocialMedia sectionComplicatedSocialMedia = new SectionComplicatedSocialMedia(driver);

        int socialMediaSize = sectionComplicatedSocialMedia.SocialMediaElements();
        Assert.assertTrue("Elements not found.", socialMediaSize > 0);

    }

    @Test
    public void RandomStuffSection() throws InterruptedException {

        SectionComplicatedRandomStuff sectionComplicatedRandomStuff = new SectionComplicatedRandomStuff(driver);
        String VALOR = sectionComplicatedRandomStuff.captchaValue();
        sectionComplicatedRandomStuff.text("Pedro Bernabe Quiros", "bernabe.q@gmail.com",
                "Hola, este es un mensaje de prueba.", VALOR);
        Thread.sleep(2000);
        Assert.assertEquals("Thanks for contacting us", sectionComplicatedRandomStuff.successMessage());

    }

    @Test
    public void RandomStuffSection_FAILED() throws InterruptedException {
        SectionComplicatedRandomStuff sectionComplicatedRandomStuff = new SectionComplicatedRandomStuff(driver);
        String VALOR = sectionComplicatedRandomStuff.captchaValue();
        sectionComplicatedRandomStuff.text("Pedro Bernabe Quiros", "bernabe.q@gmail.com",
                "Hola, este es un mensaje de prueba.", VALOR);
        Thread.sleep(2000);
        Assert.assertEquals("This should fail!",
                sectionComplicatedRandomStuff.successMessage());

    }
}
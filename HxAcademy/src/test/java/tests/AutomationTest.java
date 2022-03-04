package tests;

import static org.junit.Assert.assertTrue;
import java.text.ParseException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.CommonConditions;
import pages.PageComplicatedButtons;
import pages.PageComplicatedRandomStuff;
import pages.PageComplicatedSocialMedia;
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
        assertTrue("El titulo de la pagina no es el esperado.", pageHome.getTitle());
    }

    @Test
    public void ButtonsSection() throws InterruptedException, ParseException {

        PageComplicatedButtons pageComplicatedButtons = new PageComplicatedButtons(driver);

        Assert.assertEquals("Section of Buttons", pageComplicatedButtons.buttonsText());

        Assert.assertEquals("Section of Social Media Follows", pageComplicatedButtons.socialMediaText());

        Assert.assertEquals("Section of Random Stuff", pageComplicatedButtons.randomStuffText());

        pageComplicatedButtons.clickToAllButtons();

    }

    @Test
    public void SocialMediaSection() {

        PageComplicatedSocialMedia pageComplicatedSocialMedia = new PageComplicatedSocialMedia(driver);

        int socialMediaSize = pageComplicatedSocialMedia.SocialMediaElements();
        Assert.assertTrue("No se encontraron elementos.", socialMediaSize > 0);

    }

    @Test
    public void RandomStuffSection() throws InterruptedException {

        PageComplicatedRandomStuff pageComplicatedRandomStuff = new PageComplicatedRandomStuff(driver);
        String VALOR = pageComplicatedRandomStuff.captchaValue();
        pageComplicatedRandomStuff.text("Pedro", "berna@gmail.com", "Hola!!!", VALOR);
        Thread.sleep(2000);
        Assert.assertEquals("Thanks for contacting us", pageComplicatedRandomStuff.successMessage());

    }

    @Test
    public void RandomStuffSection_FAILED() throws InterruptedException {
        PageComplicatedRandomStuff pageComplicatedRandomStuff = new PageComplicatedRandomStuff(driver);
        String VALOR = pageComplicatedRandomStuff.captchaValue();
        pageComplicatedRandomStuff.text("Pedro", "berna@gmail.com", "Hola!!!", VALOR);
        Thread.sleep(2000);
        Assert.assertEquals("NO ES EL TEXTO QUE ESPERAMOS", pageComplicatedRandomStuff.successMessage());

    }
}
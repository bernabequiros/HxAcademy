package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageComplicatedSocialMedia {
    private WebDriver driver;

    private By socialMediaElements;

    public PageComplicatedSocialMedia(WebDriver driver) {
        this.driver = driver;

        socialMediaElements = By.xpath("//*[@class='icon et_pb_with_border']");

    }

    public int SocialMediaElements() {

        List<WebElement> list = driver.findElements(socialMediaElements);

        int index = 1;

        for (WebElement e : list) {

            if (e.isEnabled()) {

                System.out.println("Elemento " + index++ + " esta habilitado?: PASSED.");
            } else {
                throw new Error("Elemento " + index++ + " esta habilitado?: FAILED!");
            }

        }

        return list.size();

    }
}

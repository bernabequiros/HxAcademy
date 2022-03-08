package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SectionComplicatedSocialMedia {
    private WebDriver driver;

    private By socialMediaElements;

    public SectionComplicatedSocialMedia(WebDriver driver) {
        this.driver = driver;

        socialMediaElements = By.xpath("//*[@class='icon et_pb_with_border']");

    }

    public int SocialMediaElements() {

        List<WebElement> list = driver.findElements(socialMediaElements);

        int index = 1;

        for (WebElement e : list) {

            if (e.isEnabled()) {

                System.out.println("Element " + index++ + " is enabled?: PASSED.");
            } else {
                throw new Error("Element " + index++ + " is enabled?: FAILED!");
            }

        }

        return list.size();

    }
}

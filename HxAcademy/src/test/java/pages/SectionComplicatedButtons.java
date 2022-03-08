package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SectionComplicatedButtons {

    private WebDriver driver;
    private By sectionButtons;
    private By sectionSocialMedia;
    private By sectionRandomStuff;

    public SectionComplicatedButtons(WebDriver driver) {
        this.driver = driver;

        sectionButtons = By.id("Section_of_Buttons");
        sectionSocialMedia = By.id("Section_of_Social_Media_Follows");
        sectionRandomStuff = By.id("Section_of_Random_Stuff");

    }

    public String buttonsText() {

        return driver.findElement(sectionButtons).getText();

    }

    public String socialMediaText() {

        return driver.findElement(sectionSocialMedia).getText();

    }

    public String randomStuffText() {

        return driver.findElement(sectionRandomStuff).getText();
    }

    public void clickToAllButtons() {
        int buttonNumber = 0;
        while (buttonNumber <= 11) {

            WebElement e = driver.findElement(
                    By.xpath("//*[@class='et_pb_button et_pb_button_" + buttonNumber + " et_pb_bg_layout_light']"));

            if (e.isEnabled()) {
                System.out.println("Button " + buttonNumber + " is enabled?: PASSED.");
            } else {
                throw new Error("Button " + buttonNumber + " is enabled?: FAILED!");
            }
            buttonNumber++;

        }

    }

}

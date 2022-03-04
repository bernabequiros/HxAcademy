package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageComplicatedButtons {
    private WebDriver driver;
    private By sectionButtons;
    private By sectionSocialMedia;
    private By sectionRandomStuff;

    public PageComplicatedButtons(WebDriver driver) {
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

        for (int buttonNumber = 0; buttonNumber <= 11; buttonNumber++) {

            driver.findElement(
                    By.xpath("//*[@class='et_pb_button et_pb_button_" + buttonNumber + " et_pb_bg_layout_light']")).click();
            System.out.println("Click boton:" + buttonNumber);

        }

    }

}

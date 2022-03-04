package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageComplicatedRandomStuff {

    private WebDriver driver;
    private By nameInput;
    private By emailInput;
    private By msgInput;
    private By captcha;
    private By captchaInput;
    private By submitButton;
    private By succesMessageText;

    public PageComplicatedRandomStuff(WebDriver driver) {
        this.driver = driver;

        nameInput = By.id("et_pb_contact_name_0");
        emailInput = By.id("et_pb_contact_email_0");
        msgInput = By.id("et_pb_contact_message_0");
        captcha = By.xpath("//*[@id='et_pb_contact_form_0']/div[2]/form/div/div/p/span");
        captchaInput = By.xpath("//*[@id='et_pb_contact_form_0']/div[2]/form/div/div/p/input");
        submitButton = By.xpath("//*[@id='et_pb_contact_form_0']/div[2]/form/div/button");
        succesMessageText = By.xpath("//*[contains(text(),'Thanks for contacting us')]");

    }

    public void text(String name, String email, String message, String captcha) throws InterruptedException {
        driver.findElement(nameInput).sendKeys(name);
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(msgInput).sendKeys(message);
        driver.findElement(captchaInput).sendKeys(captcha);
        Thread.sleep(1000);
        driver.findElement(submitButton).click();

    }

    public String captchaValue() {
        String captchaString = driver.findElement(captcha).getText().replaceAll("[\\$ .]", "");

        String[] captchaSplit = captchaString.split("\\+");

        int number1 = Integer.parseInt(captchaSplit[0]);
        int number2 = Integer.parseInt(captchaSplit[1]);

        int captchaNumber = number1 + number2;
        String captcha = String.valueOf(captchaNumber);

        return captcha;

    }

    public String successMessage() {

        return driver.findElement(succesMessageText).getText();

    }

}

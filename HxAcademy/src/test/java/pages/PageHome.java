package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageHome {
	private WebDriver driver;
	private By bigPageOption;

	public PageHome(WebDriver driver) {
		this.driver = driver;

		bigPageOption = By.xpath("//a[contains(text(),'Big page with many elements')]");

	}

	public void navigate(String url) {

		driver.get(url);
	}

	public void selectOption() {

		driver.findElement(bigPageOption).click();

	}

	public boolean getTitle() {
		return driver.getTitle().equals("Complicated Page | Ultimate QA");

	}

}

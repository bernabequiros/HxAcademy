package pages;


import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CommonConditions {

	protected WebDriver driver;

	@Before
	public void setUp() {

		// CONFIGURACION PARA USAR MULTIPLES NAVEGADORES:
		String browser_to_use = "Chrome"; // Opciones de navegador: "Chrome", "Firefox", "Edge"

		if (browser_to_use == "Chrome") {
			System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
			driver = new ChromeDriver();

			driver.manage().window().maximize();

		} else if (browser_to_use == "Firefox") {

			System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
			driver = new FirefoxDriver();

			driver.manage().window().maximize();

		} else if (browser_to_use == "Edge") {

			System.setProperty("webdriver.edge.driver", "Drivers/msedgedriver.exe");
			driver = new EdgeDriver();

			driver.manage().window().maximize();

		} else {
			System.out.println("ERROR: The name of the browser driver could not be found.");
		}

		// FIN DE CONFIGURACION NAVEGADOR

	}

	@After
	public void tearDown() {

		driver.quit();

	}

}

package salesforce_stepdefenitions;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Salesforce_ProjectSpecs extends AbstractTestNGCucumberTests {
	public static ChromeDriver driver;
	public static WebDriverWait wait;
	public static int i=1;
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		 ChromeOptions option=new ChromeOptions();
		 option.addArguments("--disable-notifications");
		 driver=new ChromeDriver(option);
		 driver.get("https://login.salesforce.com");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait=new WebDriverWait(driver, Duration.ofSeconds(60));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
}

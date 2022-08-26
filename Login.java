package salesforce_stepdefenitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login extends Salesforce_ProjectSpecs {

	
	@Given ("Type Username as {string}")
	public void enterUsername(String username ) {
		driver.findElement(By.id("username")).sendKeys(username);
	}
	@And ("Type Password as {string}")
	public void enterPassword(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
	}
	@When ("click on Login")
	public void clickLogin()  {
		driver.findElement(By.id("Login")).click();
		
	}
	@Then ("Display salesforce homepage")
	public void verifyHomepage() throws InterruptedException {
		//Thread.sleep(2000);
		WebElement homeEle = driver.findElement(By.xpath("//h1/span[text()='Home']"));
		wait.until(ExpectedConditions.visibilityOf(homeEle));
		String title = driver.getTitle();
		Assert.assertEquals(title, "Home | Salesforce");
		//if(title.contains("Home")) {
		//System.out.println("Logged in successfully");
		//}
	}
	
	@But ("Display error message")
	public void verifyError() {
		String text = driver.findElement(By.id("error")).getText();
		if(text.contains("Please check your username and password")) {
			System.out.println("Login attempt to the application Failed! please check");
		}
	}
}

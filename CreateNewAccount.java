package salesforce_stepdefenitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.And;

public class CreateNewAccount extends Salesforce_ProjectSpecs {
	@And ("click on Accounts tab")
	public void clickAccountsTab() {
		WebElement ele = driver.findElement(By.xpath("//span[text()='Accounts']"));
		driver.executeScript("arguments[0].click();", ele);
	}
	@Given ("click on New")
	public void clickNEw() {
		driver.findElement(By.xpath("//div[@title='New']")).click();	

	}
	@And ("type your name as (.*)$")
	public void enterName(String name) {
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(name);
		
	}
	@And ("select ownership as public")
	public void seelctOwnerShip() {
		driver.findElement(By.xpath("//button[@aria-label='Ownership, --None--']")).click();
		driver.findElement(By.xpath("//span[@title='Public']")).click();
		
	}
	@When ("click on save for account")
	public void clickSave() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		Thread.sleep(700);
		
	}
	@Then ("verify the account cerated successfully with (.*)$")
	public void verifyAccountCreatedSuccessfully(String name) {
		String text = driver.findElement(By.xpath("//lightning-formatted-text[@class='custom-truncate']")).getText();
		SoftAssert accName=new SoftAssert();
		accName.assertEquals(text, name);
	}


}

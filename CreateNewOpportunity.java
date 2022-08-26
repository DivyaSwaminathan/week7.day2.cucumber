package salesforce_stepdefenitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;

public class CreateNewOpportunity extends Salesforce_ProjectSpecs{

	@Given ("click on toggle menu from left corner")
public void clickToggleMenu() {
	driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	
}

	@And("click on view all link")
	public void clickViewAll() {
		driver.findElement(By.xpath("//button[text()='View All']")).click();
	}
	@And ("click sales link from the app launcher")
	public void clickSalesLink() {
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
	}
	@And ("click on opportunities tab")
	public void clickOpportunities() {
		WebElement ele = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		driver.executeScript("arguments[0].click();", ele);
		
		}

	@And ("click on New button")
	public void clickNewbutton() {
		driver.findElement(By.xpath("//div[@title='New']")).click();
	}
	@When ("Type the opportunity name as (.*)$")
	public void enterOpportunityName(String name) {
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(name);
	}
	@And ("select close date as today")
	public void selectDate() {
		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		driver.findElement(By.xpath("//button[text()='Today']")).click();
	}
	@And ("select the stage as need analysis")
	public void selectStage() throws InterruptedException {
		driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();

	}
	@When("click on save for the new opportunity")
	public void saveNewOpportunity() {
		driver.findElement(By.xpath("//button[text()='Save']")).click();
	}
	@Then ("verify opportunity created successfully with (.*)$")
	public void verifyOpportunityCreated(String name) {
		String text = driver.findElement(By.xpath("//lightning-formatted-text[@slot='primaryField']")).getText();
		if (text.contains(name)) {
			System.out.println("New opportunity created successfully : " + name);
		}
		else {
			System.out.println("unable to create new Opportunity");
		}
	}
	
	@But("Verify the error message is genearted")
	public void errorWhenMandatoryFieldsnull() {
		String errMsg = driver.findElement(By.xpath("//h2[text()='We hit a snag.']")).getText();
		if(errMsg.contains("snag")) {
			System.out.println("Please complete the mandatory fields to create the Opportunity");
		}
	}
}

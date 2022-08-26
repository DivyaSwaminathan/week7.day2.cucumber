package salesforce_stepdefenitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateNewIndividual extends Salesforce_ProjectSpecs {
	@And ("click Individuals link from the app launcher")
	public void clickIndividualsfromApplauncher() {
		WebElement ele = driver.findElement(By.xpath("//a[@data-label='Individuals']"));
		driver.executeScript("arguments[0].click();", ele);
	}
	@And ("click dropdown from Individuals tab")
	public void clickNewfromdropDown() {
		driver.findElement(By.xpath("//a[contains(@title,'Individuals')]/following::a[1]")).click();
	}
	@And ("click on New Individual")
	public void clickNewIndividual() {
		WebElement ele1 = driver.findElement(By.xpath("//span[text()='New Individual']"));
		driver.executeScript("arguments[0].click();", ele1);
	}
	@And ("Enter the name as (.*)$")
	public void enterIndividualName(String name){
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(name);
	}
	@When ("click on save")
	public void clickSave() {
		driver.findElement(By.xpath("//button[@title='Save']")).click();

		
	}
	@Then ("Verify the Individual is created successfully")
	public void verifyIndividualCreated() {
		String text = driver.findElement(By.xpath("//span[@class='uiOutputText']")).getText();
		System.out.println("The Individual Name is : " + text);
	}
}

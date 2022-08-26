package salesforce_stepdefenitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CreateNewDashboard extends Salesforce_ProjectSpecs{
	
	@And ("click Dashborad link from the app launcher")
	public void clickDashboardApplauncher() {
		WebElement dashBoard = driver.findElement(By.xpath("//a[@data-label='Dashboards']"));
		driver.executeScript("arguments[0].click();", dashBoard);
	}
	@And ("click New Dashboard option")
	public void clickNewDashboard() {
		driver.findElement(By.xpath("//div[@title='New Dashboard']")).click();
	}
	@When ("Type the name as (.*)$")
	public void typeDashBoardName(String name) throws InterruptedException {
		Thread.sleep(1000);
		driver.switchTo().frame(0);
		driver.findElement(By.id("dashboardNameInput")).sendKeys(name);
	}
	@And ("Click on Create button")
	public void clickCreate() {
		driver.findElement(By.id("submitBtn")).click();
	}
	@And ("Click on Done button")
	public void saveDashboard() throws InterruptedException {
		WebElement frameNew = driver.findElement(By.xpath("//iframe[@title='dashboard']"));
		driver.switchTo().frame(frameNew);
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[text()='Done']")).click();

	}
	@Then ("Verify Dashboard created with name as (.*)$")
	public void verifyDashboardCreatedSuccessfully(String name) {
		String dashBoardName = driver.findElement(By.xpath("//span[@class='slds-page-header__title slds-truncate']")).getText();
		if (dashBoardName.equals(name)){
			System.out.println("Dashboard with name : " + name + " is created successfully");
		}
	}
}

package hooks;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import io.cucumber.java.After;
import salesforce_stepdefenitions.Salesforce_ProjectSpecs;

public class HooksImplementation extends Salesforce_ProjectSpecs{

	@After
	public void screenShot() throws IOException {
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dest=new File("./testSS/testScreenShots"+i+".png");
		FileUtils.copyFile(src, dest);
		i++;
		
	}
	
}

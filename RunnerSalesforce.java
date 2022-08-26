package runner;


import io.cucumber.testng.CucumberOptions;
import salesforce_stepdefenitions.Salesforce_ProjectSpecs;
@CucumberOptions(features="src\\test\\java\\salesforce_features",glue={"salesforce_stepdefenitions","hooks"},publish=true,
monochrome=true)
public class RunnerSalesforce extends Salesforce_ProjectSpecs{

}


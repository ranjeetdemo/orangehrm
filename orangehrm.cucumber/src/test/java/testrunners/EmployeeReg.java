package testrunners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="featurefiles/employee.feature",glue="stepdefination",
dryRun=false,tags=("@employee_reg"),plugin= {"com.cucumber.listener.ExtentCucumberFormatter:reports/empresult.html"})

public class EmployeeReg 
{
	

}

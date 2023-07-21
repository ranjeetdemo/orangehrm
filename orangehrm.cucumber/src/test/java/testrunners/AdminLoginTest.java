package testrunners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(features="featurefiles/adminlogin.feature",glue="stepdefination",
dryRun=false,tags=("@login_valid,@login_invalid"),plugin= {"com.cucumber.listener.ExtentCucumberFormatter:reports/loginresult.html"})
public class AdminLoginTest 
{
	

}
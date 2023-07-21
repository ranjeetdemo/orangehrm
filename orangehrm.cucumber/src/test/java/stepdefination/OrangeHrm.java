package stepdefination;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OrangeHrm
{
	public static WebDriver driver;
	
	@Given("^i open browser with the url \"([^\"]*)\"$")
	public void i_open_browser_with_the_url(String url) 
	{

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get(url);
	}

	@Then("^i should see login page$")
	public void i_should_see_login_page() 
	{
	  if(driver.findElement(By.id("btnLogin")).isDisplayed())
	  {
		  System.out.println("system displayed login page");
	  }
	}

	@When("^i enter username as \"([^\"]*)\"$")
	public void i_enter_username_as(String uname) 
	{
	  driver .findElement(By.id("txtUsername")).sendKeys(uname);
	  
	}

	@When("^i enter password as \"([^\"]*)\"$")
	public void i_enter_password_as(String pword)
	{
	   driver.findElement(By.id("txtPassword")).sendKeys(pword);
	}

	@When("^i click login$")
	public void i_click_login() 
	{
	   driver.findElement(By.id("btnLogin")).click(); 
	}


	
	@Then("^i should see admin module$")
	public void i_should_see_admin_module() 
	{
		 if(driver.findElement(By.linkText("Admin")).isDisplayed())
		 {
			 System.out.println("system displayed admin module");
		 }
	}

	@When("^i click logout$")
	public void i_click_logout() 
	{
		driver.findElement(By.partialLinkText("Welcome")).click();
		driver.findElement(By.linkText("Logout")).click();
	}

	@When("^i close browser$")
	public void i_close_browser() 
	{
	 driver.close();
	}

	@Then("^i should see error message$")
	public void i_should_see_error_message() 
	{
		String errmsg = driver.findElement(By.id("spanMessage")).getText();
		if(errmsg.toLowerCase().contains("invalid") || errmsg.toLowerCase().contains("empty"))
		{
			System.out.println("System displaying exxpected error message for login with invalid data");
		}	
	}


	String empid;

	@When("^i goto new employee registration page$")
	public void i_goto_new_employee_registration_page() 
	{

		driver.findElement(By.linkText("PIM")).click();
		driver.findElement(By.linkText("Add Employee")).click();
		
		
	}

	@When("^i enter firstname as \"([^\"]*)\"$")
	public void i_enter_firstname_as(String fname) 
	{
		driver.findElement(By.id("firstName")).sendKeys(fname);	
	}

	@When("^i enter lastname as \"([^\"]*)\"$")
	public void i_enter_lastname_as(String lname) 
	{
		driver.findElement(By.id("lastName")).sendKeys(lname);
	}

	@When("^click save$")
	public void click_save()
	{

		empid = driver.findElement(By.id("employeeId")).getAttribute("value");
		driver.findElement(By.id("btnSave")).click();
	}
	@Then("^i should see registered employee in employee list$")
	public boolean i_should_see_registered_employee_in_employee_list() 
	{
		driver.findElement(By.linkText("PIM")).click();
		WebElement emptable;
		emptable = driver.findElement(By.id("resultTable"));
		List<WebElement> rows = emptable.findElements(By.tagName("tr"));
		
		boolean isempdisplayed = false;
		
		for(int i=1;i<rows.size();i++)
		{
			List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
			if(cols.get(1).getText().equals(empid))
			{
				isempdisplayed = true;
				break;
			}
		}
		
		return isempdisplayed;	    
	}


}

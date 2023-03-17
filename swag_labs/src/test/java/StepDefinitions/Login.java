package StepDefinitions;


import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;

import pages.LoginPage;

public class Login {
	WebDriver driver = null;
	LoginPage login;
	
	@SuppressWarnings("deprecation")
	@Given("^user is on login page$")
	public void user_is_on_login_page() {
		System.setProperty("webdriver.chrome.driver", "C://automation//chromedriver_win32//chromedriver.exe");
		driver = new ChromeDriver();
//		System.setProperty("webdriver.edge.driver","C:/automation/edgedriver_win64/msedgedriver.exe");
//		driver = new EdgeDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
	    
	}

	@When("^user enters valid (.*) and (.*)$")
	public void user_enters_valid_username_and_password(String username , String password ) {
		login = new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
	    
	}

	@And("^user clicks on login button$")
	public void user_clicks_on_login_button() {
		login.clickLoginButton();
	    
	}

	@Then("^user should be navigated to home page$")
	public void user_should_be_navigated_to_home_page() {
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
		login.clickMenuButton();
		login.clickLogoutButton();
		driver.close();
	}
	
	
	@SuppressWarnings("deprecation")
	@Given("^user is on the login page$")
	public void user_is_on_the_login_page() {
		System.setProperty("webdriver.chrome.driver", "C://automation//chromedriver_win32//chromedriver.exe");
		driver = new ChromeDriver();
		
//		System.setProperty("webdriver.edge.driver","C:/automation/edgedriver_win64/msedgedriver.exe");
//		driver = new EdgeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
	    
	}

	@When("^User enters invalid (.*) and (.*)$")
	public void user_enters_invalid_username_and_password(String username,String password) {
		login = new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
	}

	@And("^user clicks on the login button$")
	public void user_clicks_on_the_login_button() {
		login.clickLoginButton();
	}

	@Then("^user verifies Actual and (.*)$")
	public void user_verifies_Actual_and_ExpectedError(String ExpectedError) {
		login.PrintError();
		login.verifyError(ExpectedError);
		driver.close();
	}
		
}


package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class Login {
	WebDriver driver = null;
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
		System.setProperty("webdriver.chrome.driver", "C://automation//chromedriver_win32//chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
	    
	}

	@When("^user enters valid (.*) and (.*)$")
	public void user_enters_valid_username_and_password(String username , String password ) {
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
	    
	}

	@And("user clicks on login button")
	public void user_clicks_on_login_button() {
		driver.findElement(By.id("login-button")).click();
	    
	}

	@Then("user should be navigated to home page")
	public void user_should_be_navigated_to_home_page() {
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
		driver.findElement(By.id("react-burger-menu-btn")).click();
		  driver.findElement(By.id("logout_sidebar_link")).click();
		  driver.close();
	}
	
	
	@Given("user is on the login page")
	public void user_is_on_the_login_page() {
		System.setProperty("webdriver.chrome.driver", "C://automation//chromedriver_win32//chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
	    
	}

	@When("^User enters invalid (.*) and (.*)$")
	public void user_enters_invalid_username_and_password(String username,String password) {
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
	}

	@And("user clicks on the login button")
	public void user_clicks_on_the_login_button() {
		driver.findElement(By.id("login-button")).click();
	}

	@Then("user should not be able to login")
	public void user_should_not_be_able_to_login() {
		System.out.println(driver.findElement(By.className("error-message-container")).getText());
		driver.close();
	}
		
}


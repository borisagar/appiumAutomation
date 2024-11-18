package appiumDemoTest;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import appiumDemoPages.BaseClass;
import appiumDemoPages.HomePage;
import appiumDemoPages.LoginPage;

public class LoginTest extends BaseClass{
	private LoginPage loginPage;
	private HomePage homepage;

	
	 @BeforeClass
	 public void setUp() throws MalformedURLException {
		 setup(); // Initialize AppiumDriver from BaseClass
	     loginPage = new LoginPage(driver); // Pass the initialized driver to LoginPage
	 }
	 
	 @Test
	 public void demoLogin() {
		loginPage.acceptAlert(); //Click on Ok button to close check update alert
		loginPage.enterCred("test@yopmali.com","Test@123"); //Enter Email and Password
		loginPage.clickLogin(); //Click on login button
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.getHomepageTxt(), "Hello world!"); //Verify Home screen have hello world text
	}
	 
	 @AfterClass
	    public void tearDown() {
	        super.tearDown(); // Quit the driver
	    }

}

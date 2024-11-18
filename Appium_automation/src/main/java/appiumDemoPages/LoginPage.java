package appiumDemoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class LoginPage extends BaseClass {
	private AppiumDriver driver;
	private By EmailField =	By.id("com.sourcey.materialloginexample:id/input_email");
	private By PasswordFiled = By.id("com.sourcey.materialloginexample:id/input_password");
	private By Loginbtn = By.id("com.sourcey.materialloginexample:id/btn_login");
	private By AlertOkbtn = By.id("android:id/button1");

	public LoginPage(AppiumDriver driver) {
		System.out.println("Driver: " + driver);
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize elements using PageFactory
        }	
	 public LoginPage() {
	        // Default constructor
	    }
	
	
	 public void acceptAlert() {
		 driver.findElement(AlertOkbtn).click();
	 }
	 
	 public void enterCred(String email, String password) {
		driver.findElement(EmailField).sendKeys(email);
		driver.findElement(PasswordFiled).sendKeys(password); 
		}
	
	 public void clickLogin() {
		driver.findElement(Loginbtn).click(); 
		}
	 
	 
	
}

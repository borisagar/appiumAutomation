package appiumDemoPages;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;

public class HomePage extends BaseClass {
	
	private By HomeTxt = By.xpath("//android.widget.TextView[@text=\"Hello world!\"]");

	public HomePage(AppiumDriver driver) {
        this.driver = driver;
        }
	
	public String getHomepageTxt() {
		String ActualTxt = driver.findElement(HomeTxt).getText();
		return ActualTxt;
		}
	

}

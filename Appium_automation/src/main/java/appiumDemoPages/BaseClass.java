package appiumDemoPages;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
public class BaseClass {

	public BaseClass() {
		// TODO Auto-generated constructor stub
	}
	public AppiumDriverLocalService service;
	public File appiumJS;
	public AppiumDriver driver;
	
	public void setup() throws MalformedURLException {
		
		appiumJS = new File("C:\\Users\\Bhargav\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");

		// Start the Appium server
		service = AppiumDriverLocalService.buildService(
				new AppiumServiceBuilder().withAppiumJS(appiumJS).withIPAddress("127.0.0.1").usingPort(4723));
		service.start();

		//Session Capabilities 
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("appium:platformName", "Android");
		caps.setCapability("appium:automationName", "UiAutomator2");
		caps.setCapability("appium:platformVersion", "15");
		caps.setCapability("appium:deviceName", "SmallPhoneB");
		caps.setCapability("app", System.getProperty("user.dir")+"/Resources/MaterialLoginExample.apk");
		caps.setCapability("uiautomator2ServerLaunchTimeout", 60000);
		
		//Extra Capabilities 
		//caps.setCapability("MobileCapabilityType.APP_PACKAGE", "com.sourcey.materialloginexample");
        //caps.setCapability("MobileCapabilityType.APP_ACTIVITY", "materialloginexample/com.sourcey.materiallogindemo.LoginActivity");
		//caps.setCapability(MobileCapabilityType.NO_RESET, true); // Prevents reinstalling the app
        //caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 300); // Optional: Extends command timeout
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);	//Define android driver
	
	}
	
	public void tearDown() {
		
		if(null != driver) {
			driver.quit();
			service.stop(); //Stops the Appium server.
		}
	}
	
	

	
}

package tests;

import io.appium.java_client.ios.IOSDriver;

import org.openqa.selenium.remote.DesiredCapabilities;

public class safariIOS {

	public static void main(String[] args) {
		
		// Setting up capabilities for testing ON ios device.
		
		DesiredCapabilities dc = DesiredCapabilities.iphone();
		dc.setCapability("platformName", "iOS");
		dc.setCapability("platformVersion", "8.1");
		dc.setCapability("appiumVersion", "1.5.3");
		dc.setCapability("deviceName", "iPhone Simulator");
		dc.setCapability("browserName", "safari");
		//IOSDriver driver = new IOSDriver(dc);

	}

}

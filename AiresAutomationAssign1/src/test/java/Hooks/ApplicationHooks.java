package Hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import com.utils.ConfigReader;
import com.utils.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	
	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;

	@Before(order =0)
	public void getProperty() {
		configReader=new ConfigReader();
		prop=configReader.init_prop();
	}
	
	@Before(order =1)
	public void launchBrowserWithUrl() {
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver= driverFactory.initializedriver(browserName);
		driver.get(prop.getProperty("url"));
	}
	
	@After(order =0)
	public void quitBrowser() {
		//driver.quit();
	}
	
	@After(order =1)
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
		}
	}
}

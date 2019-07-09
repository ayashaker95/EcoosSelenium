package com.ecoos.selenium.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.ecoos.selenium.commons.PropertyManager;
import com.ecoos.selenium.pages.LoginPage;
import com.ecoos.selenium.pages.BasePage;
import com.ecoos.selenium.commons.Locators;
import com.ecoos.selenium.commons.Constans;

public class BaseTest {
	public static WebDriver driver;
	public String UserName , Password;

	@BeforeSuite
	public void beforeSuite() {

		try {
			
		    String url = PropertyManager.getInstance().getURL();
		    System.out.println(url);
			String chromeDriverPath = PropertyManager.getInstance().getChromedriverPath();
			String geckoDriverPath = PropertyManager.getInstance().getgeckodriverPath();
			String BrowserName = PropertyManager.getInstance().getBrowserName();
			System.out.println(BrowserName);
			if (BrowserName.contains("chrome"))  {
				System.setProperty("webdriver.chrome.driver", chromeDriverPath);
				driver = new ChromeDriver();
			} else if (BrowserName.contentEquals("firefox")) {
				System.setProperty("webdriver.gecko.driver",geckoDriverPath );
				driver = new FirefoxDriver();
			} else {
				System.out.println("Error in the browser name ");
			}
			driver.manage().window().maximize();
			driver.get(url);

		} catch (Exception e) {
			System.out.println("Ex: Base :  " + e.getMessage());

		}
	}

	@BeforeTest
	public void ValidLogin() throws InterruptedException {
		System.out.println("@BeforeTest");
        UserName = PropertyManager.getInstance().getUserName();
        Password = PropertyManager.getInstance().getPassword();
		LoginPage login = new LoginPage(driver);
		login.clearLoginFields();
		login.loginToSite(UserName, Password); 
		BasePage.Wait(com.ecoos.selenium.commons.Locators.collect, 6);
		Assert.assertEquals(login.getCurrentURL(),Constans.Collect);
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("Test is finished");
		// driver.quit();
	}
}

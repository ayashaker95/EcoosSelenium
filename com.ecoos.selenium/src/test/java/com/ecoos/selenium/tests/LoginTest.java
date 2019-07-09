package com.ecoos.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.ecoos.selenium.pages.LoginPage;
import com.ecoos.selenium.commons.Constans;
import com.ecoos.selenium.pages.BasePage;

public class LoginTest extends BaseTest{
	
	
	@Test
	@Parameters({ "UserName", "Password" })
	public void InvalidEmail(String UserName, String Password) {

		LoginPage login = new LoginPage(driver);
		login.clearLoginFields();
		login.loginToSite(UserName, Password);
		String message = login.getElementText(com.ecoos.selenium.commons.Locators.InvalidMessage);
		if (message.contains(com.ecoos.selenium.commons.Constans.LoginErrorMsg))
			Assert.assertTrue(true);
	}

	
	@Test
	@Parameters({ "UserName", "Password" })
	public void InvalidPassword(String UserName, String Password) {

		LoginPage login = new LoginPage(driver);
		login.clearLoginFields();
		login.loginToSite(UserName, Password);
		String message = login.getElementText(com.ecoos.selenium.commons.Locators.InvalidMessage);
		if (message.contains(com.ecoos.selenium.commons.Constans.LoginErrorMsg))
			Assert.assertTrue(true);
	}
	
	@Test
	@Parameters({ "UserName", "Password" })
	public void ValidLogin() {
		LoginPage login = new LoginPage(driver);
		login.clearLoginFields();
		login.loginToSite(UserName, Password);
		BasePage.Wait(com.ecoos.selenium.commons.Locators.collect,6);
		Assert.assertEquals(login.getCurrentURL(), Constans.Collect);
	}

}

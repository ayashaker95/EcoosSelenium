package com.ecoos.selenium.pages;
import org.openqa.selenium.WebDriver;

import com.ecoos.selenium.commons.Locators;


public class LoginPage extends BasePage {


	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void clearLoginFields() {
		driver.findElement(com.ecoos.selenium.commons.Locators.UserName).clear();
		driver.findElement(com.ecoos.selenium.commons.Locators.Password).clear();
	}

	
	public void loginToSite(String UserName, String Password) {

		try {

			sendText(com.ecoos.selenium.commons.Locators.UserName, UserName);
			sendText(com.ecoos.selenium.commons.Locators.Password, Password);
			clickElement(com.ecoos.selenium.commons.Locators.LoginButton);

		} catch (Exception e) {
			System.out.println("Ex: Login :  " + e.getMessage());

		}
	}

}

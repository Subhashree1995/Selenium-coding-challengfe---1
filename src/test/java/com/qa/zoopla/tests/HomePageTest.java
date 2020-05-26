package com.qa.zoopla.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.zoopla.basepage.BasePage;
import com.qa.zoopla.pages.HomePage;

public class HomePageTest {

	WebDriver driver;
	BasePage basepage;
	HomePage homepage;
	Properties prop;

	@BeforeMethod
	public void setUp() {
		basepage = new BasePage();
		prop = basepage.init_properties();
		driver = basepage.init_driver(prop);
		homepage = new HomePage(driver);
	}

	@Test(priority = 1)
	public void acceptCookieTest() {
		homepage.entervalueToField(prop.getProperty("countryname"));

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

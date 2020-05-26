package com.qa.zoopla.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.zoopla.basepage.BasePage;
import com.qa.zoopla.pages.AgentVerifyPage;
import com.qa.zoopla.pages.HomePage;
import com.qa.zoopla.pages.PropertyPricePage;
import com.qa.zoopla.pages.fifthPropertydeatilsPage;

public class fifthPropertydeatilsPageTest {
	WebDriver driver;
	BasePage basepage;
	HomePage homepage;
	Properties prop;
	PropertyPricePage propertypricepage;
	fifthPropertydeatilsPage fifthPropertydetails;

	@BeforeMethod
	public void setUp() {
		basepage = new BasePage();
		prop = basepage.init_properties();
		driver = basepage.init_driver(prop);
		homepage = new HomePage(driver);
		propertypricepage = homepage.entervalueToField(prop.getProperty("countryname"));
		fifthPropertydetails = propertypricepage.selectFifthValue();

	}

	@Test(priority = 1)
	public void verifyLogoTest() {
		String logoText = fifthPropertydetails.verifyLogo();
		System.out.println("The logo of the fifth property is ::" + logoText);
	}

	@Test(priority = 2)
	public void verifyphnNumberTest() {
		String phnNoText = fifthPropertydetails.verifyphnNumber();
		System.out.println("The phone number of the agent  is ::" + phnNoText);
	}

	@Test(priority = 3)
	public void verifyAgentNameTest() {
		fifthPropertydetails.clickONAgent();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

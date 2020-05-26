package com.qa.zoopla.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.zoopla.basepage.BasePage;
import com.qa.zoopla.pages.AgentVerifyPage;
import com.qa.zoopla.pages.HomePage;
import com.qa.zoopla.pages.PropertyPricePage;
import com.qa.zoopla.pages.fifthPropertydeatilsPage;

public class AgentVerifyPageTest {
	WebDriver driver;
	BasePage basepage;
	HomePage homepage;
	Properties prop;
	PropertyPricePage propertypricepage;
	fifthPropertydeatilsPage fifthPropertydetails;
	AgentVerifyPage agentverifyPage;

	@BeforeMethod
	public void setUp() {
		basepage = new BasePage();
		prop = basepage.init_properties();
		driver = basepage.init_driver(prop);
		homepage = new HomePage(driver);
		propertypricepage = homepage.entervalueToField(prop.getProperty("countryname"));
		fifthPropertydetails = propertypricepage.selectFifthValue();
		agentverifyPage=fifthPropertydetails.clickONAgent();

	}
	@Test(priority=1)
	public void verifyAddressTest() {
		String finalAddress=agentverifyPage.verifyAddress();
		System.out.println("The address of this page is ::"+finalAddress);
		Assert.assertEquals(fifthPropertydetails.agentName, agentverifyPage.verifyAddress());
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

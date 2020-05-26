package com.qa.zoopla.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.zoopla.basepage.BasePage;
import com.qa.zoopla.pages.HomePage;
import com.qa.zoopla.pages.PropertyPricePage;

public class PropertyPricePageTest {
	WebDriver driver;
	BasePage basepage;
	HomePage homepage;
	Properties prop;
	PropertyPricePage propertypricepage;

	@BeforeMethod
	public void setUp() {
		basepage = new BasePage();
		prop = basepage.init_properties();
		driver = basepage.init_driver(prop);
		homepage = new HomePage(driver);
		propertypricepage = homepage.entervalueToField(prop.getProperty("countryname"));
	}

	@Test(priority = 1)
	public void sortedPriceInDescOrderTest() {
		propertypricepage.priceProteryinDescending();
	}

	@Test(priority = 2)
	public void fifthvalueTest() {
		propertypricepage.selectFifthValue();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

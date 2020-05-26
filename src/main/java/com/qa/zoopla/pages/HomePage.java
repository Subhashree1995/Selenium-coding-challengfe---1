package com.qa.zoopla.pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.qa.zoopla.basepage.BasePage;
import com.qa.zoopla.util.CONSTANTS;
import com.qa.zoopla.util.ElementsActions;

public class HomePage extends BasePage {

	WebDriver driver;
	ElementsActions elementsactions;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementsactions = new ElementsActions(driver);
	}

	By searchField = By.xpath("//input[@id='search-input-location']");
	By searchBtn = By.xpath("//button[@id='search-submit']");
	By acceptCookies = By.xpath("//button[@class='ui-button-primary ui-cookie-accept-all-medium-large']");

	/**
	 * This function will help to search location for property.
	 * 
	 * @param countryName
	 * @return PropertyPricePage
	 */

	public PropertyPricePage entervalueToField(String countryName) {
		elementsactions.doClickByAction(acceptCookies);
		elementsactions.doSendkeys(searchField, countryName);
		elementsactions.doClick(searchBtn);
		return new PropertyPricePage(driver);
	}

}

package com.qa.zoopla.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qa.zoopla.basepage.BasePage;
import com.qa.zoopla.util.ElementsActions;

public class PropertyPricePage extends BasePage {
	WebDriver driver;
	ElementsActions elementsactions;
	

	public PropertyPricePage(WebDriver driver) {
		this.driver = driver;
		elementsactions = new ElementsActions(driver);
	}

	By proteryList = By.xpath(
			"//div[@class='listing-results-right clearfix']//div//following::a[@class='listing-results-price text-price']");
	

	/**
	 * This function is used to get prices on decending order.
	 */
	public void priceProteryinDescending() {
		ArrayList<String> prices = new ArrayList<String>();
		List<WebElement>priceList = elementsactions.getElements(proteryList);

		for (int i = 0; i < priceList.size(); i++) {
			prices.add(priceList.get(i).getText());
		}
		Collections.reverse(prices);
		System.out.println("prices are in desc order");
		System.out.println(prices.size());
		for (int i = 0; i < prices.size(); i++) {
			System.out.println(prices.get(i) + " ");
		}

	}
	/**
	 * This function is used to select fifth price from the list of prices.
	 * @return AgentVerificarionPage
	 */

	public fifthPropertydeatilsPage selectFifthValue() {
		List<WebElement>priceList = elementsactions.getElements(proteryList);
		Actions action=new Actions(driver);
		action.moveToElement(priceList.get(4)).build().perform();
		priceList.get(4).click();
		return new fifthPropertydeatilsPage(driver);
	}

}
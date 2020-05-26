package com.qa.zoopla.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.zoopla.basepage.BasePage;
import com.qa.zoopla.util.ElementsActions;

public class AgentVerifyPage extends BasePage {
	WebDriver driver;
	ElementsActions elementsactions;

	public AgentVerifyPage(WebDriver driver) {
		this.driver = driver;
		elementsactions = new ElementsActions(driver);
	}
	By finalAddress=By.xpath("(//div[@id='content']//div//h1//b)[1]");
	
	/**
	 * This method is used to get address text of a particular agent.
	 * @return
	 */
	public String verifyAddress() {
		return elementsactions.doGetText(finalAddress);
	}

}

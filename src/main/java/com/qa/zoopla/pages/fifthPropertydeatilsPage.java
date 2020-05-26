package com.qa.zoopla.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.zoopla.basepage.BasePage;
import com.qa.zoopla.util.ElementsActions;

public class fifthPropertydeatilsPage extends BasePage {

	WebDriver driver;
	ElementsActions elementsactions;
	

	public fifthPropertydeatilsPage(WebDriver driver) {
		this.driver = driver;
		elementsactions = new ElementsActions(driver);
	}

	By logo = By.xpath("//div[@class='ui-agent__logo']//img[@class='js-lazy-loaded']");
	By nameOfAgent = By.xpath(
			"//div[@class='dp-sidebar-wrapper__contact']//div[@class='ui-agent__text']/h4[@class='ui-agent__name']");
	By phnNumber = By.xpath("//div[@class='ui-agent__text']//following::a[@data-track-label='Agent phone number 1']");
	
	public String agentName=null;
	

	/*
	 * Below methods are for to get agentname,phone number and logo.
	 */
	public String verifyLogo() {
		return elementsactions.getElement(logo).getAttribute("alt");
	}
	public String verifyphnNumber() {
		return elementsactions.doGetText(phnNumber).toString();
	}
	public AgentVerifyPage clickONAgent() {
		agentName=elementsactions.doGetText(nameOfAgent);
		elementsactions.doClick(nameOfAgent);
		return new AgentVerifyPage(driver);
	}

}

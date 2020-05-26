package com.qa.zoopla.util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementsActions {
	
	WebDriver driver;
	
	public ElementsActions(WebDriver driver) {
		this.driver=driver;
	}
	public WebElement getElement(By locator) {
		webDriverWait(locator);
		WebElement element=null;
		try {
			element=driver.findElement(locator);
		}catch(Exception e) {
			System.out.println("Exception is coming while getting an element"+locator);
		}
		return element;
	}
	public List<WebElement> getElements(By locator) {
		webDriverWait(locator);
		List<WebElement> elements=null;
		try {
			elements=driver.findElements(locator);
		}catch(Exception e) {
			System.out.println("Exception is coming while getting list of webelement"+locator);
		}
		return elements;
	}
	public void webDriverWait(By locator) {
		WebDriverWait wait=new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	public String waitForTheTitle(String title) {
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
	}
	public void doClick(By locator) {
		try {
			getElement(locator).click();
		}catch(Exception e) {
			System.out.println("Exception occurs while clicking on the element"+locator);
		}
	}
	public void doSendkeys(By locator, String value) {
		try {
			getElement(locator).sendKeys(value);
		} catch (Exception e) {
			System.out.println("The exception is coming while sending  the element"+locator);
		}
	}

	public String doGetText(By locator) {
		String text=null;
		try {
			text=getElement(locator).getText();
		}catch(Exception e) {
			System.out.println("Exception occurs while getting text from the element"+locator);
		}
		return text;
	}
	public boolean isElementDisplay(By locator) {
		try {
			getElement(locator).isDisplayed();
		} catch (Exception e) {
			System.out.println("The exception is coming while dispalying the element"+locator);
		}
		return true;
	}

	public void swicchToAlert(By locator) {
		driver.switchTo().alert();
		doClick(locator);
		
	}
	public void doClickByAction(By locator) {
		Actions action =new Actions(driver);
		action.click(getElement(locator)).build().perform();
	}
	

}

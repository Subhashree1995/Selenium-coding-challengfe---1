package com.qa.zoopla.basepage;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author Subhashree Mohapatra
 *
 */

public class BasePage {

	WebDriver driver;
	Properties prop;

	/**
	 * This method is used to return driver on the basis of browser.
	 * 
	 * @param prop
	 * @return driver
	 */

	public WebDriver init_driver(Properties prop) {
		String browser = prop.getProperty("browser");
		String url = prop.getProperty("url");
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			System.out.println("Please enter the correct browser");
			
		}
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();				
		driver.get(url);
		return driver;

	}

	/**
	 * This method is used to get the properties from config prop file.
	 * 
	 * @return properties
	 */

	public Properties init_properties() {
		prop=new Properties();
		try {
			FileInputStream ip=new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\SeleniumCodingAssignment\\"
					+ "src\\main\\java\\com\\qa\\zoopla\\config\\config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return prop;
	}

}

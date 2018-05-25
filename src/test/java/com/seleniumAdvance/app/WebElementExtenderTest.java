package com.seleniumAdvance.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.seleniumAdvance.app.*;

public class WebElementExtenderTest extends WebElementExtender {

	WebDriver odriver;
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:\\Testing Tools and Jars\\Work\\chromedriver.exe");
		odriver= new ChromeDriver();
		odriver.get("http://www.google.com");
	}
	
	@Test
	public void searchGoogleTest() {
		//WebElementExtenderTest obj = new WebElementExtenderTest();
		WebElement element = odriver.findElement(By.id("lst-ib"));
		WebElementExtender.highlightElement(element);
		element.sendKeys("Rahul Mendiratta");
	}
	
	@AfterClass
	public void tearDown() {
		odriver.close();
		odriver=null;
	}
	
}

package com.seleniumAdvance.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ObjectMapTest {

	WebDriver odriver;
	private ObjectMap object;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:\\Testing Tools and Jars\\Work\\chromedriver.exe");
		odriver= new ChromeDriver();
		odriver.get("http://cookbook.seleniumacademy.com/bmicalculator.html");
	}

	@Test
	public void ObjectMapTest1() throws Exception
	{
		object = new ObjectMap("C:\\Users\\Rahul Mendiratta\\my-seleniumAdvance\\src\\main\\java\\resources\\PageObject.Properties");
		WebElement height = odriver.findElement(object.getLocator("heightField"));
		height.sendKeys("23.56");
		WebElement weight = odriver.findElement(object.getLocator("weightField"));
		weight.sendKeys("11.26");
		WebElement calculate = odriver.findElement(object.getLocator("calculatteButton"));
		calculate.click();
		WebElement resultBMI = odriver.findElement(object.getLocator("BMIField"));
		System.out.println(resultBMI.getText());
	}


	@AfterClass
	public void tearDown() {
		odriver.close();
	}
}

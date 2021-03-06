package com.seleniumAdvance.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebTableTest {
	
	WebDriver odriver;
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:\\Testing Tools and Jars\\Work\\chromedriver.exe");
		odriver= new ChromeDriver();
		odriver.get("http://cookbook.seleniumacademy.com/Locators.html");
	}
	
	@Test
	public void WebTableTest1() {
		WebTable obj = new WebTable(odriver.findElement(By.cssSelector("div.cart-info table")));
		//Check RowCount
		Assert.assertEquals(3, obj.getRowCount());
		//CheckCellCount
		Assert.assertEquals(5, obj.getCellCount());
		//GetParticular Cell Value
		System.out.println(obj.getCellValueMethod(2, 3));
		//SetParticular editor value
		obj.GetCellEditor(2, 3, 0).sendKeys("10");
	}
	
	@Test
	public void WebTableTest2() {
		WebTable obj = new WebTable(odriver.findElement(By.cssSelector("div.cart-info table")));
		
		for(int row =1;row<=obj.getRowCount();row++) {
			for(int cell=1;cell<=obj.getCellCount();cell++) {
				System.out.print(obj.getCellValueMethod(row, cell)+ " ");
			}
			System.out.print("\n");
		}
	}

	
	@AfterClass
	public void tearDown() {
		odriver.close();
	}
}

package com.seleniumAdvance.app;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.WrapsDriver;


//Important point :- WebElement can not be casted to the JavaScriptExecutor for that we have to take help 
//of WrapsDriver Interface

public class WebElementExtender {

	public static  void highlightElement(WebElement element) {
		for(int i=0;i<5;i++) {
			WrapsDriver wrapperElement = (WrapsDriver) element;
			JavascriptExecutor driver = (JavascriptExecutor)wrapperElement.getWrappedDriver();
			//JavascriptExecutor driver = (JavascriptExecutor)element; //Not Possible see line 8-9
			driver.executeScript("arguments[0].setAttribute('style',arguments[1]);",
					element,"color: green;border: 2px solid yellow;");
			driver.executeScript("arguments[0].setAttribute('style',arguments[1]);",
					element,"");
		}
		}
		
		
	}


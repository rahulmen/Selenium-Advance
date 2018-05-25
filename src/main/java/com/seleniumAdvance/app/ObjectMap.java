package com.seleniumAdvance.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

public class ObjectMap {
	Properties property;
	FileInputStream file;
	//Method to load the property File defined by us
	public ObjectMap(String mapFile) {
		property = new Properties();
		try {
			 file = new FileInputStream(mapFile);
			//System.out.println(file);
			property.load(file);
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}

	//Method that will read the property file and return the locator using By Class

	public By getLocator(String LogicalElementName) throws Exception {

		String locator = property.getProperty(LogicalElementName);
		//Split it into logicalType and Logicalvalue

		String logicalName = locator.split(">")[0];
		String logicalValue = locator.split(">")[1];

		if(logicalName.toLowerCase().equals("name")) {
			return By.name(logicalValue);
		}
		else if(logicalName.toLowerCase().equals("id")) {
			return By.id(logicalValue);
		}
		else if((logicalName.toLowerCase().equals("class"))||(logicalName.toLowerCase().equals("className"))){
			return By.className(logicalValue);
		}
		else if (logicalName.toLowerCase().equals("xpath")) {
			return By.xpath(logicalValue);
		}
			else{
				throw new Exception("LocatorType"+logicalName+"Dooes not exist");
		}
	}


}

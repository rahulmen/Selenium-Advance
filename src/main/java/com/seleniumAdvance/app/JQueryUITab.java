package com.seleniumAdvance.app;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class JQueryUITab {
	
	private WebElement _jQueryTab;
	
	public JQueryUITab(WebElement _jQueryTab) {
		setJQuery(_jQueryTab);
	}

	public WebElement getJQuery() {
		return _jQueryTab;
	}
	
	public void setJQuery(WebElement _jQueryTab) {
		this._jQueryTab=_jQueryTab;
	}
	
	public int getTabCount() {
		List<WebElement> tabCnt = _jQueryTab.findElements(By.cssSelector("wdw"));
				return tabCnt.size();
	}
	
	
	
	
	
	
	
}

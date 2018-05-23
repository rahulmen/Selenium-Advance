package com.seleniumAdvance.app;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebTable {

	private WebElement _webTable;
	
	public WebTable(WebElement _webTable) {
		setWebTable(_webTable);
	}
	//------------------------------------------
	public WebElement getWebTable() {
		return _webTable;
	}
	//-------------------------------------------
	public void setWebTable(WebElement _webTable ) {
		this._webTable=_webTable;
	}
	//--------------------------------
	//Return Row Count
	public int getRowCount() {
		List<WebElement> rowsCnt = _webTable.findElements(By.tagName("tr"));
		return rowsCnt.size();
	}
	//----------------------------
	//Return Cell Count
	public int getCellCount() {
		List<WebElement> rowsCnt = _webTable.findElements(By.tagName("tr"));
		WebElement particularRow = rowsCnt.get(0);
		List<WebElement> cellCnt = particularRow.findElements(By.tagName("td"));
		return cellCnt.size();
	}
	
	//get particular cell value
	
	public String getCellValueMethod(int rowIdx,int cellIdx) {
		List<WebElement> rowsCnt = _webTable.findElements(By.tagName("tr"));
		WebElement particularRow = rowsCnt.get(rowIdx-1);
		List<WebElement> cellCnt = particularRow.findElements(By.tagName("td"));
		WebElement particularCell = cellCnt.get(cellIdx-1);
		return particularCell.getText();
	}
	
	//Get Particular Test Area With in Cell Value
	public WebElement GetCellEditor(int rowIdx,int cellIdx,int editorItx) {
		try {
		List<WebElement> rowsCnt = _webTable.findElements(By.tagName("tr"));
		WebElement particularRow = rowsCnt.get(rowIdx-1);
		List<WebElement> cellCnt = particularRow.findElements(By.tagName("td"));
		WebElement particularCell = cellCnt.get(cellIdx-1);
		WebElement particulatCellEditor=particularCell.findElements(By.tagName("input")).get(editorItx);
		return particulatCellEditor;
		}catch(NoSuchElementException e) {
			throw new NoSuchElementException("Element is not present");
		}
	}
	
}

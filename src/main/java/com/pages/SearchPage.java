package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utils.ElementUtils;
import com.utils.TimeUtil;

public class SearchPage {
	
	ElementUtils util;
	
	private By searchTxtField = By.xpath("//input[@type='text' and @name='search']");
	private By searchIcon = By.cssSelector("button.btn.btn-default.btn-lg");
	private By searchResultList = By.xpath("//div[contains(@class,'product-layout')]//h4");
	private By searchBtn = By.id("button-search");
	
	public SearchPage(WebDriver driver) {
		
		util = new ElementUtils(driver);
		
	}
	
	public void enterProduct(String product) {
		util.waitForElementPresence(searchIcon, TimeUtil.DEFAULT_TIME_OUT);
		util.getElement(searchTxtField).sendKeys(product);
	}
	
	
	public void clickOnSearchIcon() {
		util.getElement(searchIcon).click();
	}
	
	
	public List<String>  getSearchResultsList() {
		util.waitForElementPresence(searchBtn, TimeUtil.DEFAULT_TIME_OUT);
		return util.getElementsTextList(searchResultList);
	}
	
	
	
	

}

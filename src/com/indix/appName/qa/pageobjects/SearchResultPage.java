package com.indix.appName.qa.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.indix.appName.qa.utilities.MySelenium;

public class SearchResultPage {

	@FindBy(how = How.XPATH, using="//*[@id='result_1']/div/div/div/div[1]/div/div/a/img")
	WebElement firstProduct;
	
	MySelenium selenium;	
	public SearchResultPage(MySelenium pSelenium) {
		this.selenium = pSelenium;
		PageFactory.initElements(selenium.getDriver(), this);
	}
	
	public ProductDetailsPage chooseFirstProduct(){
		firstProduct = selenium.wait(firstProduct);
		selenium.click(firstProduct);
		return new ProductDetailsPage(selenium);
	}
	
}

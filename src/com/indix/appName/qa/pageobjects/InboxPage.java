package com.indix.appName.qa.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.indix.appName.qa.utilities.MySelenium;

public class InboxPage {

	
	@FindBy(how = How.XPATH, using = "//*[@id=':ba']/div/div[1]/span/a")
	WebElement inbox;
	
	MySelenium selenium;
	
	public InboxPage(MySelenium pSelenium) {
		this.selenium = pSelenium;
		PageFactory.initElements(selenium.getDriver(), selenium);
	}
		
	public void findEmail(){
		List<WebElement> elements = selenium.getElements("div[id^=\":\"");
		System.out.println(elements.get(0).getText());
	}
}

package com.indix.appName.qa.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.indix.appName.qa.utilities.MySelenium;

public class ShareEmailPage {

	@FindBy(how = How.XPATH, using = "//*[@id='ac_placeholder']")
	WebElement emailid;
	
	@FindBy(how = How.CSS , using= "input[type=submit]")
	WebElement submitButton;
	
	MySelenium selenium;	
	
	public ShareEmailPage(MySelenium pSelenium) {
		this.selenium = pSelenium;
		PageFactory.initElements(selenium.getDriver(), this);
	}
	
	public void typeEmailAddress(String emailAddress){
		//selenium.moveToCurrentWindow();
		selenium.moveTo(selenium.wait(emailid));
		selenium.type(selenium.wait(emailid),emailAddress);
	}
	
	public void submit(){
		selenium.submit(selenium.wait(submitButton));
		//return new SearchResultPage(selenium);

	}
	
}

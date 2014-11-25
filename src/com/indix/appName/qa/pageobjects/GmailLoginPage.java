package com.indix.appName.qa.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.indix.appName.qa.utilities.MySelenium;

public class GmailLoginPage {
	
	WebElement Email;
	WebElement Passwd;
	
	WebElement signIn;
	MySelenium selenium;
	
	public GmailLoginPage(MySelenium pSelenium) {
		this.selenium = pSelenium;
		PageFactory.initElements(selenium.getDriver(), this);
	}
	
	public void typeUserName(String username){
		selenium.typeUserName(Email, username);
	}
	
	public void typePassword(String password){
		selenium.typePassword(Passwd, password);
	}
	
	public InboxPage submit(){
		selenium.submit(signIn);
		return new InboxPage(selenium);
	}
	public void launchEmail(String url) {
		selenium.open(url);
		
		
	}
}

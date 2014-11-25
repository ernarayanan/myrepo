package com.indix.appName.qa.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.indix.appName.qa.utilities.MySelenium;

public class SignInPage {

	@FindBy(how = How.NAME, using ="email")
	WebElement email;
	
	@FindBy(how = How.NAME, using ="password")
	WebElement password;
	MySelenium selenium;
	
	@FindBy(how = How.CSS , using="input[type=submit]")
	WebElement submitButton;
	
	
	public SignInPage(MySelenium pSelenium){
		this.selenium = pSelenium;
		PageFactory.initElements(selenium.getDriver(), this);
	}
	
	public void typeUserName(String emailAddress){
		selenium.type(selenium.wait(email), emailAddress);
	}
	
	public void typePassword(String p_password){
		selenium.type(selenium.wait(password),p_password);
	}
	
	public AmazonHomePage signIn(){
		selenium.click(submitButton);
		return new AmazonHomePage(selenium);
	}
}

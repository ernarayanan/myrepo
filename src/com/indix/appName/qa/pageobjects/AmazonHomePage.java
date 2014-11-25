package com.indix.appName.qa.pageobjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.indix.appName.qa.utilities.MySelenium;

public class AmazonHomePage {

	WebElement twotabsearchtextbox;
	
	@FindBy(how = How.XPATH, using="//*[@id='nav-link-yourAccount']")
	WebElement signIn;

	@FindBy(how = How.CSS , using= "input[type=submit]")
	WebElement submitButton;
	@FindBy(how = How.XPATH, using="//*[@id='nav-your-account']")
	WebElement toolTip;
	
	@FindBy(how = How.XPATH, using="//*[@id='nav-flyout-ya-signin']/a/span")
	WebElement signInButton;
	
	
	MySelenium selenium;	

	public  AmazonHomePage(MySelenium pSelenium) {
		this.selenium = pSelenium;
		PageFactory.initElements(selenium.getDriver(), this);
	}

	public void launchHomePage() {
		selenium.open("https://www.amazon.com");	
	}	
	
	public void typeProductName(String textToSearch){
		selenium.type(twotabsearchtextbox, textToSearch);
	}
	
	
	public SignInPage signIn(){
		launchHomePage();
		try{
		selenium.wait(signIn);
		selenium.click(signIn);
		}catch(NoSuchElementException nse){
			selenium.hover(signIn);
			selenium.click(signInButton);
		}
		return new SignInPage(selenium);
		
	}
	
	
	public SearchResultPage submit(){
		selenium.submit(selenium.wait(submitButton));
		return new SearchResultPage(selenium);

	}
}

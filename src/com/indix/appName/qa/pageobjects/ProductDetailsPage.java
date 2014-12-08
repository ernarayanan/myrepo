package com.indix.appName.qa.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.indix.appName.qa.utilities.MySelenium;

public class ProductDetailsPage {

	@FindBy(how = How.XPATH, using="//*[@id='swfImage']/i")
	WebElement shareByEmail;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ac_container']")
	WebElement emailid;
	
	@FindBy(how = How.XPATH , using= "//*[@id='swfSubmitButton-announce']")
	WebElement submitButton;
	

	@FindBy(how = How.XPATH, using ="//*[@id='nav-link-yourAccount']")
	WebElement myAccount;
	
	@FindBy(how = How.XPATH, using ="//*[@id='nav-item-signout']")
	WebElement signOut;
	
	@FindBy(how = How.XPATH, using="//*[@id='prodDetails']/div[2]/div[2]/div[1]/div[2]/div/div/table/tbody/tr[1]/td[2]")
	WebElement asin;
	
	MySelenium selenium;	
	public ProductDetailsPage(MySelenium pSelenium) {
		this.selenium = pSelenium;
		PageFactory.initElements(selenium.getDriver(), this);
	}
	
	public void  shareByEmail(){
		selenium.click(selenium.wait(shareByEmail));
		//return new ShareEmailPage(selenium);
	}

	public void typeEmailAddress(String emailAddress){
		selenium.moveTo(selenium.wait(emailid));
		selenium.type(emailid,emailAddress);
	}
	
	public void submit(){
		selenium.moveTo(selenium.wait(submitButton));
		selenium.click(selenium.wait(submitButton));

	}
	
	public void signOut(){
		selenium.hover(selenium.wait(myAccount));
		selenium.click(selenium.wait(signOut));
	}

	public void close() {
		selenium.close();		
	}
	
	public String getASIN(){
		return selenium.getText(asin.getText());
	}
}

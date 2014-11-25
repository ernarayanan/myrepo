package com.indix.appName.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.indix.appName.qa.pageobjects.AmazonHomePage;
import com.indix.appName.qa.pageobjects.ProductDetailsPage;
import com.indix.appName.qa.pageobjects.SearchResultPage;
import com.indix.appName.qa.pageobjects.SignInPage;
import com.indix.appName.qa.utilities.EmailReader;
import com.indix.appName.qa.utilities.MySelenium;

public class ShareProductsTest {

	@Test
	@Parameters({"amazonUserName","amazonPassword","gmailUserName","gmailPassword","textToVerify"})
	public void shareAProduct(String amazonUserName, String amazonPassword, String gmailUserName, String gmailPassword, String textToVerify) {

		String textToCheck = "Bose-SoundLink-Mini-Bluetooth-Speaker";
		String browser = "chrome"; 
		MySelenium selenium = new MySelenium(browser);
		
		//Search Product and Share
		AmazonHomePage homepage = new AmazonHomePage(selenium);
		homepage.launchHomePage();
		SignInPage loginPage = homepage.signIn();
		loginPage.typeUserName(amazonUserName);
		loginPage.typePassword(amazonPassword);
		AmazonHomePage myHomePage = loginPage.signIn();
		myHomePage.typeProductName("bose");
		SearchResultPage resultPage = myHomePage.submit();
		ProductDetailsPage productPage = resultPage.chooseFirstProduct();
		productPage.shareByEmail();
		productPage.typeEmailAddress(gmailUserName);
		productPage.submit();
		
		selenium.close();
		
		//Fetch the Email and verify the text
		String actualText = verifyEmail(gmailUserName, gmailPassword, textToCheck);
		Assert.assertTrue(actualText.contains(textToCheck.toLowerCase()));
		
	}

	/* This method reads the subject and returns the link using which we can see the product in the browser */
	private String verifyEmail(String username, String password, String textTocheck) {
		EmailReader reader = new EmailReader();
		String actualText = reader.readMailAndFetchText(username, password, textTocheck);
		return actualText;
	}
	
}

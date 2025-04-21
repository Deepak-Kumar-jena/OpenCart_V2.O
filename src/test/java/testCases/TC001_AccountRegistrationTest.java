package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass  {
	
	
	@Test(groups = { "Regression", "Master" })
	public void verify_account_registartion() {
		
		logger.info("******** Starting the TC001_AccountRegistrationTest **********");
		
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on My account....");
	
		hp.clickRegister();
		logger.info("Clicked on the Register....");
		
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		
		logger.info("Providing the user's info....");
		regpage.setFirstName (randomeString().toUpperCase()); 
		regpage.setLastName (randomeString().toUpperCase()); 
		regpage.setEmail(randomeString()+"@gmail.com"); // randomly generated the email id 
		regpage.setTelephone (randomeNumber()); 
		
		String password=randomAlphaNumeric(); 
		
		regpage.setPassword(password); 
		regpage.setConfirmPassword (password); 
		regpage.setPrivacyPolicy(); 
		regpage.clickContinue();
		
		logger.info("Validating the success message 😊");
		String conFmsg = regpage.getConfirmationMsg();
		String expectedMsg = "Your Account Has Been Created!";

	    logger.info("Validating the success message 😊");
		Assert.assertEquals(conFmsg, expectedMsg);

		} catch (Throwable e) {
		    logger.error("Test Failed - Expected: [Your Account Has Been Created!]" , e);
		    logger.debug("Debug info or page source if needed...");
		    Assert.fail(e.getMessage());
		}
		
		logger.info("******** Finished the TC001_AccountRegistrationTest **********");
		logger.info(" ");
		logger.info(" ");
		
	}
	

}

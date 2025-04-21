package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = "DataDriven") // "dataProviderClass=DataProviders.class"
	// --> Explicitly importing this
	// DataProviders class into this coz
	// it's not declared here in this class,
	// it's an another class.
	public void verifyLoginDDT(String eamil, String pwd, String exp) {
		logger.info("************** Starting TC003_LoginDDT *****************");

		try {
			// HomePage
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("*********Clicked MyAccount***************");
			hp.clickLogin();
			logger.info("*********Clicked LoginBTN***************");

			// Login
			LoginPage lp = new LoginPage(driver);
			logger.info("*********Created the LP Object***************");
			lp.setEmail(eamil);
			logger.info("*********Enter The email***************");
			lp.setPassword(pwd);
			logger.info("*********Enter The email_Password***************");
			lp.clickLogin();
			logger.info("*********Looged In***************");

			// MyAccount
			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetPage = macc.isMyAccountPageExists();

			/*
			 * Data is valid --> Login Success -- Test Pass -- Logout Login Failed -- Test
			 * Failed
			 * 
			 * Data is invalid --> Login Success -- Test Failed -- Logout Login Failed --
			 * Test Pass
			 */

			if (exp.equalsIgnoreCase("valid")) {
				if (targetPage == true) {
					macc.clickLogout();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			} else {
				if (targetPage == true) {
					macc.clickLogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}
		} catch (Exception e) {
			Assert.fail();
		}

		logger.info("************** Finished TC003_LoginDDT *****************");
	}

}

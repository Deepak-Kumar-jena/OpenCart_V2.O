package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

	@Test(groups = { "Sanity", "Master" })
	public void verifyLogin() throws InterruptedException {
		logger.info("*********Starting the TC002 Login Test***************");

		try {
			// HomePage
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("*********Clicked MyAccount***************");
			hp.clickLogin();
			logger.info("*********Clicked LoginBTN***************");

			// Login
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(p.getProperty("email").trim());
			lp.setPassword(p.getProperty("password").trim());
			lp.clickLogin();

			// MyAccount
			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetPage = macc.isMyAccountPageExists();

			Assert.assertTrue(targetPage);
		} catch (Exception e) {
			System.out.print(e);
			Assert.fail();
		}

		logger.info("*********Finshed the TC002 Login Test***************");

	}

}

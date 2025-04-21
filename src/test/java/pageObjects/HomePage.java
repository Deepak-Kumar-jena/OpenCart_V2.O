package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[normalize-space()= 'My Account']")
	WebElement lInkMyaccount;
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement lInkRegister;
	@FindBy(linkText = "Login")
	WebElement linkLogin;

	public void clickMyAccount() {
		lInkMyaccount.click();
	}

	public void clickRegister() {
		lInkRegister.click();
	}

	public void clickLogin() {
		linkLogin.click();
	}

}

package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;

	public HomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	private WebElement adminclick;
	@FindBy(xpath = "//a[@class='dropdown-item']//following::i[@class='ace-icon fa fa-power-off']")
	private WebElement logoutclick;
	@FindBy(xpath = "//form[@id='login-form']")
	private WebElement ishomepagedisplayed;

	public void adminClick() {
		adminclick.click();
	}

	public void logoutClick() {

		logoutclick.click();
	}

	public boolean isHomePageDisplayed() {

		Boolean value = ishomepagedisplayed.isDisplayed();
		return value;
	}

}

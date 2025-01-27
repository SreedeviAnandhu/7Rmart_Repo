package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooterTextPage {
	
	WebDriver driver;

	public ManageFooterTextPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "//tbody//tr[1]//td[4]//a[1]")
	private WebElement actionclick;
	@FindBy(xpath = "//textarea[@id='content']")
	private WebElement addressclick;
	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailclick;
	@FindBy(xpath = "//input[@id='phone']")
	private WebElement phoneclick;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement updateclick;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement isalertdisplayed;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement isupdatebuttondisplayed;


	public ManageFooterTextPage actionClick() {
		actionclick.click();
		return this;
	}

	public ManageFooterTextPage addressClick(String addressvalue) {

		addressclick.sendKeys(addressvalue);
		return this;
	}

	public ManageFooterTextPage emailClick(String emailvalue) {

		emailclick.sendKeys(emailvalue);
		return this;
	}

	public ManageFooterTextPage phoneClick(String phonevalue) {

		phoneclick.sendKeys(phonevalue);
		return this;
	}

	public ManageFooterTextPage updateClick() {

		updateclick.click();
		return this;
	}

	public boolean isAlertDisplayed() {
		Boolean value = isalertdisplayed.isDisplayed();
		return value;
	}

	public boolean isUpdateButtonDisplayed() {

		Boolean value = isupdatebuttondisplayed.isDisplayed();
		return value;
	}

}

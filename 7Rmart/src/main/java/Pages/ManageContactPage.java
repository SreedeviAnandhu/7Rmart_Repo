package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageContactPage {
	
	WebDriver driver;

	public ManageContactPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "//i[@class='fas fa-edit']")
	private WebElement actionclick;
	@FindBy(xpath = "//input[@id='phone']")
	private WebElement phoneclick;
	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailclick;
	@FindBy(xpath = "//textarea[@placeholder='Enter the Address']")
	private WebElement addressclick;
	@FindBy(xpath = "//textarea[@placeholder='Enter Delivery Time']")
	private WebElement deliverytimeclick;
	@FindBy(xpath = "//input[@id='del_limit']")
	private WebElement deliverychargeclick;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-info']")
	private WebElement updateclick;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement isalertdisplayed;

	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-info']")
	private WebElement isupdatebuttondisplayed;

	

	public ManageContactPage actionClick() {
		actionclick.click();
		return this;
	}

	public ManageContactPage phoneClick(String phonevalue) {
		phoneclick.sendKeys(phonevalue);
		return this;
	}

	public ManageContactPage emailClick(String emailvalue) {
		emailclick.sendKeys(emailvalue);
		return this;
	}

	public ManageContactPage adressClick(String addressvalue) {
		addressclick.sendKeys(addressvalue);
		return this;
	}

	public ManageContactPage deliveryTimeClick(String deliverytimevalue) {
		deliverytimeclick.sendKeys(deliverytimevalue);
		return this;
	}

	public ManageContactPage deliveryChargeClick(String deliveryChargevalue) {
		deliverychargeclick.sendKeys(deliveryChargevalue);
		return this;
	}

	public ManageContactPage updateClick() {
		// updateclick.click();
		PageUtility page = new PageUtility();
		page.javaSriptClick(driver, updateclick);
		// WaitUtility wait = new WaitUtility();
		// wait.waitForElementToBeClickable(driver, updateclick);
		return this;
	}

	public boolean isAlertdisplayed() {

		Boolean value = isalertdisplayed.isDisplayed();
		return value;
	}

	public boolean isUpdateButtonDisplayed() {

		Boolean value = isupdatebuttondisplayed.isDisplayed();
		return value;
	}


}

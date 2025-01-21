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

	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact']//following::i[@class='fas fa-arrow-circle-right'])[5]")
	private WebElement managecontactclick;
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

	public void manageContactClick() {
		managecontactclick.click();
	}

	public void actionClick() {
		actionclick.click();
	}

	public void phoneClick(String phonevalue) {
		phoneclick.sendKeys(phonevalue);
	}

	public void emailClick(String emailvalue) {
		emailclick.sendKeys(emailvalue);
	}

	public void adressClick(String addressvalue) {
		addressclick.sendKeys(addressvalue);
	}

	public void deliveryTimeClick(String deliverytimevalue) {
		deliverytimeclick.sendKeys(deliverytimevalue);
	}

	public void deliveryChargeClick(String deliveryChargevalue) {
		deliverychargeclick.sendKeys(deliveryChargevalue);
	}

	public void updateClick() {
		// updateclick.click();
		PageUtility page = new PageUtility();
		page.javaSriptClick(driver, updateclick);
		// WaitUtility wait = new WaitUtility();
		// wait.waitForElementToBeClickable(driver, updateclick);
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

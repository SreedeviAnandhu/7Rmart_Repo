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

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext']")
	private WebElement managefooterpageclick;
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

	public void manageFooterPageClick() {

		managefooterpageclick.click();
	}

	public void actionClick() {
		actionclick.click();
	}

	public void addressClick(String addressvalue) {

		addressclick.sendKeys(addressvalue);
	}

	public void emailClick(String emailvalue) {

		emailclick.sendKeys(emailvalue);
	}

	public void phoneClick(String phonevalue) {

		phoneclick.sendKeys(phonevalue);
	}

	public void updateClick() {

		updateclick.click();
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

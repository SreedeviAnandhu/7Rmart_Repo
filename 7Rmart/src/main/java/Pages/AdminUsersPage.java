package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class AdminUsersPage {
	
	WebDriver driver;

	public AdminUsersPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='small-box-footer']")
	private WebElement adminuserclick;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newclick;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement usernameclick;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordclick;
	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement selectclick;
	@FindBy(xpath = "//button[@name='Create']")
	private WebElement saveclick;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement isalertdisplayed;

	@FindBy(xpath = "//tbody//tr[1]//td[5]//a[3]")
	private WebElement deleteclick;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement isalertdisplayeed;

	public void adminUserClick() {

		adminuserclick.click();
	}

	public void newClick() {

		newclick.click();
	}

	public void userNameClick(String usernamevalue) {

		usernameclick.sendKeys(usernamevalue);
	}

	public void passWordClick(String passwordvalue) {

		passwordclick.sendKeys(passwordvalue);
	}

	public void selectClick() {

		PageUtility page = new PageUtility();
		page.selectByVisibleText(selectclick, "Admin");
	}

	public void saveClick() {

		saveclick.click();
	}

	public boolean isAlertDisplayed() {

		Boolean value = isalertdisplayed.isDisplayed();
		return value;
	}

	public void deleteClick() {
		deleteclick.click();
		driver.switchTo().alert().accept();
	}

	public boolean isAlertDisplayeed() {

		Boolean value = isalertdisplayeed.isDisplayed();
		return value;
	}

}

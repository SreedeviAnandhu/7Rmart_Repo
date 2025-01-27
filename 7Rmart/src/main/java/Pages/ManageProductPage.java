package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageProductPage {
	
	WebDriver driver;

	public ManageProductPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath = "//tbody//tr[1]//td[9]//a[2]")
	private WebElement deleteclick;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement isalertdisplayed;


	public ManageProductPage deleteClick() {

		deleteclick.click();
		driver.switchTo().alert().accept();
		return this;
	}

	public boolean isAlertDisplayed() {

		Boolean value = isalertdisplayed.isDisplayed();
		return value;
	}

}

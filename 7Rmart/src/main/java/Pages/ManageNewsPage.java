package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	
	WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// @FindBy(xpath="//input[@type='text']")private WebElement webelementname;

	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newclick;
	@FindBy(xpath = "//textarea[@placeholder='Enter the news']")
	private WebElement enternews;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	private WebElement saveclick;
	@FindBy(xpath = "//i[@class='icon fas fa-check']")
	private WebElement isalertdisplayed;

	
	public ManageNewsPage newClick() {
		newclick.click();
		return this;
	}

	public ManageNewsPage enterNews(String newsvalue) {
		enternews.sendKeys(newsvalue);
		return this;
	}

	public ManageNewsPage saveClick() {
		saveclick.click();
		return this;
	}

	public boolean isAlertDisplayed() {
		Boolean value = isalertdisplayed.isDisplayed();
		return value;
	}


}

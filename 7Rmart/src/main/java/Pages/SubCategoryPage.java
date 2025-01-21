package Pages;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utilities.FileUploadUtility;
import utilities.PageUtility;

public class SubCategoryPage {
	
	WebDriver driver;

	public SubCategoryPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//i[@class='fas fa-arrow-circle-right']//parent::a[@class='small-box-footer'])[4]")
	private WebElement subcategoryclick;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newclick;
	@FindBy(xpath = "//select[@id='cat_id']")
	private WebElement categoryselect;
	@FindBy(xpath = "//input[@id='subcategory']")
	private WebElement Subcategorytype;
	@FindBy(xpath = "//input[@id='main_img']")
	private WebElement imagefileselect;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	private WebElement saveclick;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement isalertdisplayed;

	public void SubCategoryClick() {

		subcategoryclick.click();
	}

	public void newClick() {

		newclick.click();
	}

	public void categorySelect() {

		PageUtility page = new PageUtility();
		page.selectByVisibleText(categoryselect, "Fresh_fruits");
	}

	public void SubCategoryType(String namevalue) {

		Subcategorytype.sendKeys(namevalue);
	}

	public void imageFileSelect() throws AWTException {

		PageUtility page = new PageUtility();
		page.javaSriptClick(driver, imagefileselect);

		FileUploadUtility fileupload = new FileUploadUtility();
		fileupload.fileuploadUsingRobertClass(imagefileselect, Constants.APPLEIMAGE);

	}

	public void saveClick() {

		saveclick.click();
	}

	public Boolean isAlertDisplayed() {

		boolean value = isalertdisplayed.isDisplayed();
		return value;

	}


}

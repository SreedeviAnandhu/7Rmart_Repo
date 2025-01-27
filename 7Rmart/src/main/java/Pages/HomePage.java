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
	
	@FindBy(xpath = "(//i[@class='fas fa-arrow-circle-right']//parent::a[@class='small-box-footer'])[4]")
	private WebElement subcategoryclick;
	@FindBy(xpath = "//p[text()='Manage Product']")
	private WebElement manageproductclick;
	@FindBy(xpath = "//p[text()='Manage News']")
	private WebElement managenewsclick;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext']")
	private WebElement managefooterpageclick;
	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact']//following::i[@class='fas fa-arrow-circle-right'])[5]")
	private WebElement managecontactclick;
	@FindBy(xpath = "//a[@class='small-box-footer']")
	private WebElement adminuserclick;
	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	private WebElement adminclick;
	@FindBy(xpath = "//a[@class='dropdown-item']//following::i[@class='ace-icon fa fa-power-off']")
	private WebElement logoutclick;
	@FindBy(xpath = "//form[@id='login-form']")
	private WebElement ishomepagedisplayed;
	
	public SubCategoryPage SubCategoryClick() {

		subcategoryclick.click();
		return new SubCategoryPage(driver);
	}

	public ManageProductPage manageProductClick() {

		manageproductclick.click();
		return new ManageProductPage(driver);
	}
	
	public ManageNewsPage manageNewsClick() {
		managenewsclick.click();
		return new ManageNewsPage(driver);
	}

	public ManageFooterTextPage manageFooterPageClick() {

		managefooterpageclick.click();
		return new ManageFooterTextPage(driver);
	}
	
	public AdminUsersPage adminUserClick() {

		adminuserclick.click();
		return new AdminUsersPage(driver);
	}
	
	public ManageContactPage manageContactClick() {
		managecontactclick.click();
		return new ManageContactPage(driver);
	}
	
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

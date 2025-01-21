package testScript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.SubCategoryPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class SubCategoryTest extends Base{
	
	@Test
	public void verifyTheUserIsAbleToAddSubCategory() throws IOException, AWTException {

		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
//	String namevalue = ExcelUtilities.readStringData(1, 0, "SubCategory");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.submitClick();

		SubCategoryPage subcategory = new SubCategoryPage(driver);
		subcategory.SubCategoryClick();
		subcategory.newClick();
		subcategory.categorySelect();

		FakerUtility fakerutility = new FakerUtility();
		String namevalue = fakerutility.generateName();

		subcategory.SubCategoryType(namevalue);
		subcategory.imageFileSelect();
		subcategory.saveClick();

		boolean value = subcategory.isAlertDisplayed();
		Assert.assertTrue(value, "Alert is not displayed");

	}


}

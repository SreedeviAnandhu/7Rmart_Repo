package testScript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.SubCategoryPage;
import constants.Constants;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class SubCategoryTest extends Base {

	HomePage homepage;
	SubCategoryPage subcategorypage;
	
	@Test
	public void verifyTheUserIsAbleToAddSubCategory() throws IOException, AWTException {

		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
    //	String namevalue = ExcelUtility.readStringData(1, 0, "SubCategory");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);
	//	loginpage.enterPassword(password);
		homepage=loginpage.submitClick();

	//	SubCategoryPage subcategory = new SubCategoryPage(driver);
		subcategorypage=homepage.SubCategoryClick();
		subcategorypage.newClick();
		subcategorypage.categorySelect();

		FakerUtility fakerutility = new FakerUtility();
		String namevalue = fakerutility.generateName();

		subcategorypage.SubCategoryType(namevalue);
		subcategorypage.imageFileSelect();
		subcategorypage.saveClick();

		boolean value = subcategorypage.isAlertDisplayed();
		Assert.assertTrue(value, Constants.SUBCATEGORYALERT);

	}

}

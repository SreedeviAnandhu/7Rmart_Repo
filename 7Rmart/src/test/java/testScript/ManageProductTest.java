package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ManageProductPage;
import constants.Constants;
import utilities.ExcelUtility;

public class ManageProductTest extends Base {
	
	HomePage homepage;
	ManageProductPage manageproductpage;
	@Test
	public void verifyTheUserIsAbleToDeleteTheProduct() throws IOException {

		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);
	//	loginpage.enterPassword(password);
		homepage=loginpage.submitClick();

	//	manageproductpage manage = new ManageProductPage(driver);
		manageproductpage= homepage.manageProductClick();
		manageproductpage.deleteClick();

		Boolean isalertdisplayed = manageproductpage.isAlertDisplayed();
		Assert.assertTrue(isalertdisplayed, Constants.MANAGEPRODUCTALERT);

	}

}

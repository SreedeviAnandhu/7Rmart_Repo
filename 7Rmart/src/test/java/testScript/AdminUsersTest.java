package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.AdminUsersPage;
import Pages.LoginPage;
import constants.Constants;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends Base{
	
	@Test(retryAnalyzer = retry.Retry.class, description = "Testcase used to add admin users")
	public void verifyTheUserIsAbleToCreateAAdminUser() throws IOException {

		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");

		// String usernamevalue = ExcelUtilities.readStringData(1, 0, "AdminUser");
		// String passwordvalue = ExcelUtilities.readStringData(1, 1, "AdminUser");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.submitClick();

		AdminUsersPage adminuser = new AdminUsersPage(driver);
		adminuser.adminUserClick();
		adminuser.newClick();

		FakerUtility fakerutility = new FakerUtility();
		String admin = fakerutility.generateName();
		String adminpassword = fakerutility.generatePassword();

		adminuser.userNameClick(admin);
		adminuser.passWordClick(adminpassword);
		adminuser.selectClick();
		adminuser.saveClick();

		boolean isalertdisplayed = adminuser.isAlertDisplayed();
		Assert.assertTrue(isalertdisplayed, Constants.ALERTMESSAGEADMIN);

	}

	@Test(retryAnalyzer = retry.Retry.class, description = "Testcase used to delete admin details")
	public void verifyTheUserIsAbleToDeleteTheAdminUserDetails() throws IOException {

		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.submitClick();

		AdminUsersPage adminuser = new AdminUsersPage(driver);
		adminuser.adminUserClick();
		adminuser.deleteClick();

		boolean alertdisplayed = adminuser.isAlertDisplayeed();
		Assert.assertTrue(alertdisplayed, "Alert is not displayed");

	}


}

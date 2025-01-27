package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.AdminUsersPage;
import Pages.HomePage;
import Pages.LoginPage;
import constants.Constants;
import utilities.ExcelUtility;
import utilities.FakerUtility;
import utilities.WaitUtility;

public class AdminUsersTest extends Base{
	
	HomePage homepage;
	AdminUsersPage adminuserpage;
	
	@Test(retryAnalyzer = retry.Retry.class, description = "Testcase used to add admin users")
	public void verifyTheUserIsAbleToCreateAAdminUser() throws IOException {

		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");

	//	 String usernamevalue = ExcelUtility.readStringData(1, 0, "AdminUser");
	//	 String passwordvalue = ExcelUtility.readStringData(1, 1, "AdminUser");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);
		homepage=loginpage.submitClick();

		//AdminUsersPage adminuser = new AdminUsersPage(driver);
		adminuserpage = homepage.adminUserClick();
		adminuserpage.newClick();
		
		FakerUtility fakerutility = new FakerUtility();
		String admin = fakerutility.generateName();
		String adminpassword = fakerutility.generatePassword();

		adminuserpage.userNameClick(admin);
		adminuserpage.passWordClick(adminpassword);
		adminuserpage.selectClick();
		adminuserpage.saveClick();

		boolean isalertdisplayed = adminuserpage.isAlertDisplayed();
		Assert.assertTrue(isalertdisplayed, Constants.ALERTMESSAGEADMIN);

	}

	@Test(retryAnalyzer = retry.Retry.class, description = "Testcase used to delete admin details")
	public void verifyTheUserIsAbleToDeleteTheAdminUserDetails() throws IOException {

		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);
		homepage=loginpage.submitClick();

	//AdminUsersPage adminuser = new AdminUsersPage(driver);
		adminuserpage=homepage.adminUserClick();
		adminuserpage.deleteClick();

		boolean alertdisplayed = adminuserpage.isAlertDisplayeed();
		Assert.assertTrue(alertdisplayed, Constants.ALERTMESSAGEADMINUSER);

	}


}

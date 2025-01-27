package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.LoginPage;
import constants.Constants;
import utilities.ExcelUtility;


public class LoginTest extends Base{
	
	@DataProvider(name = "credentials")
	public Object[][] testData() {
		Object data[][] = { { "admin", "admin" }, { "admin", "hello" }, { "srree", "admin" } };
		return data;
	}

	@Test(/* dataProvider = "credentials", */description = "test case used to login using valid Credentials", groups = {
			"regression" })
	public void verifyTheUserIsAbleToLoginUsingValidCredentials(/* String username,String password */)
			throws IOException {

		// String username= "admin";
		// String password= "admin";

		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.submitClick();

		boolean isHomePageLoded = loginpage.isDashBoardDisplayed();
		Assert.assertTrue(isHomePageLoded,Constants.LOGINTESTALERT);

	}

	@Test
//	@Parameters({ "username", "password" })
	public void verifyTheUserIsAbleToLoginWithIncorrectPassword(/*String username, String password*/) throws IOException {
		// String username = "admin";
		// String password = "hello";

		 String username = ExcelUtility.readStringData(2, 0, "LoginPage");
		 String password = ExcelUtility.readStringData(2, 1, "LoginPage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.submitClick();

		boolean isalertdisplayed = loginpage.isAlertDisplayed();
		Assert.assertTrue(isalertdisplayed, Constants.LOGINTESTALERT1);

	}

	@Test
	public void verifyTheUserIsAbleToLoginIncorrectUsername() throws IOException {
		// String username = "anupama";
		// String password ="admin";

		String username = ExcelUtility.readStringData(3, 0, "LoginPage");
		String password = ExcelUtility.readStringData(3, 1, "LoginPage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.submitClick();

		boolean isalertdisplayedd = loginpage.isAlertDisplayed();
		Assert.assertTrue(isalertdisplayedd, Constants.LOGINTESTALERT2);

	}

	@Test
	public void verifyTheUserIsAbleToLoginWithIncorrectUsernameAndPassword() throws IOException {
		// String username ="anusree";
		// String password ="anupama";

		String username = ExcelUtility.readStringData(4, 0, "LoginPage");
		String password = ExcelUtility.readStringData(4, 1, "LoginPage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.submitClick();

		boolean isalertdisplayeded = loginpage.isAlertDisplayed();
		Assert.assertTrue(isalertdisplayeded,Constants.LOGINTESTALERT3);
	}
}

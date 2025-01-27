package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ManageFooterTextPage;
import constants.Constants;
import utilities.ExcelUtility;

public class ManageFooterTextTest extends Base {
	
	HomePage homepage;
	ManageFooterTextPage managefootertextpage;
	
	@Test(retryAnalyzer = retry.Retry.class, description = "Testcase used to update the footertext")
	public void verifyTheUserIsAbleToUpdateTheFooterText() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		String addressvalue = ExcelUtility.readStringData(1, 0, "FooterText");
		String emailvalue = ExcelUtility.readStringData(1, 1, "FooterText");
		String phonevalue = ExcelUtility.readIntegerData(1, 2, "FooterText");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);
	//	loginpage.enterPassword(password);
		homepage=loginpage.submitClick();

	//	ManageFooterTextPage ManageFooter = new ManageFooterTextPage(driver);
		managefootertextpage=homepage.manageFooterPageClick();
		managefootertextpage.actionClick();
		managefootertextpage.addressClick(addressvalue);
		managefootertextpage.emailClick(emailvalue);
		managefootertextpage.phoneClick(phonevalue);
		managefootertextpage.updateClick();

		Boolean value = managefootertextpage.isAlertDisplayed();
		Assert.assertTrue(value, Constants.MANAGEFOOTERTEXTALERT);

	}

	@Test
	public void verifyIfTheUpdateButtonisDisplayedOrNot() throws IOException {

		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);
		//loginpage.enterPassword(password);
		homepage=loginpage.submitClick();

		//ManageFooterTextPage ManageFooter = new ManageFooterTextPage(driver);
		managefootertextpage=homepage.manageFooterPageClick();
		managefootertextpage.actionClick();

		boolean value = managefootertextpage.isUpdateButtonDisplayed();
		Assert.assertTrue(value, Constants.MANAGEFOOTERTEXTALERT1);

	}


}

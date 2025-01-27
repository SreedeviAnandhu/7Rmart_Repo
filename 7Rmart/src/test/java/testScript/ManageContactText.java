package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ManageContactPage;
import constants.Constants;
import utilities.ExcelUtility;

public class ManageContactText extends Base{

	HomePage homepage;
	ManageContactPage managecontactpage;
	
	@Test(retryAnalyzer = retry.Retry.class, description = "Testcase used to update the contact information", groups = {
			"regression" })
	public void verifyTheUserIsAbleToUpdateTheContactInformation() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		
		String phonevalue = ExcelUtility.readIntegerData(1, 0, "ManageContact");
		String emailvalue = ExcelUtility.readStringData(1, 1, "ManageContact");
		String addressvalue = ExcelUtility.readStringData(1, 2, "ManageContact");
		String deliverytimeclick = ExcelUtility.readIntegerData(1, 3, "ManageContact");
		String deliverychargeclick = ExcelUtility.readIntegerData(1, 4, "ManageContact");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);
		//loginpage.enterPassword(password);
		homepage=loginpage.submitClick();

		//ManageContactPage Managecontact = new ManageContactPage(driver);
		managecontactpage=homepage.manageContactClick();
		managecontactpage.actionClick();
		managecontactpage.phoneClick(phonevalue);
		managecontactpage.emailClick(emailvalue);
		managecontactpage.adressClick(addressvalue);
		managecontactpage.deliveryTimeClick(deliverytimeclick);
		managecontactpage.deliveryChargeClick(deliverychargeclick);
		managecontactpage.updateClick();

		Boolean value = managecontactpage.isAlertdisplayed();
		Assert.assertTrue(value, Constants.MANAGECONTACTTEST);

	}
	
	
	@Test
	public void verifyTheUpdateButtonIsDisplyedSuccessfully() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);
	//	loginpage.enterPassword(password);
		homepage=loginpage.submitClick();

		//ManageContactPage Managecontact = new ManageContactPage(driver);
		managecontactpage=homepage.manageContactClick();
		managecontactpage.actionClick();

		boolean isupdatebuttondisplayed = managecontactpage.isUpdateButtonDisplayed();
		Assert.assertTrue(isupdatebuttondisplayed, Constants.MANAGECONTACTTEST1);

	}

}

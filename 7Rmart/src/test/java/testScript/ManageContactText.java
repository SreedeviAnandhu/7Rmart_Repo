package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.ManageContactPage;
import utilities.ExcelUtility;

public class ManageContactText extends Base{

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
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.submitClick();

		ManageContactPage Managecontact = new ManageContactPage(driver);
		Managecontact.manageContactClick();
		Managecontact.actionClick();
		Managecontact.phoneClick(phonevalue);
		Managecontact.emailClick(emailvalue);
		Managecontact.adressClick(addressvalue);
		Managecontact.deliveryTimeClick(deliverytimeclick);
		Managecontact.deliveryChargeClick(deliverychargeclick);
		Managecontact.updateClick();

		Boolean value = Managecontact.isAlertdisplayed();
		Assert.assertTrue(value, "Alert is not displayed");

	}

	@Test
	public void verifyTheUpdateButtonIsDisplyedSuccessfully() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.submitClick();

		ManageContactPage Managecontact = new ManageContactPage(driver);
		Managecontact.manageContactClick();
		Managecontact.actionClick();

		boolean isupdatebuttondisplayed = Managecontact.isUpdateButtonDisplayed();
		Assert.assertTrue(isupdatebuttondisplayed, "Alert is not displayed");

	}

}

package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
	
	@Test(retryAnalyzer = retry.Retry.class, description = "Testcase used to add news", groups = { "regression" })
	public void verifyTheUserIsAbleToAddTheNews() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		String news = ExcelUtility.readStringData(1, 2, "LoginPage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.submitClick();

		ManageNewsPage managenews = new ManageNewsPage(driver);
		managenews.manageNewsClick();
		managenews.newClick();
		managenews.enterNews(news);
		managenews.saveClick();

		boolean isalertdisplayed = managenews.isAlertDisplayed();
		Assert.assertTrue(isalertdisplayed, "Alert is not displayed");
	}

}

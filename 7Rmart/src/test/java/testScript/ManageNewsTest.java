package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ManageNewsPage;
import constants.Constants;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
	
	HomePage homepage;
	ManageNewsPage managenewspage;
	
	@Test(retryAnalyzer = retry.Retry.class, description = "Testcase used to add news", groups = { "regression" })
	public void verifyTheUserIsAbleToAddTheNews() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		String news = ExcelUtility.readStringData(1, 2, "LoginPage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);
	//	loginpage.enterPassword(password);
		homepage=loginpage.submitClick();

	//	ManageNewsPage managenews = new ManageNewsPage(driver);
		managenewspage=homepage.manageNewsClick();
		managenewspage.newClick();
		managenewspage.enterNews(news);
		managenewspage.saveClick();

		boolean isalertdisplayed = managenewspage.isAlertDisplayed();
		Assert.assertTrue(isalertdisplayed, Constants.MANAGENEWSALERT);
	}

}

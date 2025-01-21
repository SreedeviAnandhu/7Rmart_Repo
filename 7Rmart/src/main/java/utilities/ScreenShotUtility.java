package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShotUtility {
	
	public void getScreenShot(WebDriver driver, String failedTestCase) throws IOException {
		TakesScreenshot scrShot = (TakesScreenshot) driver; // TakesScreenshot - interface //typecasting
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE); // to capture screenshot //the method to capture
																	// screenshot of the current broswer window
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());// new Date - class, to get
																							// current date and time

		File f1 = new File(System.getProperty("user.dir") + "//OutputScreenShot");// eth folder ann varunnath enn
		if (!f1.exists()) {
			f1.mkdirs(); // mkdirs - makedirectory
		}

		String destination = System.getProperty("user.dir") + "//outputScreenShot//" + failedTestCase + timeStamp
				+ ".png";
		File finalDestination = new File(destination);
		FileHandler.copy(screenShot, finalDestination);
	}
	// base classil call chyunnu
	// driver um pass
	// get screenshotas enn parayunna method //take scrrenshot enn parayuna
	// interface inta akathulla method ann
	// browserinta current situaton screenshot edukan ann screenshotutility use
	// chyunnath

}


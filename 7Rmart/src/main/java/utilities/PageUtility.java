package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	
	public void javaSriptClick(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public void jsScrollBy(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
	}

	public void jsExecuterSendKeys(WebElement FieldItem, String value1, WebDriver driver) {
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].value=value1;", FieldItem);
	}

	public String generateCurrentDateAndTime() {
		Date date = new Date();
		SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		return formater.format(date);
	}

	public void selectByVisibleText(WebElement element, String visibleText) {

		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}

	public void selectByIndex(WebElement element, int index) {

		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void selectByValue(WebElement element, int value) {

		Select select = new Select(element);
		select.selectByIndex(value);
	}

	public void confirmationAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();
	}

	public void promptAlert(WebDriver driver) {
		driver.switchTo().alert().sendKeys("message");
		driver.switchTo().alert().accept();
	}

	public static String getTextFromAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	public void rightClick(WebElement dragableItem, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.contextClick(dragableItem);
	}

	public void doubleClick(WebElement dragableItem, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.doubleClick(dragableItem);
	}

	public void moveElement(WebElement dragableItem, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.moveToElement(dragableItem);
	}

	public void dragandDrop(WebElement dragableItem, WebElement droppeditemlist, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(dragableItem, droppeditemlist);
	}

}

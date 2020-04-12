package finalProject.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SummerDressesPage {
	
	public static String SUMMER_DRESSES_URL = "http://automationpractice.com/index.php?id_category=11&controller=category";
	public By printedSummerDress = By.xpath("//a[@title='Printed Summer Dress']");
	public By moreButton = By.xpath("//a[@title='View']");
	
	public void mouseCursorOverFirstDress(WebDriver driver) {
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(printedSummerDress);
		action.moveToElement(element).perform();
	}
	
	public void clickOnMoreButton(WebDriver driver) {
		WebElement element = driver.findElement(moreButton);
		element.click();
	}


}

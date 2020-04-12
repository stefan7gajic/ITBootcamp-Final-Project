package finalProject.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {
	
	public static String HOME_URL = "http://automationpractice.com/index.php";
	public By women = By.xpath("//a[@title='Women']");
	public By summerDresses1 = By.xpath("//a[@title='Summer Dresses']"); 
	public By dresses = By.xpath("//*[@id='block_top_menu']/ul/li[2]/a");
	public By summerDresses2 = By.xpath("//*[@id='block_top_menu']/ul/li[2]/ul/li[3]/a");
	
	public void mouseCursorOverMenu(WebDriver driver, By locator) {
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(locator);
		action.moveToElement(element).perform();
	}

	public void clickOnElementInMenu(WebDriver driver, By locator) {
		WebElement element = driver.findElement(locator);
		element.click();
	}
}

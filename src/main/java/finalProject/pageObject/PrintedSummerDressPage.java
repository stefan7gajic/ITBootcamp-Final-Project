package finalProject.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PrintedSummerDressPage extends SummerDressesPage {
	
	WebDriverWait wait;
	public static String PRINTED_SUMMER_DRESS_URL = "http://automationpractice.com/index.php?id_product=5&controller=product";
	public By quantity = By.xpath("//input[@id='quantity_wanted']"); 
	public By size = By.id("group_1"); 
	public By color = By.xpath("//a[@id='color_14']");
	public By addToCart = By.xpath("//span[contains(text(),'Add to cart')]");
	public By proceedToCheckout = By.xpath("//a[@title='Proceed to checkout']");
	public By proceedToCheckout2 = By.xpath("//*[@id='center_column']/p[2]/a[1]");
	
	
	
	public void selectQuantity(WebDriver driver) {
		WebElement element = driver.findElement(quantity);
		element.click();
		element.sendKeys(Keys.BACK_SPACE);
		element.sendKeys("2");
	}
	
	
	public void selectSize(WebDriver driver) {
		WebElement element = driver.findElement(size);
		Select s = new Select(element);
		s.selectByValue("2");
	}
	
	
	public void selectColor(WebDriver driver) {
		WebElement element = driver.findElement(color);
		element.click();
	}

	
	public void clickAddToCart(WebDriver driver) {
		WebElement element = driver.findElement(addToCart);
		element.click();
	}
	
	
	public void proceedToCheckout(WebDriver driver) {
		WebElement element = driver.findElement(proceedToCheckout);
		element.click();
	}
	
	public void proceedToCheckout2(WebDriver driver) {
		WebElement element = driver.findElement(proceedToCheckout2);
		element.click();
	}
	
	
	public void waitProceedToCheckoutButton(WebDriver driver) {
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(proceedToCheckout));
	}
	
	public void wait(int miliseconds) {
		try {
			Thread.sleep(miliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

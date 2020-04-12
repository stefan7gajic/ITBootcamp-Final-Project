package finalProject.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import finalProject.pageObject.RegistrationPage;

public class RegistrationTest extends RegistrationPage {
	
WebDriver driver;	
	

	@BeforeClass
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	
	
	@Test(priority=1)
  	public void registerCustomerAfterAddingDressToCart() {
		
		driver.get(SUMMER_DRESSES_URL);	
		wait(5000);
		mouseCursorOverFirstDress(driver);
		clickOnMoreButton(driver);
		selectQuantity(driver);
		selectSize(driver);
		selectColor(driver);
		clickAddToCart(driver);
		waitProceedToCheckoutButton(driver);
		proceedToCheckout(driver);
		proceedToCheckout2(driver);
		createAccount(driver, "mailmail@gmail.com");
		wait(5000);
		createNewCustomer(driver);		
		clickSignOutButton (driver);
	}
	
	
	@Test(priority=2)
	public void registerCustomersTest() {
		driver.navigate().to(REG_URL);
	for (int i = 0; i < 30; i++) {
		create30Accounts(driver, i + 1);
		sa.assertAll();
		}
	}
	
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}

}

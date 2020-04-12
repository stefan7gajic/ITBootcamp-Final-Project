package finalProject.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import finalProject.pageObject.PrintedSummerDressPage;



public class CartSummaryTest extends PrintedSummerDressPage {
	
	WebDriver driver;
	
  @BeforeClass
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

  
  @Test()
  	public void shoppingCartSummaryTest() {
	  
	  
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
	  
	  WebElement name = driver.findElement(By.xpath("//*[@id=\"product_5_24_0_0\"]/td[2]/p/a"));
	  String dressName = name.getText();
	  
	  WebElement colorSize = driver.findElement(By.xpath("//td[@class='cart_description']//a[contains(text(),'Color : Blue, Size : M')]"));
	  String colorAndSize = colorSize.getAttribute("innerHTML");
	  
	  WebElement quantityInCart = driver.findElement(By.xpath("//*[@id=\"product_5_24_0_0\"]/td[5]/input[2]"));			
	  String numberOfDresses = quantityInCart.getAttribute("value");
	  
	  SoftAssert sa = new SoftAssert();
		sa.assertEquals(dressName, "Printed Summer Dress");
		sa.assertEquals(colorAndSize, "Color : Blue, Size : M");
		sa.assertEquals(numberOfDresses, "2");	
		sa.assertAll();  
  }
  
  
  @AfterClass
	public void closeBrowser() {
		driver.close();
	}

}

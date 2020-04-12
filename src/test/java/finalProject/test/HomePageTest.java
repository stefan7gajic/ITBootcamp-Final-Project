package finalProject.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import finalProject.pageObject.HomePage;

public class HomePageTest extends HomePage {
	
	WebDriver driver;	
	

	@BeforeClass
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	
	
	  @Test(priority = 1) 
	  public void navigateToSummerDressesPageTest1() {
	  
		  driver.get(HOME_URL); 
		  mouseCursorOverMenu(driver, women);
		  clickOnElementInMenu(driver, summerDresses1); 
		  String currentURL1 = driver.getCurrentUrl(); 
		  String expectedURL1 = "http://automationpractice.com/index.php?id_category=11&controller=category";
	  
		  Assert.assertEquals(currentURL1, expectedURL1); 
	  }
	  
	  
	  @Test(priority = 2) 
	  public void navigateToSummerDressesPageTest2() {
	  
		  driver.navigate().to(HOME_URL); 
		  mouseCursorOverMenu(driver, dresses);
		  clickOnElementInMenu(driver, summerDresses2); 
		  String currentURL2 = driver.getCurrentUrl(); 
		  String expectedURL2 = "http://automationpractice.com/index.php?id_category=11&controller=category";
	  
		  Assert.assertEquals(currentURL2, expectedURL2); 
	  }
	 
	
	  @Test(priority = 3) 
	  public void samePageTest() {
		  
		  driver.get(HOME_URL);
		  mouseCursorOverMenu(driver, women);
		  clickOnElementInMenu(driver, summerDresses1); 
		  String currentURL1 = driver.getCurrentUrl();
	  
		  driver.navigate().to(HOME_URL); 
		  mouseCursorOverMenu(driver, dresses);
		  clickOnElementInMenu(driver, summerDresses2); 
		  String currentURL2 = driver.getCurrentUrl();
	  
		  Assert.assertEquals(currentURL1, currentURL2);  
	  } 
	 

	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
	
  
}

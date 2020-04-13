package finalProject.test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import finalProject.pageObject.LogInPage;

import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class LogInTest extends LogInPage{
	
	WebDriver driver;
  
  @BeforeClass
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
  
  @Test
	public void logInTest() throws IOException, InterruptedException {
	  	driver.get(LOG_URL);
		FileInputStream fis = new FileInputStream("src/test/resources/GeneratedData2.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheetAt(0);
		SoftAssert sa = new SoftAssert();
		
		for (int i = 1; i <= 30; i++) {
			wait(2000);

			Row row = sheet.getRow(i);
			customerLogIn(driver, row.getCell(2).getStringCellValue(), row.getCell(3).getStringCellValue());
			wait(2000);
			WebElement element = driver.findElement(signOutButton);	
			sa.assertEquals(element.isDisplayed(), true);
			element.click();
			sa.assertAll();

		}
	}
  

@AfterClass
	public void closeBrowser() {
		driver.close();
	}

}

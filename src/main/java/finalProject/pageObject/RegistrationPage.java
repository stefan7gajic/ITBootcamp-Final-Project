package finalProject.pageObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class RegistrationPage extends PrintedSummerDressPage {
	
	public static String REG_URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	
	public SoftAssert sa;
	public By email = By.id("email_create");
	public By createAnAccount = By.id("SubmitCreate");
	public By firstName1 = By.id("customer_firstname");
	public By lastName1 = By.id("customer_lastname");
	public By password = By.id("passwd");
	public By firstName2 = By.id("firstname");
	public By lastName2 = By.id("lastname");
	public By address = By.id("address1");
	public By city = By.id("city");
	public By state = By.id("id_state");
	public By zipCode = By.id("postcode");
	public By country = By.id("id_country");
	public By mobilePhone = By.id("phone_mobile");
	public By addressAlias = By.id("alias");
	public By register = By.id("submitAccount");
	public WebElement newCustomerAccountButton;
	public WebElement signOutButton;
	
	public void createAccount(WebDriver driver, String mail) { 
		
		WebElement e1 = driver.findElement(email);
		e1.click();
		e1.sendKeys(mail);
		WebElement e2 = driver.findElement(createAnAccount);;
		e2.click();
		}
	
	
	public void createNewCustomer (WebDriver driver) {
		
		WebElement e1 = driver.findElement(firstName1);
		e1.sendKeys("Josh");
		WebElement e2 = driver.findElement(lastName1);
		e2.sendKeys("Smith");
		WebElement e3 = driver.findElement(password);
		e3.sendKeys("pass321");
		WebElement e4 = driver.findElement(address);
		e4.sendKeys("9344 Hickory Avenue");
		WebElement e5 = driver.findElement(city);
		e5.sendKeys("Orlando");
		WebElement e6 = driver.findElement(state);
		Select s1 = new Select(e6);
		s1.selectByValue("9");
		WebElement e7 = driver.findElement(zipCode);
		e7.sendKeys("32839");
		WebElement e8 = driver.findElement(mobilePhone);
		e8.sendKeys("1903847389");
		WebElement e9 = driver.findElement(register);
		e9.click();
		newCustomerAccountButton = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a"));
		
		Assert.assertEquals(newCustomerAccountButton.isDisplayed(), true);
	}	
	
	public void clickSignOutButton (WebDriver driver) {
		wait(2000);
		signOutButton = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a"));
		signOutButton.click();
	}
	
	
	public String desiredData(int desiredRow, int desiredCell) {

		XSSFWorkbook wb;
		FileInputStream fis;

		try {
			fis = new FileInputStream("src/test/resources/GeneratedData2.xlsx");
			wb = new XSSFWorkbook(fis);
			Sheet sheet = wb.getSheetAt(0);
			Row row = sheet.getRow(desiredRow);
			Cell cell = row.getCell(desiredCell);
			String data = cell.toString();
			wb.close();
			return data;		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public String desiredData2(int desiredRow, int desiredCell) {

		XSSFWorkbook wb;
		FileInputStream fis;

		try {
			fis = new FileInputStream("src/test/resources/GeneratedData2.xlsx");
			wb = new XSSFWorkbook(fis);
			Sheet sheet = wb.getSheetAt(0);
			Row row = sheet.getRow(desiredRow);
			Cell cell = row.getCell(desiredCell);
			int data = (int) cell.getNumericCellValue(); 
			wb.close();
			return String.valueOf(data);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return  null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public void create30Accounts(WebDriver driver, int row) {
		WebElement e1 = driver.findElement(email);
		e1.click();
		e1.sendKeys(desiredData(row, 2));
		WebElement e2 = driver.findElement(createAnAccount);;
		e2.click();
		wait(4000);
		WebElement e3 = driver.findElement(firstName1);
		e3.sendKeys(desiredData(row, 0));
		WebElement e4 = driver.findElement(lastName1);
		e4.sendKeys(desiredData(row, 1));
		WebElement e5 = driver.findElement(password);
		e5.sendKeys(desiredData(row, 3));
		WebElement e6 = driver.findElement(address);
		e6.sendKeys(desiredData(row, 4));
		WebElement e7 = driver.findElement(city);
		e7.sendKeys(desiredData(row, 5));
		WebElement e8 = driver.findElement(state);
		e8.click();
		for (int x = 0; x < row; x++)
			e8.sendKeys(Keys.ARROW_DOWN);
		e8.sendKeys(Keys.ENTER);
		WebElement e9 =  driver.findElement(zipCode);
		e9.sendKeys(desiredData2(row, 6));
		WebElement e10 = driver.findElement(mobilePhone);
		e10.sendKeys(desiredData2(row, 7));
		WebElement e11 = driver.findElement(register);
		e11.click();
		signOutButton = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a"));
			
		sa = new SoftAssert();
		sa.assertEquals(signOutButton.isDisplayed(), true);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);	
		signOutButton.click();
		wait(2000);
		
	}
	
}

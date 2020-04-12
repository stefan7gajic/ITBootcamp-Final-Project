package finalProject.pageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage extends RegistrationPage {
	
		public String LOG_URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
		public By email1 = By.id("email");
		public By password = By.id("passwd");
		public By loginButton = By.id("SubmitLogin");
		public By signOutButton = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a");
		
		

		public void customerLogIn(WebDriver driver, String mail, String pass) {
			
			WebElement e1 = driver.findElement(email1);
			e1.sendKeys(mail);
			WebElement e2 = driver.findElement(password);
			e2.sendKeys(pass);
			WebElement e3 = driver.findElement(loginButton);
			e3.click();		

		}
		
}

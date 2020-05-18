package crossAsyst.TestCase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import crossAsyst.DemoProject.Login;
import crossAsyst.DemoProject.WomenCategory;
import crossAsyst.DemoProject.objectRepo;

@Listeners(crossAsyst.Webdriver.Listener.class)
public class TestCase1 {
	WebDriver driver;
	/*
	 * Login login; WomenCategory Women
	 */;
	 @BeforeTest

	    public void setup(){
		
	        System.setProperty("webdriver.chrome.driver", "Browserdriver\\chromedriver.exe");
	        
	        driver = new ChromeDriver();

	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        driver.manage().window().maximize();
	        driver.get("http://automationpractice.com/index.php");

	    }
	 @Test
	 public void TC_WomenPurchase() throws InterruptedException{
		 try {
		objectRepo OR=new objectRepo(driver);
		
		Boolean testResult= OR.getLogin().signUp();
		testResult &=OR.getWomenCategory().purchaseTwoQuantity();
		testResult &=OR.getorderHistory().verifyOrderAndPrice();
		Assert.assertTrue(testResult);
	    }
	 catch(Exception e) {
		 throw new InterruptedException("Case failed");
	 }
	 }
	 @AfterTest

	    public void tearDown(){
		 driver.quit();
	 }

}

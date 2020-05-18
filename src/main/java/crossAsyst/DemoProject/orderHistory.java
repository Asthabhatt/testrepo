package crossAsyst.DemoProject;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crossAsyst.Webdriver.ReadWriteProperty;
import crossAsyst.Webdriver.WebdriverConfig;

public class orderHistory {

	WebDriver driver;
	@FindBy(xpath="//a[@title='Back to orders']") WebElement backtoOrder;
	final String priceItem="//span[@class='price']";
	@FindBy(xpath=priceItem) WebElement price;
	
	public orderHistory(WebDriver driver){
		  
		  this.driver = driver; 
		  PageFactory.initElements(driver, this);
		  
		  }
	Boolean testResult;
	WebdriverConfig config=new WebdriverConfig();
	
	ReadWriteProperty rp=new ReadWriteProperty();
	public boolean verifyOrderAndPrice() throws Exception
	{
		
		HashMap<String,String> configValue=new HashMap<String,String>();
		configValue=rp.loadproperty("config");
		backtoOrder.click();
		config.waitTillElementvisibility(priceItem, "xpath", driver);
		
		testResult=price.getText().equalsIgnoreCase(configValue.get("rate"));
		
	
		return testResult;
}
}
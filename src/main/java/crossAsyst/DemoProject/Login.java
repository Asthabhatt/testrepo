package crossAsyst.DemoProject;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import crossAsyst.Webdriver.Listener;
import crossAsyst.Webdriver.ReadWriteProperty;
import crossAsyst.Webdriver.WebdriverConfig;

public class Login {
	
	
	  WebDriver driver;
	  
	  @FindBy(className="login") WebElement signInLink;
	  
	  @FindBy(id="email_create") WebElement createEmail;
	  
	  @FindBy(id="SubmitCreate") WebElement createAccntBtn;
	  @FindBy(id="id_gender1")	WebElement mrBtn;
	 @FindBy(id="id_gender2")	WebElement mrsBtn;
	 @FindBy (id="customer_firstname") WebElement fName;
	 @FindBy(id="customer_lastname") WebElement lName;
	 @FindBy(id="days") WebElement daysDropdown;
	 @FindBy(id="months") WebElement monthsDropdown;
	 @FindBy(id="years") WebElement yearsDropdown;
	 @FindBy(id="firstname") WebElement addressFirstName;
	 @FindBy(id="lastname") WebElement addressLastName;	 
	 @FindBy(id="address1") WebElement address;
	 @FindBy(id="city") WebElement city;
	 @FindBy(id="id_state") WebElement state;
	 @FindBy(id="postcode") WebElement zipCode;
	 @FindBy(id="phone_mobile") WebElement mobilePhone;
	 @FindBy(id="alias")WebElement aliasAddress;
	 @FindBy(id="submitAccount") WebElement registerBtn;
	 @FindBy(id="passwd")WebElement passwordField;
	 @FindBy(xpath="//span[text()='My account']")WebElement myAccount;
	
	 @FindBy(id="email")WebElement emaillogin;
	 @FindBy(id="passwd")WebElement password;
	 @FindBy(id="SubmitLogin")WebElement signinBtn;
	 
	  public Login(WebDriver driver){
	  
	  this.driver = driver; 
	  PageFactory.initElements(driver, this);
	  
	  }
	 
ReadWriteProperty rp=new ReadWriteProperty();
WebdriverConfig config=new WebdriverConfig();

Boolean testResult;
public Boolean signUp ()
{
	HashMap<String,String> loginValue=new HashMap<String,String>();
	loginValue=rp.loadproperty("LoginDetail");
	
	signInLink.click();
	config.waitTillElementPresence("email_create", "id",driver);
	createEmail.sendKeys(loginValue.get("email"));
	createAccntBtn.click();
	config.waitTillElementPresence("id_gender1", "id",driver);
	
	if(loginValue.get("Title").equalsIgnoreCase("Mrs")) {
		mrsBtn.click();
	}
	else
		mrBtn.click();
	
	fName.clear();
	fName.sendKeys(loginValue.get("Firstname"));
	lName.clear();
	lName.sendKeys(loginValue.get("Lastname"));
	
	passwordField.sendKeys(loginValue.get("password"));
	
	config.selectByValue(daysDropdown, loginValue.get("Day"));
	config.selectByValue(monthsDropdown, loginValue.get("Month"));
	config.selectByValue(yearsDropdown, loginValue.get("Year"));
		
	address.clear();
	address.sendKeys(loginValue.get("Address"));
	
	city.sendKeys(loginValue.get("City"));
	zipCode.sendKeys(loginValue.get("Zipcode"));
	
	config.selectByVisibleText(state, loginValue.get("State"));
	
	mobilePhone.sendKeys(loginValue.get("MobilePhone"));
	aliasAddress.sendKeys(loginValue.get("alias"));
	
	Assert.assertEquals(addressFirstName.getAttribute("value").trim(), loginValue.get("Firstname").trim(), "First Name is correct");
	Assert.assertEquals(addressLastName.getAttribute("value").trim(),loginValue.get("Lastname").trim(),"Last Name is correct");
	
	registerBtn.click();
	config.waitTillElementvisibility("//span[text()='My account']", "xpath",driver);
	if(myAccount.isDisplayed()) {
		testResult=true;
	}


	return testResult;
}

}

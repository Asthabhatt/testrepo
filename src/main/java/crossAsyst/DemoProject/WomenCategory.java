package crossAsyst.DemoProject;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crossAsyst.Webdriver.ReadWriteProperty;
import crossAsyst.Webdriver.WebdriverConfig;

public class WomenCategory {
	WebDriver driver;
	@FindBy(xpath="//div[@id='block_top_menu']//a[@title='Women']") WebElement womenTab;
	@FindBy(xpath="//div[@id='block_top_menu']//a[@title='T-shirts']")WebElement Tshirtlink;
	@FindBy(xpath="//a[@title='Add to cart']")WebElement addToCartLink;
	final String image="//a[@class='product_img_link']//img[@title='Faded Short Sleeve T-shirts']";
	@FindBy(xpath=image)WebElement imageLink;
	final String CART2="//span[@class='ajax_cart_quantity']//parent::span";
	@FindBy(xpath=CART2)WebElement cartText2;
	final String quantity="layer_cart_product_quantity";
	@FindBy(id=quantity)WebElement quantityElement;
	@FindBy(xpath="//span[@title='Continue shopping']")WebElement continueShoppingBtn;
	@FindBy(xpath="//a[@title='Proceed to checkout']")WebElement checkoutBtn;
	@FindBy(xpath="//span[@id='total_price']")WebElement totalPrice;
	final String checkout2="//a[@title='Proceed to checkout'][contains(@class,'standard-checkout button-medium')]";
	@FindBy(xpath=checkout2)WebElement checkOutsecondBtn;
	final String checkout3="processAddress";
	@FindBy (name=checkout3)WebElement checkOutAgain;
	@FindBy(name="processCarrier")WebElement checkOutLast;
	final String terms="uniform-cgv";
	@FindBy(id=terms) WebElement termscheckBox;
	final String bank="bankwire";
	@FindBy(className=bank) WebElement bankPaymentOption;
	@FindBy(xpath="//span[text()='I confirm my order']") WebElement confirmOrder;
	
	
	public WomenCategory(WebDriver driver){
		  
		  this.driver = driver; 
		  PageFactory.initElements(driver, this);
		  
		  }
	WebdriverConfig config=new WebdriverConfig();
	boolean testResult;
	private String rate=null;
	ReadWriteProperty rp=new ReadWriteProperty();
	
	public boolean purchaseTwoQuantity() throws Exception
	{
		
		config.mouseHover(womenTab, driver);
		config.mouseHoverClick(Tshirtlink,driver);
		//Tshirtlink.click();
		config.waitTillElementvisibility(image, "xpath", driver);
		config.mouseHover(imageLink, driver);
		addToCartLink.click();
		config.waitTillElementvisibility(quantity, "id", driver);
		testResult =quantityElement.getText().equalsIgnoreCase("1");
		continueShoppingBtn.click();
		config.waitTillElementvisibility(image, "xpath", driver);
		testResult &=imageLink.isDisplayed();
		config.mouseHover(imageLink, driver);
		addToCartLink.click();
		config.waitTillElementvisibility(CART2, "xpath", driver);
		testResult &=quantityElement.getText().equalsIgnoreCase("2");
		checkoutBtn.click();
		testResult &=totalPrice.isDisplayed();
		 rate=totalPrice.getText();
		 rp.WriteProp("rate", rate, "config");
		 config.waitTillElementvisibility(checkout2, "xpath", driver);
		checkOutsecondBtn.click();
		
		config.waitTillElementvisibility(checkout3, "name", driver);
		checkOutAgain.click();
		config.waitTillElementvisibility(terms, "id", driver);
		termscheckBox.click();
		checkOutLast.click();
		config.waitTillElementvisibility(bank, "className", driver);
		bankPaymentOption.click();
		testResult &=confirmOrder.isDisplayed();
		confirmOrder.click();
		
		return testResult;

}
	public String setRate(String rate) {
		 return rate;
		 
	}
	public String getrate() {
		return this.rate;
	}
	
}

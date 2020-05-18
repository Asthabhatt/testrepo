package crossAsyst.DemoProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class objectRepo {
	
	WebDriver driver;
	
	public objectRepo(WebDriver driver){
		  
		  this.driver = driver; 
	}
	public Login getLogin() {
        return new Login(driver);
    }
	public WomenCategory getWomenCategory() {
        return new WomenCategory(driver);
    }
	
	public orderHistory getorderHistory() {
		return new orderHistory(driver);
	}
}

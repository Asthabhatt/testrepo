package crossAsyst.Webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverConfig {

	Select s;
	Actions act;
	public void waitTillElementPresence(String element, String locator, WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
		if(locator.equalsIgnoreCase("id"))
		{
				wait.until(ExpectedConditions.presenceOfElementLocated(By.id(element)));
	}
		else if(locator.equalsIgnoreCase("className")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.className(element)));
		}
		
		else
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element)));
		}
		}
	public void waitTillElementvisibility(String element, String locator, WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
		if(locator.equalsIgnoreCase("id"))
		{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element)));
	}
		else if(locator.equalsIgnoreCase("className")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(element)));
		}
		else if(locator.equalsIgnoreCase("name")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(element)));
		}
		else
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
		}
		}
	public void selectByValue(WebElement element,String value) {
		
		 s=new Select(element);
		s.selectByValue(value);
	}
	
public void selectByVisibleText(WebElement element,String value) {
		
		 s=new Select(element);
		s.selectByVisibleText(value);
	}
public void mouseHover(WebElement element, WebDriver driver) throws InterruptedException {
	
	act=new Actions(driver);
	act.moveToElement(element);
	act.build().perform();
}
public void mouseHoverClick(WebElement element, WebDriver driver) throws InterruptedException {
	
	act=new Actions(driver);
	act.moveToElement(element);
	act.click().build().perform();
}

}

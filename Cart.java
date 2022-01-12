package p3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Cart {
	WebDriver driver;
	WebElement buttonCheckout;
	WebElement removeJacket;
	WebElement removeOnesie;
	

	public Cart(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getButtonCheckout() {
		return driver.findElement(By.id("checkout"));
	}
	

	public WebElement getRemoveJacket() {
		return driver.findElement(By.cssSelector("#remove-sauce-labs-fleece-jacket"));
	}

	public WebElement getRemoveOnesie() {
		return driver.findElement(By.cssSelector("#remove-sauce-labs-onesie"));
	}

	public void clickOnButtonCheckout() {
		this.getButtonCheckout().click();
	}

}

package p3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CompleteOrder {

	WebDriver driver;

	WebElement thankyouNote;
	WebElement buttonBackHome;

	public CompleteOrder(WebDriver driver) {
		super();
		this.driver = driver;

	}

	public WebElement getThankyouNote() {
		return driver.findElement(By.cssSelector(
				"div:nth-child(2) div.page_wrapper div:nth-child(1) div.checkout_complete_container > h2.complete-header"));
	}

	public WebElement getButtonBackHome() {
		return driver.findElement(By.id("back-to-products"));
	}

	public String thankYou() {
		return getThankyouNote().getText();
	}

	public void clickOnButtonBackHome() {
		this.getButtonBackHome().click();
	}

}

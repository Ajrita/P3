package p3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OverviewOrder {
	WebDriver driver;
	WebElement buttonFinish;
	WebElement onesieItem;
	WebElement jacketItem;
	WebElement price;

	public OverviewOrder(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getButtonFinish() {
		return driver.findElement(By.id("finish"));
	}

	public WebElement getOnesieItem() {
		return driver.findElement(By.cssSelector(
				"div.page_wrapper div.checkout_summary_container div.cart_list div.cart_item:nth-child(4) div.cart_item_label a:nth-child(1) > div.inventory_item_name"));
	}

	public WebElement getJacketItem() {
		return driver.findElement(By.cssSelector(
				"div.page_wrapper div.checkout_summary_container div.cart_list div.cart_item:nth-child(3) div.cart_item_label a:nth-child(1) > div.inventory_item_name"));
	}

	public WebElement getPrice() {
		return driver.findElement(By.cssSelector(
				"div.page_wrapper div:nth-child(1) div.checkout_summary_container div:nth-child(1) div.summary_info > div.summary_total_label:nth-child(7)"));
	}

	public String price() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", getPrice());
		Thread.sleep(2000);
		return getPrice().getText();

	}

	public void clickOnButtonFinish() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", getButtonFinish());
		Thread.sleep(2000);
		this.getButtonFinish().click();

	}

}

package p3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Products {
	WebDriver driver;
	WebDriverWait webDriverWait;
	WebElement menu;
	WebElement leastExpensive;
	WebElement mostExpensive;
	WebElement buttonRemoveJacket;
	WebElement buttonRemoveOnesie;
	WebElement basket;
	WebElement burgerMenu;
	WebElement logout;
    // WebElement js;

	public Products(WebDriver driver, WebDriverWait webDriverWait) {
		super();
		this.driver = driver;
		this.webDriverWait = webDriverWait;
	}
	
	public WebElement getMenu() {
		return driver.findElement(By.cssSelector(
				"div.page_wrapper div.header_container:nth-child(1) div.header_secondary_container div.right_component span.select_container select.product_sort_container > option:nth-child(3)"));

	}

	public WebElement getLeastExpensive() {
		return driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-onesie"));
	}

	public WebElement getMostExpensive() {
		return driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-fleece-jacket"));
	}

	public WebElement getButtonRemoveJacket() {
		return driver.findElement(By.cssSelector("#remove-sauce-labs-fleece-jacket"));
	}

	public WebElement getButtonRemoveOnesie() {
		return driver.findElement(By.cssSelector("#remove-sauce-labs-onesie"));
	}

	public WebElement getBasket() {
		return driver.findElement(By.cssSelector(
				"div.page_wrapper div:nth-child(1) div.header_container:nth-child(1) div.primary_header div.shopping_cart_container:nth-child(3) > a.shopping_cart_link"));
	}
	public WebElement getBurgerMenu() {
		return driver.findElement(By.cssSelector("#react-burger-menu-btn"));
	}

	public WebElement getLogout() {
		return driver.findElement(By.cssSelector("#logout_sidebar_link"));
	}


	public void clickOnMenu() {
		this.getMenu().click();
	}

	public void clickOnLeastExpensive() {
		this.getLeastExpensive().click();
	}

	public void clickOnMostExpensive() throws InterruptedException { // scroll is needed 'cause locator isn't visible
																		// immediately on the page
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", getMostExpensive());
		// js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
		this.getMostExpensive().click();

	}

	public void clickOnBasket() {
		this.getBasket().click();
	}
	
	public void clickBurgerMenu() {
		this.getBurgerMenu().click();
	}

	public void clickLogout() {
		webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#logout_sidebar_link")));
		this.getLogout().click();
	}

}

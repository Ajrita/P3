package p3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Fill_Information {

	WebDriver driver;
	WebElement firstName;
	WebElement lastName;
	WebElement zipCode;
	WebElement buttonContinue;

	public Fill_Information(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getFirstName() {
		return driver.findElement(By.id("first-name"));
	}

	public WebElement getLastName() {
		return driver.findElement(By.id("last-name"));
	}

	public WebElement getZipCode() {
		return driver.findElement(By.id("postal-code"));
	}

	public WebElement getButtonContinue() {
		return driver.findElement(By.id("continue"));
	}
	public void insertFirstName(String firstName) {
		this.getFirstName().clear();
		this.getFirstName().sendKeys(firstName);
	}
		public void insertLastName(String lastName) {
			this.getLastName().clear();
			this.getLastName().sendKeys(lastName);
			
		}
		public void insertZipCode(String zipCode) {
			this.getZipCode().clear();
			this.getZipCode().sendKeys(zipCode);
			
		}
		public void clickButtonContinue() {
			this.getButtonContinue().click();
		}

}

package p3;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
	WebDriver driver;
	WebElement usernameField;
	WebElement passwordField;
	WebElement loginButton;

	public MainPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getUsernameField() {
		return driver.findElement(By.id("user-name"));
	}

	public WebElement getPasswordField() {
		return driver.findElement(By.id("password"));
	}

	public WebElement getLoginButton() {
		return driver.findElement(By.id("login-button"));
	}

	public void insertUsername(String username) {
		this.getUsernameField().clear();
		this.getUsernameField().sendKeys(username);
	}
		public void insertPassword(String password) {
			this.getPasswordField().clear();
			this.getPasswordField().sendKeys(password);
			
		}
		public void clickLoginButton() {
			this.getLoginButton().click();
		}

	}


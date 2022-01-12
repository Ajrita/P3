package p3;

/* P3 QA Technical task: Using Selenium or Cypress, create an UI automated test with the test steps listed below. 
 * Perform only the given steps and add any assertions and validations you think are necessary or useful.
*Hint* Try to follow the best coding practices, keep the code consistent and avoid duplications.

1. Navigate to https://www.saucedemo.com/
2. Use the information from the page to log in
3. Sort the item list from low to high price
4. Add to cart the least expensive and the most expensive item
5. Open the cart and complete the checkout process
6. Logout from the store*/

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import p3.ExcelReader;
import p3.MainPage;
import p3.Cart;
import p3.CompleteOrder;
import p3.Fill_Information;
import p3.OverviewOrder;
import p3.Products;


/*For this project I used ChroPath, to find locators easier, 
 * and I tested it with Selenium through Google Chrome Version 96.0.4664.110 (Official Build) (64-bit)
 * This project covers just happy path*/

public class Base {
	
	// Making the objects of the class
   // They must be public, otherwise program woludn't work
	
	public WebDriver driver;
	public WebDriverWait webDriverWait; // slowing down test for the purpose of better catching elements
	public ExcelReader excelReader; //getting data from excel table
	public MainPage mainPage;
	public Cart cart;
	public CompleteOrder completeOrder;
	public Fill_Information fill_Information;
	public OverviewOrder overviewOrder;
	public Products products;
	public String url;
	public JavascriptExecutor js; //tool for scrolling on the page when element isn't visible immediately 
	//public Actions actions;


	@BeforeClass
	// Giving to objects the values of the drivers
	
	public void SetUp() throws IOException {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
		webDriverWait = new WebDriverWait(driver, 7);
		excelReader = new ExcelReader("C:\\Users\\PC\\Documents\\Swaglabs.xlsx");
		url = excelReader.getStringData("Swaglabs", 1, 0); // ("https://www.saucedemo.com");
		mainPage = new MainPage(driver);
		cart = new Cart(driver);
	    completeOrder = new CompleteOrder(driver);
		products = new Products (driver, webDriverWait);
		js = new JavascriptExecutor() { // skroll

			@Override
			public Object executeScript(String arg0, Object... arg1) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Object executeAsyncScript(String arg0, Object... arg1) {
				// TODO Auto-generated method stub
				return null;
			}
		};
		

	}

	@AfterClass
	public void tearDown() {
		driver.close();

	}

}


package p3;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*Sorry for code duplications.I didn't find a solution how to solve mandatory login for each test.*/

public class TestSwaglabs extends Base {
	@BeforeMethod
	public void pageSetUp() {
		driver.manage().window().maximize();
		driver.navigate().to(url); // ("https://www.saucedemo.com");
	}

	@Test(priority = 5) // confirming that corresponding page is loaded
	public void successfulLoadedPage() {
		String url = excelReader.getStringData("Swaglabs", 1, 0);
		Assert.assertEquals(url, driver.getCurrentUrl());

	}

	@Test(priority = 10)
	public void confirmingElements() { // confirming that all elements are visible on the page
		Assert.assertTrue(mainPage.getUsernameField().isDisplayed());
		Assert.assertTrue(mainPage.getPasswordField().isDisplayed());
		Assert.assertTrue(mainPage.getLoginButton().isDisplayed());
	}

	@Test(priority = 20)
	public void filledRegistrationRedirectedToProducts() throws InterruptedException {

		// Confirming that registration form can be filed
		// and clicking on the 'Login' button will lead us to corresponding url with
		// products

		String username = excelReader.getStringData("Swaglabs", 1, 1);
		String password = excelReader.getStringData("Swaglabs", 1, 2);
		mainPage.insertUsername(username);
		mainPage.insertPassword(password);
		mainPage.clickLoginButton();
		Thread.sleep(2000);

		String url2 = excelReader.getStringData("Swaglabs", 2, 0);
		Assert.assertEquals(url2, driver.getCurrentUrl());
	}

	@Test(priority = 30)

	public void verifyingMigrationProductsInBasket() throws InterruptedException {

		String username = excelReader.getStringData("Swaglabs", 1, 1);
		String password = excelReader.getStringData("Swaglabs", 1, 2);

		mainPage.insertUsername(username);
		mainPage.insertPassword(password);
		mainPage.clickLoginButton();
		Thread.sleep(2000);
		products.clickOnMenu();
		Assert.assertTrue(products.getMostExpensive().isDisplayed());
		Assert.assertTrue(products.getLeastExpensive().isDisplayed());

		// after clicking on the products, they are sent to a basket, and can't be added
		// to a cart again. Instead,they can be remove.

		products.clickOnLeastExpensive();
		products.clickOnMostExpensive();

		Assert.assertTrue(products.getButtonRemoveOnesie().isDisplayed());
		Assert.assertTrue(products.getButtonRemoveJacket().isDisplayed());

	}

	@Test(priority = 40)

	public void confirmItemsInCart() throws InterruptedException {

		String username = excelReader.getStringData("Swaglabs", 1, 1);
		String password = excelReader.getStringData("Swaglabs", 1, 2);
		mainPage.insertUsername(username);
		mainPage.insertPassword(password);
		mainPage.clickLoginButton();
		Thread.sleep(2000);
		products.clickOnBasket();
		Thread.sleep(1000);

		// confirming that corresponding page is loaded
		String url3 = excelReader.getStringData("Swaglabs", 3, 0);
		Assert.assertEquals(url3, driver.getCurrentUrl());

		Assert.assertTrue(cart.getButtonCheckout().isDisplayed());

		// confirming that products are on the page
		Assert.assertTrue(cart.getRemoveOnesie().isDisplayed());
		Assert.assertTrue(cart.getRemoveJacket().isDisplayed());

	}

	@Test(priority = 50)

	public void fillTheForm() throws InterruptedException {
		String username = excelReader.getStringData("Swaglabs", 1, 1);
		String password = excelReader.getStringData("Swaglabs", 1, 2);
		mainPage.insertUsername(username);
		mainPage.insertPassword(password);
		mainPage.clickLoginButton();
		Thread.sleep(2000);
		products.clickOnBasket();
		Thread.sleep(1000);
		cart.clickOnButtonCheckout();
		Thread.sleep(1000);

		// confirming that corresponding page is loaded
		String url4 = excelReader.getStringData("Swaglabs", 4, 0);
		Assert.assertEquals(url4, driver.getCurrentUrl());

		// confirming that all elements are visible on the page
		Assert.assertTrue(fill_Information.getFirstName().isDisplayed());
		Assert.assertTrue(fill_Information.getLastName().isDisplayed());
		Assert.assertTrue(fill_Information.getZipCode().isDisplayed());
		Assert.assertTrue(fill_Information.getButtonContinue().isDisplayed());

		// Confirming that registration form can be filed
		String firstName = excelReader.getStringData("Swaglabs", 1, 3);
		String lastName = excelReader.getStringData("Swaglabs", 1, 4);
		String zipCode = excelReader.getStringData("Swaglabs", 1, 5);
		fill_Information.insertFirstName(firstName);
		fill_Information.insertLastName(lastName);
		fill_Information.insertZipCode(zipCode);
		fill_Information.clickButtonContinue();
		Thread.sleep(2000);

		// confirming that corresponding page is loaded
		String url5 = excelReader.getStringData("Swaglabs", 5, 0);
		Assert.assertEquals(url5, driver.getCurrentUrl());

		// confirming that products are on the page
		String text = excelReader.getStringData("Swaglabs", 1, 8);
		Assert.assertEquals(overviewOrder.price(), text);

		// confirming that elements are on the page
		Assert.assertTrue(overviewOrder.getButtonFinish().isDisplayed());
		overviewOrder.clickOnButtonFinish();
		Thread.sleep(1000);

		// confirming that corresponding page is loaded
		String url6 = excelReader.getStringData("Swaglabs", 6, 0);
		Assert.assertEquals(url6, driver.getCurrentUrl());

		// confirming that products are sent and no more on the page
		String thanks = excelReader.getStringData("Swaglabs", 2, 8);
		Assert.assertEquals(completeOrder.thankYou(), thanks);

		// confirming that elements are on the page
		Assert.assertTrue(completeOrder.getButtonBackHome().isDisplayed());
		completeOrder.clickOnButtonBackHome();
		Thread.sleep(1000);

		// confirming that user is on the product page
		String url2 = excelReader.getStringData("Swaglabs", 2, 0);
		Assert.assertEquals(url2, driver.getCurrentUrl());

		// confirming that elements are on the page
		Assert.assertTrue(products.getBurgerMenu().isDisplayed());
		products.clickBurgerMenu();
		Thread.sleep(2000);
		Assert.assertTrue(products.getLogout().isDisplayed());
		products.clickLogout();

		// confirming that user left online shop
		String url = excelReader.getStringData("Swaglabs", 1, 0);
		Assert.assertEquals(url, driver.getCurrentUrl());
		Assert.assertTrue(mainPage.getLoginButton().isDisplayed());

	}

	@AfterMethod
	public void cleaning() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();

	}
}
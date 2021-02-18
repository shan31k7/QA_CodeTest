package testNG_tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageClasses.CardsPage;
import pageClasses.HomePage;

public class CompareCardsTest extends BaseTest {

	@Test
	public void compare2CreditCards() {
		HomePage homePage = new HomePage(driver);
		Assert.assertTrue(homePage.isValid_PageTitle(), "Home Page title is not as expected");
		homePage.clickCards();

		CardsPage cardsPage = new CardsPage(driver);
		cardsPage.clickCreditCards();
		cardsPage.clickFirstCompareCheckBox();
		cardsPage.clickLastCompareCheckBox();
		cardsPage.clickCompare();

		// Assert Card 1 details
		Assert.assertTrue(cardsPage.verifyCard1details(), "First card details are missing");

		// Assert Card 2 details
		Assert.assertTrue(cardsPage.verifyCard2details(), "Last card details are missing");
	}

	

}

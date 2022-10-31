package com.solvd.onlinerwebtesting;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class OnlinerTest implements IAbstractTest {

    @DataProvider(name = "Category partial name provider")
    public Object[][] provide() {
        return new Object[][]{{"вид"}, {"эле"}, {"рад"}, {"акс"}};
    }

    @Test
    public void checkNewsHoverAppearsTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.getNewsNavigationElement().isPresent(1));
        homePage.getNewsNavigationElement().hover();
        Assert.assertTrue(homePage.getNewsHoverElement().isVisible());
    }

    @Test
    public void checkPlaceAdRedirectsTest() {
        HomePage homePage = new HomePage(getDriver());
        RealEstatePage realEstatePage;
        homePage.open();
        Assert.assertTrue(homePage.getRealEstateNavigationElement().isPresent(1));
        homePage.getRealEstateNavigationElement().click();
        realEstatePage = homePage.navigateToRealEstatePage();
        realEstatePage.getPlaceAdButton().click();
        Assert.assertTrue(getDriver().getPageSource().contains("Вход"));
    }

    @Test(dataProvider = "Category partial name provider")
    public void checkSearchSuggestionsContainsTextTest(String text) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.getSearchBar().isPresent(1));
        homePage.typeInSearch(text);
        homePage.switchToSearchFrame();
        SoftAssert softAssert = new SoftAssert();
        homePage.getSearchSuggestionCategories()
                .forEach(category -> softAssert.assertTrue(category.getText().contains(text)));
        softAssert.assertAll();

    }

    @Test
    public void checkIsSubmitLoginButtonPresentTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.getLoginButton().click();
        Assert.assertTrue(homePage.getSubmitLoginButton().isPresent(1));
    }

    @Test
    public void checkBestExchangeRateUsedInCalculationTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        RatesPage ratesPage = homePage.navigateToRatesPage();
        ratesPage.getExchangeAmountInput().type("1");
        String bestRateString = ratesPage.getBestRate().getText().replace(",", ".");
        String exchangeResultString = ratesPage.getExchangeResult().getText().replace(",", ".");
        double bestRate = Double.parseDouble(bestRateString);
        double exchangeResult = Double.parseDouble(exchangeResultString);
        Assert.assertEquals(bestRate, exchangeResult);
    }
}

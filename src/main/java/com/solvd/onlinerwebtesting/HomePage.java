package com.solvd.onlinerwebtesting;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//span[text()='Новости']/ancestor::a[contains(@class, 'navigation')]")
    private ExtendedWebElement newsNavigationElement;

    @FindBy(xpath = "//span[text()='Новости']/ancestor::a[contains(@class, 'navigation')]/..//div[contains(@class, 'dropdown_visible')]")
    private ExtendedWebElement newsHoverElement;

    @FindBy(xpath = "//span[text()='Дома и квартиры']/ancestor::a[contains(@class, 'navigation')]")
    private ExtendedWebElement realEstateNavigationElement;

    @FindBy(xpath = "//input[contains(@class, 'search__input')][contains(@placeholder, 'Поиск в Каталоге')]")
    private ExtendedWebElement searchBar;

    @FindBy(xpath = "//iframe[contains(@class, 'modal')]")
    private ExtendedWebElement searchIframe;

    @FindBy(xpath = "//div[contains(@class,'item_category')]")
    private List<ExtendedWebElement> searchSuggestionCategories;

    @FindBy(xpath = "//*[text()='Вход']")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//button[contains(text(), 'Войти')]")
    private ExtendedWebElement submitLoginButton;

    @FindBy(xpath = "//span[contains(@class,'currency-amount')]/ancestor::a[contains(@class, 'navigation')]")
    private ExtendedWebElement ratesNavigationElement;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void typeInSearch(String text) {
        searchBar.type(text);
    }

    public void switchToSearchFrame() {
        getDriver().switchTo().frame(searchIframe.getElement());
    }

    public RatesPage navigateToRatesPage() {
        ratesNavigationElement.click();
        return new RatesPage(driver);
    }

    public RealEstatePage navigateToRealEstatePage() {
        realEstateNavigationElement.click();
        return new RealEstatePage(driver);
    }

    public ExtendedWebElement getNewsNavigationElement() {
        return newsNavigationElement;
    }

    public ExtendedWebElement getNewsHoverElement() {
        return newsHoverElement;
    }

    public ExtendedWebElement getRealEstateNavigationElement() {
        return realEstateNavigationElement;
    }

    public ExtendedWebElement getSearchBar() {
        return searchBar;
    }

    public List<ExtendedWebElement> getSearchSuggestionCategories() {
        return searchSuggestionCategories;
    }

    public ExtendedWebElement getLoginButton() {
        return loginButton;
    }

    public ExtendedWebElement getSubmitLoginButton() {
        return submitLoginButton;
    }

}

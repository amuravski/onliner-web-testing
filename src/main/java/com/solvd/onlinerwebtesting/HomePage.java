package com.solvd.onlinerwebtesting;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//span[@class='b-main-navigation__text'][text()='Новости']/..")
    private ExtendedWebElement newsNavigationElement;

    @FindBy(xpath = "//div[@class='b-main-navigation__dropdown b-main-navigation__dropdown_visible']")
    private ExtendedWebElement newsHoverElement;

    @FindBy(xpath = "//span[@class='b-main-navigation__text'][text()='Дома и квартиры']/..")
    private ExtendedWebElement realEstateNavigationElement;

    @FindBy(xpath = "//input[@class='fast-search__input']")
    private ExtendedWebElement searchBar;

    @FindBy(xpath = "//*[@class='no-touch modal-visible modal-iframe-visible']")
    private ExtendedWebElement searchFrame;

    @FindBy(xpath = "//iframe[@class='modal-iframe']")
    private ExtendedWebElement searchIframe;

    @FindBy(xpath = "//div[@class='result__item result__item_category']")
    private List<ExtendedWebElement> searchSuggestionCategories;

    @FindBy(xpath = "//*[text()='Вход']")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//button[contains(text(), 'Войти')]")
    private ExtendedWebElement submitLoginButton;

    @FindBy(xpath = "//*[@class='_u js-currency-amount']/..")
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

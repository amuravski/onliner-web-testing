package com.solvd.onlinerwebtesting;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class RatesPage  extends AbstractPage {

    @FindBy(xpath = "//input[@name='amount-in']")
    private ExtendedWebElement exchangeAmountInput;

    @FindBy(xpath = "//li[@class='bank to-be-removed']//b")
    private ExtendedWebElement bestRate;

    @FindBy(xpath = "//*[@class='js-cur-result']")
    private ExtendedWebElement exchangeResult;

    public RatesPage(WebDriver driver) {
        super(driver);
    }

    public ExtendedWebElement getExchangeAmountInput() {
        return exchangeAmountInput;
    }

    public ExtendedWebElement getBestRate() {
        return bestRate;
    }

    public ExtendedWebElement getExchangeResult() {
        return exchangeResult;
    }
}

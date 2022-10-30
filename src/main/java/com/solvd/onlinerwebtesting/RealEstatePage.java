package com.solvd.onlinerwebtesting;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class RealEstatePage extends AbstractPage {

    @FindBy(xpath = "//a[@class='project-navigation__button']")
    private ExtendedWebElement placeAdButton;

    public RealEstatePage(WebDriver driver) {
        super(driver);
    }

    public ExtendedWebElement getPlaceAdButton() {
        return placeAdButton;
    }
}

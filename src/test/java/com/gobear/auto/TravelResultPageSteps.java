package com.gobear.auto;

import com.gobear.auto.PageObjects.HomePage;
import com.gobear.auto.PageObjects.TravelResultPage;
import cucumber.api.java.en.And;

public class TravelResultPageSteps {
    private HomePage homePage;
    private TravelResultPage travelResultPage;

    public TravelResultPageSteps() {
        this.homePage = new HomePage();
        this.travelResultPage = new TravelResultPage();
    }


}

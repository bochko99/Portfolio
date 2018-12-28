package tests;

import core.SpecStorage;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;
import utils.EndPoints;

import static core.Auth.auth;

public class CurrencyExchangeTest {

  @BeforeClass
  public static void init() {

    RestAssured.requestSpecification = SpecStorage.commonRequestSpec();
    RestAssured.responseSpecification = SpecStorage.commonResponseSpec();

  }

  @Test
  @DisplayName(EndPoints.currencyexchange_directions_path + " GET")
  public void currencyExchangeDirection() {

    auth().pathParam("path", "Test").get(EndPoints.currencyexchange_directions_path);

  }

  @Test
  @DisplayName(EndPoints.currencyexchange_offers_path + " POST")
  public void currencyExchangeOffers() {

    auth().pathParam("path", "Test").post(EndPoints.currencyexchange_offers_path);

  }

  @Test
  @DisplayName(EndPoints.currencyexchange_transfers_path + " POST")
  public void currencyExchangeTransfers() {

    auth().pathParam("path", "Test").post(EndPoints.currencyexchange_transfers_path);

  }

}

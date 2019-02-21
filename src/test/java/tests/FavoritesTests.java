package tests;

import com.crypterium.cryptApi.pojos.favorite.FavoritesInvoiceModel;
import com.crypterium.cryptApi.pojos.favorite.FavoritesQuoteModel;
import com.crypterium.cryptApi.pojos.operations.OperationModel;
import com.crypterium.cryptApi.pojos.quotes.Quote;
import com.crypterium.cryptApi.pojos.quotes.QuoteModel;
import com.crypterium.cryptApi.utils.EndPoints;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import tests.core.MobileTest;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static core.Auth.auth;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class FavoritesTests extends MobileTest {

    @Test
    @DisplayName(EndPoints.favorites_invoices + "POST -> GET -> DELETE")
    public void testGetFavoritesInvoices() {
        List<OperationModel> operations = Arrays.asList(auth().get(EndPoints.operations).as(OperationModel[].class));
        String invoiceId = operations.get(new Random().nextInt(operations.size())).getId();

        auth().body(new FavoritesInvoiceModel().setInvoiceId(invoiceId).setName("Test check")).post(EndPoints.favorites_invoices);

        auth().get(EndPoints.favorites_invoices);
    }


    @Test
    @DisplayName(EndPoints.favorites_quotes + " POST -> GET -> DELETE")
    public void testGetFavoritesQuotes() {
        List<Quote> quotes = given().get(EndPoints.quotes).as(QuoteModel.class).getQuotes();
        Quote quote = quotes.get(new Random().nextInt(quotes.size()));
        String currency = quote.getCurrency();

        //post
        auth().body(new FavoritesQuoteModel().setCurrency(currency)).post(EndPoints.favorites_quotes);
        //get
        auth()
                .get(EndPoints.favorites_quotes)
                .then()
                .body("$", hasItem(hasEntry("currency", currency)));
        //delete
        auth().pathParam("currency", currency).delete(EndPoints.favorites_quotes_currency);

        auth()
                .get(EndPoints.favorites_quotes)
                .then()
                .body("$", not(hasItem(hasEntry("currency", currency))));

    }


}

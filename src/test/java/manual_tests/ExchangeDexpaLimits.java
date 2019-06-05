package manual_tests;


import com.crypterium.cryptApi.pojos.dexpa.DexpaExchangePairsModel;
import io.restassured.RestAssured;
import io.restassured.internal.mapping.GsonMapper;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.factory.DefaultGsonObjectMapperFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExchangeDexpaLimits {

    private String currencyFrom = "ETH"; //base
    private String currencyTo = "EUR"; //counter
    private String exchange = "kraken";

    @Test
    public void getDexpaLimits(){
        List<DexpaExchangePairsModel> pairsStraight = Arrays.asList(RestAssured.given()
                .baseUri("https://exchanges.dexpa.io")
                .basePath("api/internal/exchange-pairs")
                .queryParam("exchange",exchange)
                .queryParam("base", currencyFrom)
                .queryParam("counter", currencyTo)
                .get().as(DexpaExchangePairsModel[].class));

        List<DexpaExchangePairsModel> pairsReverse = Arrays.asList(RestAssured.given()
                .baseUri("https://exchanges.dexpa.io")
                .basePath("api/internal/exchange-pairs")
                .queryParam("exchange","kucoin")
                .queryParam("base", currencyTo)
                .queryParam("counter", currencyFrom)
                .get().as(DexpaExchangePairsModel[].class));

        Assert.assertFalse(pairsStraight.isEmpty() && pairsReverse.isEmpty());
        System.out.println("Straight (BUY):");
        if(!pairsStraight.isEmpty()) {
            pairsStraight.forEach(System.out::println);
        }
        System.out.println("Reverse (SELL):");
        if(!pairsReverse.isEmpty()) {
            pairsReverse.forEach(System.out::println);
        }
    }
}
package utils;

import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import pojos.CountryItem;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class CommonFunctions {

    public static CountryItem getCountryByCode(String code) {
        CountryItem[] allCountries = given().get(EndPoints.countries).as(CountryItem[].class);
        Optional<CountryItem> country = Arrays.stream(allCountries)
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst();
        return country.orElse(new CountryItem().setCode("RU"));
    }

    public static CountryItem getRandomCountryByCryptoRestrictions(boolean isRestricted) {

        CountryItem[] allCountries = given().get(EndPoints.countries).as(CountryItem[].class);
        List<CountryItem> countries = Arrays.stream(allCountries)
                .filter(c -> c.getHasCryptoRestrictions().equals(isRestricted))
                .filter(c -> !c.getName().contains(" ")).collect(Collectors.toList());
        if (countries.isEmpty()) {
            return new CountryItem();
        } else {
            return countries.get(new Random().nextInt(countries.size()));
        }

    }

    public static String generateFreePhoneNumber() {
        for (int i = 0; i < 10; i++) {
            //700000 00001-700000 29999

            String phoneNumber = "700000" + new Random().nextInt(3) + RandomStringUtils.random(4, false, true);
            Response r = given()
                    .baseUri(Environment.MANAGEMENT_URL)
                    .basePath(Constants.MANAGEMENT)
                    .queryParam("mobile", phoneNumber)
                    .get(EndPoints.testers_mobile);
            if (r.prettyPrint().equals("null")) {
                return phoneNumber;
            }
        }
        return "";
    }

    public static String generateFreeEmail() {
        for (int i = 0; i < 10; i++) {
            //%+test@%.com
            String email = String.format("%s+test@%s.com",
                    RandomStringUtils.randomAlphabetic(5),
                    RandomStringUtils.randomAlphabetic(3)
            );
            Response r = given()
                    .baseUri(Environment.MANAGEMENT_URL)
                    .basePath(Constants.MANAGEMENT)
                    .queryParam("email", email)
                    .get(EndPoints.testers_email);

            if (r.prettyPrint().equals("null")) {
                return email;
            }
        }
        return "";
    }

}

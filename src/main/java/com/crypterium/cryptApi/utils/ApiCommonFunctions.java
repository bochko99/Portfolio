package com.crypterium.cryptApi.utils;

import com.crypterium.cryptApi.newback.pojos.catalogs.CountriesModel;
import com.crypterium.cryptApi.newback.pojos.catalogs.Country;
import com.crypterium.cryptApi.newback.pojos.signupoperation.SignUpReq;
import com.crypterium.cryptApi.newback.pojos.signupoperation.VerifyEmail;
import com.crypterium.cryptApi.oldback.pojos.CountryItem;
import org.apache.commons.lang3.RandomStringUtils;
import org.hamcrest.Matchers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import static com.crypterium.cryptApi.Auth.service;
import static io.restassured.RestAssured.given;

public class ApiCommonFunctions {

    public static CredentialEntry getRecipient() {
        CredentialEntry entry = new CredentialEntry()
                .setLogin("70000012345")
                .setPassword("1234567")
                .setType("recipient");
        return Environment.CREDENTIALS.getOrDefault("recipient", entry);
    }

    public static CountryItem getCountryByCode(String code) {
        CountryItem[] allCountries = given().get(EndPoints.countries).as(CountryItem[].class);
        Optional<CountryItem> country = Arrays.stream(allCountries)
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst();
        return country.orElse(new CountryItem().setCode("RU"));
    }

    public static Country getRandomCountryByCryptoRestrictions(boolean isRestricted) {

        List<Country> allCountries = given().get(EndPoints.catalog_countries).as(CountriesModel.class).getCountries();
        List<Country> countries = allCountries.stream()
                .filter(c -> c.getHasCryptoRestrictions().equals(isRestricted))
                .filter(c -> !c.getName().contains(" ")).collect(Collectors.toList());
        if (countries.isEmpty()) {
            return new Country();
        } else {
            return countries.get(new Random().nextInt(countries.size()));
        }

    }

    public static String generateFreePhoneNumber() {
        String phoneNumber;
        int statusCode;
        for (int i = 0; i < 10; i++) {
            //700000 00001-700000 29999

            phoneNumber = "700000" + new Random().nextInt(3) + RandomStringUtils.random(4, false, true);
            SignUpReq signup = new SignUpReq()
                    .setCountry("RU")
                    .setPhone(phoneNumber)
                    .setRegion("");
            statusCode = given().body(signup).expect().statusCode(Matchers.isOneOf(200, 400))
                    .when().post(EndPoints.mobile_signup).statusCode();
            if (statusCode == 200) {
                return phoneNumber;
            }
        }
        return "";
    }

    public static String generateFreeEmail() {
        for (int i = 0; i < 10; i++) {
            String email = String.format("%s+test@%s.com",
                    RandomStringUtils.randomAlphabetic(5),
                    RandomStringUtils.randomAlphabetic(3)
            );
            VerifyEmail verifyEmail = new VerifyEmail()
                    .setEmail(email);
            int statusCode = service().auth().body(verifyEmail).expect().statusCode(Matchers.isOneOf(200, 400))
                    .when().post(EndPoints.mobile_email_verify).statusCode();
            if (statusCode == 200) {
                return email;
            }
        }
        return "";
    }

}

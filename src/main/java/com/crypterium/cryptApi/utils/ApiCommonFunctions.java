package com.crypterium.cryptApi.utils;

import com.crypterium.cryptApi.Auth;
import com.crypterium.cryptApi.pojos.catalogs.CountriesModel;
import com.crypterium.cryptApi.pojos.catalogs.Country;
import com.crypterium.cryptApi.pojos.signupoperation.SignUpReq;
import com.crypterium.cryptApi.pojos.signupoperation.VerifyEmail;
import org.apache.commons.lang3.RandomStringUtils;
import org.hamcrest.Matchers;

import java.util.Arrays;
import java.util.List;
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
                    .setPassword("12345a")
                    .setPhone(phoneNumber);
            statusCode = given().body(signup).expect().statusCode(Matchers.isOneOf(200, 400, 401, 402, 403, 500))
                    .when().post(EndPoints.mobile_signup).statusCode();
            if (statusCode == 200) {
                return phoneNumber;
            }
        }
        return "";
    }

    public static String generateFreeEmail() {
        for (int i = 0; i < 10; i++) {
            String email = String.format("%s+test@crypterium.com",
                    RandomStringUtils.randomAlphabetic(5)
            );
            VerifyEmail verifyEmail = new VerifyEmail()
                    .setEmail(email);
            int statusCode = service().auth().body(verifyEmail).expect().statusCode(Matchers.isOneOf(200, 400, 500))
                    .when().put(EndPoints.mobile_email_add).statusCode();
            if (statusCode == 200) {
                return email;
            }
        }
        return "";
    }

    public static String generateFirstName() {
        List<String> list = Arrays.asList("Jon", "Daenerys", "Bran", "Eddard", "Samwell", "Meera", "Sansa", "Arya", "Gendry",
                "Melisandra", "Davos", "Brienna", "Ramsi", "Ruse", "Tywin");
        return list.get(new Random().nextInt(list.size()));
    }

    public static String generateLastName() {
        List<String> list = Arrays.asList("Stark", "Greyjoy", "Lannister", "Tyrell", "Martell", "Baratheon", "Targaryen", "Arryn",
                "Snow", "Rivers", "Flowers", "Reed", "Tart", "Bolton", "Sand", "Storm", "Tally", "Clegane", "Seaworth");
        return list.get(new Random().nextInt(list.size()));
    }

    public static String getSmsCode(String phoneNumber, String event) {
        String smsCode;
        switch (Environment.TARGET) {
            case "BETA":
                smsCode = "1234";
                break;
            default:
                smsCode = Auth.service().admin().queryParam("phone", phoneNumber)
                        .queryParam("event", event)
                        .get(EndPoints.admin_sms_code).then().extract().body().jsonPath().getString("code");
        }
        return smsCode;
    }

}

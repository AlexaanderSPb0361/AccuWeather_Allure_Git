package com.accuweather;

import static org.hamcrest.Matchers.equalTo;
import org.junit.jupiter.api.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import static io.restassured.RestAssured.given;

@Epic("Location API")
@Feature("Get City Information")
public class GetLocationTest extends BaseTest {

    @Test
    @Story("Get city info by location key")
    @Description("Проверка получения информации о городе по ключу")
    @Severity(SeverityLevel.CRITICAL)
    public void getCityInfoTest() {
        given()
            .queryParam("apikey", API_KEY)
        .when()
            .get("/locations/v1/294021")
        .then()
            .statusCode(200)
            .body("EnglishName", equalTo("Moscow"));
    }
}

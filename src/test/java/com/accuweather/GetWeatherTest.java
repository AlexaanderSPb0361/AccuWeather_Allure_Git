package com.accuweather;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.not;
import org.junit.jupiter.api.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import static io.restassured.RestAssured.given;

@Epic("Weather API")
@Feature("Get Weather")
public class GetWeatherTest extends BaseTest {

    @Test
    @Story("Get current weather")
    @Description("Проверка получения текущей погоды")
    @Severity(SeverityLevel.CRITICAL)
    public void getCurrentWeatherTest() {
        given()
            .queryParam("apikey", API_KEY)
        .when()
            .get("/currentconditions/v1/294021")
        .then()
            .statusCode(200)
            .body("[0].WeatherText", not(empty()));
    }
}

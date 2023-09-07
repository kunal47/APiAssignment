import io.restassured.RestAssured;
import io.restassured.response.Response;

public class WeatherAPIPage {
    private String apiKey;

    public WeatherAPIPage(String apiKey) {
        this.apiKey = apiKey;
        RestAssured.baseURI = "https://weather.visualcrossing.com";
    }

    public Response getWeatherData(String city) {
        return RestAssured
                .given()
                .queryParam("unitGroup", "metric")
                .queryParam("key", apiKey)
                .queryParam("contentType", "json")
                .when()
                .get("/VisualCrossingWebServices/rest/services/timeline/" + city);
    }
}

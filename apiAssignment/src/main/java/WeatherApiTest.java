import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WeatherApiTest {
    private WeatherAPIPage weatherAPIPage;
    private String apiKey = "J87BHS8N96WQ7PYMSGGENV79R"; // Replace with your API key

    @BeforeClass
    public void setUp() {
        weatherAPIPage = new WeatherAPIPage(apiKey);
    }

    @Test
    public void testWeatherData() {
        String city = "Bengaluru";
        Response response = weatherAPIPage.getWeatherData(city);

        // Verify the HTTP status code
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200, "Expected status code 200 but found " + statusCode);

        // Verify that the response contains correct data
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("Bengaluru"), "Response does contain the expected city name.");


    }
}

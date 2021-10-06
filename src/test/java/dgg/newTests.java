package dgg;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class newTests {
    @Test
    public void test_NumberOfCircuitsFor2017Season_ShouldBe20() {

        given().
                when().
                get("https://qadgg001.mocklab.io/helpalldarks").
                then().
                statusCode(200).body("data.id[0]", equalTo(7));
    }
}

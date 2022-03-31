import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class sol1 {
    ResponseSpecification responseSpec;

    @BeforeTest
    public void setup(){
        ResponseSpecBuilder builder = new ResponseSpecBuilder();
        builder.expectStatusCode(200);
        builder.expectHeader("Content-Type","application/json; charset=utf-8");
        builder.expectBody("userId[39]",equalTo(4));
        builder.expectBody("title[39]",equalTo("enim quo cumque"));
        responseSpec = builder.build();


    }
    @Test
    public void Response1(){
        when()
                .get("https://jsonplaceholder.typicode.com/posts").
                then()
                .spec(responseSpec)
                .log().all();

        //.body("userId[39]",equalTo(4))
        //.body("title[39]",equalTo("enim quo cumque"));



    }

}

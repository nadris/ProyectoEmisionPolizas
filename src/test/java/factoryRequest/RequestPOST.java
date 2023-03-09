package factoryRequest;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
public class RequestPOST implements IRequest {
    public RequestPOST() {
    }

    @Override
    public Response send(RequestInfo info) {
        Response response = given()
                .header("Content-Type","application/json")
                .body(info.getBody())
                .log().all()
                .when()
                .post(info.getUrl());
        response.then().log().all();
        return response;
    }
}

package factoryRequest;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
public class RequestGET implements IRequest {

    public RequestGET() {

    }
    @Override
    public Response send(RequestInfo info) {
        Response response =given()
                .log().all()
                .when()
                .get(info.getUrl());
        response.then().log().all();
        return response;
    }
}

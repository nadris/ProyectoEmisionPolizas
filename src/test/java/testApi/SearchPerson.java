package testApi;

import org.junit.jupiter.api.Test;
import factoryRequest.FactoryRequest;
import factoryRequest.RequestInfo;
import io.restassured.response.Response;
import org.json.JSONObject;
import util.ApiConfiguration;
import static org.hamcrest.Matchers.equalTo;
public class SearchPerson {

    Response response;
    JSONObject body = new JSONObject();
    RequestInfo requestInfo = new RequestInfo();
    @Test
    public void verifyPerson() {

        /* CLIENTE ENCONTRADO */
        requestInfo.setUrl(String.format(ApiConfiguration.SEARCH_PERSON,"5854684"));
        requestInfo.setBody(body.toString());
        response = FactoryRequest.make("get").send(requestInfo);
        response.then().body("datospersona.nrodoc", equalTo("5854684")).statusCode(200);
        response.then().body("listamensajes[0]", equalTo("Cliente encontrado")).statusCode(200);
        /* CLIENTE NO ENCONTRADO*/
        requestInfo.setUrl(String.format(ApiConfiguration.SEARCH_PERSON,"54909090"));
        requestInfo.setBody(body.toString());
        response = FactoryRequest.make("get").send(requestInfo);
        response.then().body("listamensajes[0]", equalTo("Número de documento no registrado.")).statusCode(200);

    }



}

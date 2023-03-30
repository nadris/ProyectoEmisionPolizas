package testApi;

import org.junit.jupiter.api.Test;
import factoryRequest.FactoryRequest;
import factoryRequest.RequestInfo;
import io.restassured.response.Response;
import org.json.JSONObject;
import util.ApiConfiguration;
import static org.hamcrest.Matchers.equalTo;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
@Feature("SearchPerson Features")
public class SearchPerson {

    Response response;
    JSONObject body = new JSONObject();
    RequestInfo requestInfo = new RequestInfo();

    @Test
    @Story("Customer Found")
    public void CustomerFound() {

        /* CLIENTE ENCONTRADO */
        requestInfo.setUrl(String.format(ApiConfiguration.SEARCH_PERSON,"5854684"));
        requestInfo.setBody(body.toString());
        response = FactoryRequest.make("get").send(requestInfo);
        response.then().body("datospersona.nrodoc", equalTo("5854684")).statusCode(200);
        response.then().body("listamensajes[0]", equalTo("Cliente encontrado")).statusCode(200);

    }

    @Test
    @Story("Customer Not Found")
    public void CustomerNotFound() {

        /* CLIENTE NO ENCONTRADO*/
        requestInfo.setUrl(String.format(ApiConfiguration.SEARCH_PERSON,"54909090"));
        requestInfo.setBody(body.toString());
        response = FactoryRequest.make("get").send(requestInfo);
        response.then().body("listamensajes[0]", equalTo("Número de documento no registrado.")).statusCode(200);

    }

}

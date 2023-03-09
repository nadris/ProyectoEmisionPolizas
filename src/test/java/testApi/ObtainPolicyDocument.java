package testApi;

import factoryRequest.FactoryRequest;
import factoryRequest.RequestInfo;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import util.ApiConfiguration;

public class ObtainPolicyDocument {

    JSONObject body = new JSONObject();
    Response response;
    RequestInfo requestInfo = new RequestInfo();
    @Test
    public void ObtainPolicy() {

        /* GENERAR DOCUMENTO DE LA POLIZA */
        requestInfo.setUrl(String.format(ApiConfiguration.OBTAIN_DOCUMENT_POLICY,"LPE0063045"));
        requestInfo.setBody(body.toString());
        response = FactoryRequest.make("get").send(requestInfo);
        response.then().body("generado", Matchers.equalTo(true)).statusCode(200);;

        /* NO SE PUDO GENERAR DOCUMENTO DE LA POLIZA*/
        requestInfo.setUrl(String.format(ApiConfiguration.OBTAIN_DOCUMENT_POLICY,"NO-POLIZA"));
        requestInfo.setBody(body.toString());
        response = FactoryRequest.make("get").send(requestInfo);
        response.then().body("generado", Matchers.equalTo(false)).statusCode(200);
    }
}

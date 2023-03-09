package testApi;

import factoryRequest.FactoryRequest;
import factoryRequest.RequestInfo;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import util.ApiConfiguration;

public class RegisterPolicy {

    Response response;
    RequestInfo requestInfo = new RequestInfo();
    @Test
    public void RegisterPolicy() {

        JSONObject registerPolicy = new JSONObject("{\"idcotizacion\":\"\",\"codusuario\":\"lquiroga.lp\",\"codbroker\":\"IMC\",\"paquete\":\"LPPAQ00800\",\"idpersona\":\"764705\",\"objcotizacion\":{\"partiporegistro\":\"E\",\"idproducto\":\"AUT\",\"polizaant\":\"\",\"parmoneda\":\"D\"},\"objdatospoliza\":{\"parpais\":\"29\",\"paralcance\":\"1\",\"flotante\":false,\"flat\":false,\"pmd\":false,\"pardistrito\":\"LPZ\"},\"objvigencias\":{\"iniciov\":\"23/12/2022\",\"terminov\":\"23/12/2023\"},\"objsubrogacion\":{\"favorde\":\"\",\"importe\":\"\",\"parmoneda\":\"\",\"desde\":\"\",\"hasta\":\"\"},\"objasegurado\":{\"dato1\":\"AUTO\",\"dato2\":\"SUZUKI\",\"dato3\":\"SPRESSO\",\"dato4\":\"2022\",\"dato5\":\"5\",\"dato6\":\"998\",\"dato7\":\"K10BN2433312\",\"dato8\":\"MA3FL41S1NA272726\",\"dato9\":\"786AWS\",\"dato10\":\"BLA\",\"dato11\":\"V\",\"dato12\":\"P\",\"dato13\":\"9\",\"dato14\":\"T\",\"dato15\":\"3\",\"dato16\":\"\",\"dato17\":\"LP\",\"dato18\":\"4\",\"dato19\":\"12000.00\",\"dato20\":\"N\",\"dato21\":\"\",\"dato22\":\"3\",\"dato23\":\"\",\"dato24\":\"\",\"dato25\":\"\",\"dato26\":\"\",\"dato27\":\"\",\"dato28\":\"\",\"dato29\":\"\",\"dato30\":\"\",\"dato31\":\"\",\"dato32\":\"\",\"dato33\":\"\",\"dato34\":\"\",\"dato35\":\"\",\"dato36\":\"\",\"dato37\":\"\",\"dato38\":\"\",\"dato39\":\"\",\"dato40\":\"\"},\"objplanpagos\":{\"partipocredito\":\"19\"},\"descuento\":0,\"incremento\":0,\"ubicacion\":null,\"objobservaciones\":null}");

        JSONObject notRegisterPolicy = new JSONObject("{\"idcotizacion\":\"\",\"codusuario\":\"lquiroga.lp\",\"codbroker\":\"IMC\",\"paquete\":\"LPPAQ00800\",\"idpersona\":\"764705\",\"objcotizacion\":{\"partiporegistro\":\"E\",\"idproducto\":\"AUT\",\"polizaant\":\"\",\"parmoneda\":\"D\"},\"objdatospoliza\":{\"parpais\":\"29\",\"paralcance\":\"1\",\"flotante\":false,\"flat\":false,\"pmd\":false,\"pardistrito\":\"LPZ\"},\"objvigencias\":{\"iniciov\":\"23/12/2022\",\"terminov\":\"23/12/2023\"},\"objsubrogacion\":{\"favorde\":\"\",\"importe\":\"\",\"parmoneda\":\"\",\"desde\":\"\",\"hasta\":\"\"},\"objasegurado\":{\"dato1\":\"AUTO\",\"dato2\":\"SUZUKI\",\"dato3\":\"SPRESSO\",\"dato4\":\"2022\",\"dato5\":\"5\",\"dato6\":\"998\",\"dato7\":\"K10BN2433312\",\"dato8\":\"MA3FL41S1NA272726\",\"dato9\":\"786SSF\",\"dato10\":\"BLA\",\"dato11\":\"V\",\"dato12\":\"P\",\"dato13\":\"9\",\"dato14\":\"T\",\"dato15\":\"3\",\"dato16\":\"\",\"dato17\":\"LP\",\"dato18\":\"4\",\"dato19\":\"12000.00\",\"dato20\":\"N\",\"dato21\":\"\",\"dato22\":\"3\",\"dato23\":\"\",\"dato24\":\"\",\"dato25\":\"\",\"dato26\":\"\",\"dato27\":\"\",\"dato28\":\"\",\"dato29\":\"\",\"dato30\":\"\",\"dato31\":\"\",\"dato32\":\"\",\"dato33\":\"\",\"dato34\":\"\",\"dato35\":\"\",\"dato36\":\"\",\"dato37\":\"\",\"dato38\":\"\",\"dato39\":\"\",\"dato40\":\"\"},\"objplanpagos\":{\"partipocredito\":\"19\"},\"descuento\":0,\"incremento\":0,\"ubicacion\":null,\"objobservaciones\":null}");

        /* REGISTRAR POLIZA */
        requestInfo.setUrl(ApiConfiguration.REGISTER_POLICY);
        requestInfo.setBody(registerPolicy.toString());
        response = FactoryRequest.make("post").send(requestInfo);
        response.then().body("codpoliza", Matchers.notNullValue()).statusCode(200);

        /* NO SE REGISTRO POLIZA */
        requestInfo.setUrl(ApiConfiguration.REGISTER_POLICY);
        requestInfo.setBody(notRegisterPolicy.toString());
        response = FactoryRequest.make("post").send(requestInfo);
        response.then().body("codpoliza", Matchers.nullValue()).statusCode(200);
    }
}

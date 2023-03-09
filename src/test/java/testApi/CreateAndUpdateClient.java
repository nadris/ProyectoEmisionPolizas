package testApi;

import factoryRequest.FactoryRequest;
import factoryRequest.RequestInfo;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import util.ApiConfiguration;

import static org.hamcrest.Matchers.equalTo;

public class CreateAndUpdateClient {

    Response response;
    RequestInfo requestInfo = new RequestInfo();
    @Test
    public void CreateAndUpdate() {

        JSONObject existingClient = new JSONObject("{\"datospersona\":{\"idpersona\":\"\",\"nombres\":\"EVA EVELIN\",\"appaterno\":\"PEREZ\",\"apmaterno\":\"DURAN\",\"apesposo\":\"\",\"partipodoc\":\"CI\",\"nrodoc\":\"5493463\",\"nronit\":\"\",\"parlugarexp\":\"LP\",\"parclaseper\":\"N\",\"parsexo\":\"M\",\"fechanac\":\"11/05/1979\",\"parpaisnac\":\"29\",\"parlugarnac\":\"11\",\"parprofesion\":\"4\",\"paractividad\":\"C\",\"email\":\"NERY.CRISOSTO@FIDENSINSURTECH.COM\",\"paractividadcom\":\"18\",\"parsociedadcom\":\"4\",\"partipoemp\":\"\",\"codusuario\":\"imcruz.lp\",\"casilla\":\"\",\"cargo\":\"\",\"parsucursal\":\"\",\"parestadocivil\":\"1\",\"parresidencia\":\"11\",\"fechaintrabajo\":null,\"paringresos\":\"10\",\"partipoafp\":\"1\",\"nua\":null,\"centrocostos\":null,\"cuentabancaria\":null,\"nomconyugue\":null},\"listadirecciones\":[{\"partipodirec\":\"DOM\",\"zona\":\"Sucre\",\"direccion\":\"TRINIDAD TOBAGO\",\"numero\":\"12\",\"parciudad\":\"LPZ\"}],\"listatelefonos\":[{\"partipotel\":\"CEL\",\"numerotelefono\":\"67600929\"}],\"listamensajes\":null}");

        JSONObject updateClient = new JSONObject("{\"datospersona\":{\"idpersona\":\"765501\",\"nombres\":\"EVA EVELIN\",\"appaterno\":\"PEREZ\",\"apmaterno\":\"DURAN\",\"apesposo\":\"\",\"partipodoc\":\"CI\",\"nrodoc\":\"5493463\",\"nronit\":\"\",\"parlugarexp\":\"LP\",\"parclaseper\":\"N\",\"parsexo\":\"M\",\"fechanac\":\"11/05/1979\",\"parpaisnac\":\"29\",\"parlugarnac\":\"11\",\"parprofesion\":\"4\",\"paractividad\":\"C\",\"email\":\"NERY.CRISOSTO@FIDENSINSURTECH.COM\",\"paractividadcom\":\"18\",\"parsociedadcom\":\"4\",\"partipoemp\":\"\",\"codusuario\":\"imcruz.lp\",\"casilla\":\"\",\"cargo\":\"\",\"parsucursal\":\"\",\"parestadocivil\":\"1\",\"parresidencia\":\"11\",\"fechaintrabajo\":null,\"paringresos\":\"10\",\"partipoafp\":\"1\",\"nua\":null,\"centrocostos\":null,\"cuentabancaria\":null,\"nomconyugue\":null},\"listadirecciones\":[{\"partipodirec\":\"DOM\",\"zona\":\"Sucre\",\"direccion\":\"TRINIDAD TOBAGO\",\"numero\":\"12\",\"parciudad\":\"LPZ\"}],\"listatelefonos\":[{\"partipotel\":\"CEL\",\"numerotelefono\":\"67600929\"}],\"listamensajes\":null}");

        /* CLIENTE YA EXISTE */
        requestInfo.setUrl(ApiConfiguration.CREATE_AND_UPDATE_CLIENT);
        requestInfo.setBody(existingClient.toString());
        response = FactoryRequest.make("post").send(requestInfo);
        response.then().body("listaErroresDatos[0]", equalTo("El número de documento ya existe, verifique por favor.")).statusCode(200);

        /* ACTUALIZAR CLIENTE */
        requestInfo.setUrl(ApiConfiguration.CREATE_AND_UPDATE_CLIENT);
        requestInfo.setBody(updateClient.toString());
        response = FactoryRequest.make("post").send(requestInfo);
        response.then().body("idpersona", equalTo("765501")).statusCode(200);
        response.then().body("mensaje", equalTo("Datos Actualizados Correctamente.")).statusCode(200);

    }
}

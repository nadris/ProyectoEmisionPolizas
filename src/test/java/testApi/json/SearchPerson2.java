package testApi.json;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Test;

import java.io.FileReader;


public class SearchPerson2 {


    @Test
    public void verifyPerson() {

        JSONParser parser = new JSONParser();
        try {
            // Leer el archivo JSON
            FileReader reader = new FileReader("/Users/never_adrian/Desktop/apps/idea_apps/ProyectoEmisionPolizas/src/test/java/testApi/datos.json");
            // Convertir el JSON en un objeto Java
            Object obj = parser.parse(reader);
            JSONObject json = (JSONObject) obj;
            // Obtener algunos datos del objeto JSON
            String nombre = (String) json.get("nombre");
            Long edad = (Long) json.get("edad");
            System.out.println("Nombre: " + nombre);
            System.out.println("Edad: " + edad);
        } catch (Exception e) {
            e.printStackTrace();
        }



    }



}

package tipeandocodigo.com.overview.Pages.basepage.API;

import com.google.gson.JsonObject;
import io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class ReqRes {
    public Boolean Login(String email,String password){
        boolean result;
        String webPage = "https://reqres.in/api/login";
        RequestSpecBuilder req = new RequestSpecBuilder();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("email",email);
        jsonObject.addProperty("password",password);
        try {
            req.setBaseUri(webPage)
                    .setContentType("application/json")
                    //.setBody("{\"email\":\""+email+"\",\"password\":\""+password+"\"}")
                    .setBody(jsonObject.toString())
                    .log(LogDetail.ALL);
            Response response = given(req.build()).post();
            result = response.getStatusCode() == 200;
            System.out.println("Status Code from response: "+response.statusCode());
            System.out.println("Response payload: "+response.asString());
            System.out.println("Response token attribute: "+response.jsonPath().get("token"));
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return result;
    }
}

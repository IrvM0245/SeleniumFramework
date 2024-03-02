package ApiTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tipeandocodigo.com.overview.Pages.basepage.API.ReqRes;

public class ReqResTest {
    ReqRes reqRes;

    @BeforeClass
    void setup(){
        reqRes = new ReqRes();
    }
    @Test
    public void testLogin(){
        String email = "eve.holt@reqres.in";
        String password = "cityslicka";
        boolean result = reqRes.Login(email,password);
        Assert.assertTrue(result);
    }
}

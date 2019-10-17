package MelonJsonTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import MelonJson.Json;
import MelonJson.JsonObject;
import MelonJson.entity.BooleanValue;

public class JsonObjectTest {
    @Test
    public void GenerateTest(){
        String s1 = "{\"name\":\"tangdh\",\"age\":13}";
        String s2 = "{\"male\":true}";
        String s3 = "{\"tall\":18.189,\"age\":13}";
        String s4 = "{\"age\":124,\"tall\":1.189,\"male\":true}";
        Json json = new JsonObject(s1);
        Assertions.assertEquals(json.getRecord("\"name\"").get(),"\"tangdh\"");
        Assertions.assertEquals(json.getRecord("\"age\"").get(),13);
        json = new JsonObject(s2);
        Assertions.assertEquals( json.getRecord("\"male\"").get(),true);
        json = new JsonObject(s3);
        Assertions.assertEquals(json.getRecord("\"tall\"").get(),18.189);
        Assertions.assertEquals(json.getRecord("\"age\"").get(),13);
        json = new JsonObject(s4);
        Assertions.assertEquals(json.getRecord("\"age\"").get(),124);
        Assertions.assertEquals(json.getRecord("\"tall\"").get(),1.189);
        Assertions.assertEquals(true, json.getRecord("\"male\"").get());
    }
}

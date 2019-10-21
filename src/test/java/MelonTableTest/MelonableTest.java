package MelonTableTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import MelonJson.Json;
import MelonJson.JsonObject;
import MelonTable.Melonable;
import MelonTable.Table;

public class MelonableTest {

    @Test
    public void deleteTest(){
        Table table = new Melonable("user");
    }
    @Test
    public void changeTest(){
        Table table = new Melonable("user");
    }
    @Test
    public void searchTest(){
        String s1 = "{\"name\":\"tangdh\",\"age\":13}";
        String s2 = "{\"male\":true}";
        String s3 = "{\"tall\":18.189,\"age\":37}";
        String s4 = "{\"age\":124,\"tall\":1.189,\"male\":true,\"name\":\"gzy\"}";
        Json json1 = new JsonObject(s1);
        Json json2 = new JsonObject(s2);
        Json json3 = new JsonObject(s3);
        Json json4 = new JsonObject(s4);
        Table table = new Melonable("user");
        table.add(json1);
        table.add(json2);
        table.add(json3);
        table.add(json4);
        System.out.println(table.search("\"male\"","true"));
        System.out.println(table.search("\"name\"","\"tangdh\""));
        System.out.println(table.search("\"name\"","\"gzy\""));

    }
}

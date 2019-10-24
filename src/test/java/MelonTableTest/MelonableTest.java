package MelonTableTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import MelonJson.Json;
import MelonJson.JsonObject;
import MelonTable.Melonable;
import MelonTable.Table;

public class MelonableTest {
    String s1 = "{\"name\":\"tangdh\",\"age\":13}";
    String s2 = "{\"male\":true}";
    String s3 = "{\"tall\":18.189,\"age\":13}";
    String s4 = "{\"age\":124,\"tall\":1.189,\"male\":true}";
    @Test
    public void createTableTest(){
        Table table = new Melonable("user");
        table.add(new JsonObject(s1));
        table.add(new JsonObject(s3));
        table.add(new JsonObject(s2));
        table.add(new JsonObject(s4));

    }
    @Test
    public void deleteTableTest(){
        Table table = new Melonable("user");
        table.destory();
    }
    @Test
    public void addTest(){
        Table table = new Melonable("user");
        table.add(new JsonObject(s1));
        table.add(new JsonObject(s2));
        table.add(new JsonObject(s3));
        table.add(new JsonObject(s4));
    }

    @Test
    public void deleteTest(){
        Table table = new Melonable("user");
        table.delete(new JsonObject(s2));
        table.delete(new JsonObject(s1));

    }
    @Test
    public void changeTest(){
        deleteTableTest();
        Table table = new Melonable("user");
        table.add(new JsonObject(s1));
        table.add(new JsonObject(s2));
        table.change(new JsonObject(s1),new JsonObject(s3));






    }
    @Test
    public void searchTest(){
        deleteTableTest();
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

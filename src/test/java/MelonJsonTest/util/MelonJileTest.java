package MelonJsonTest.util;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import MelonJson.Json;
import MelonJson.JsonObject;
import MelonJson.entity.Value;
import MelonJson.entity.ValueFactory;
import MelonJson.util.MelonJile;

public class MelonJileTest {
    @Test
    public void MelonJReadTest() throws IOException {
        MelonJile melonJile = new MelonJile();
        File file = new File("./src/test/resources/test.json");
        Json json = melonJile.readFile(file);
        Assertions.assertEquals(json.getRecord("\"name\"").get(),"\"tangdh\"");
        Assertions.assertEquals(json.getRecord("\"age\"").get(),13);
        Assertions.assertEquals(json.getRecord("\"tall\"").get(),199.9);
        Assertions.assertEquals(json.getRecord("\"male\"").get(),false);
    }

    @Test
    public void MelonJWriteTest() throws IOException{
        MelonJile melonJile = new MelonJile();
        File file = new File("./src/test/resources/test.json");
        LinkedHashMap<String, Value> map = new LinkedHashMap<>();
        map.put("\"name\"", ValueFactory.CreatValue("\"tangdh\""));
        map.put("\"age\"",ValueFactory.CreatValue("13"));
        map.put("\"tall\"",ValueFactory.CreatValue("199.9"));
        map.put("\"male\"",ValueFactory.CreatValue("false"));
        melonJile.writeFile(new JsonObject(map),file);

    }

}

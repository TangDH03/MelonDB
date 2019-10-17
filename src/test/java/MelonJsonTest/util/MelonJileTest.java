package MelonJsonTest.util;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import MelonJson.Json;
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
}

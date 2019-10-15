package MelonJsonTest.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import MelonJson.Json;
import MelonJson.JsonObject;
import MelonJson.entity.BooleanValue;
import MelonJson.entity.DoubleValue;
import MelonJson.entity.IntegerValue;
import MelonJson.entity.JsonValue;
import MelonJson.entity.StringValue;
import MelonJson.entity.Value;

public class ValueTest {
    @Test
    public void simpleTest(){
        Value value = new BooleanValue(true);
        assertEquals(true,value.get());
        value = new DoubleValue(2.3);
        assertEquals(2.3,value.get());
        value  = new IntegerValue(2);
        assertEquals(2,value.get());
        value = new StringValue("123");
        assertEquals("123",value.get());
        Json json = new JsonObject();
        value = new JsonValue(json);
        assertEquals(json,value.get());

    }
}

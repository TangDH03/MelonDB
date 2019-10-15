package MelonJson;

import java.util.HashMap;
import java.util.LinkedHashMap;

import Exception.KeyDuplicate;

import MelonJson.entity.Value;
public class JsonObject implements Json{

    private final LinkedHashMap<String, Value> map;

    public JsonObject(){
        map = new LinkedHashMap<String, Value>();
    }

    public JsonObject(LinkedHashMap<String,Value> map){
        this.map = map;
    }

    public boolean addReocrd(String key,Value value){
        if(map.containsKey(key)) {
            throw new KeyDuplicate();
        }
        map.put(key,value);
        return true;
    }

    public boolean addRecord(String key, Value value) {
        return false;
    }

    public boolean deleteRecord(String key) {
        return false;
    }

    public boolean changeRecord(String key, Value value) {
        return false;
    }

    public Value getRecord(String key) {
        return null;
    }
}

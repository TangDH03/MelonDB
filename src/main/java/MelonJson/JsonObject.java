package MelonJson;

import java.util.LinkedHashMap;
import Exception.KeyDuplicate;
import MelonJson.entity.JsonPair;
import MelonJson.entity.Value;
import MelonJson.util.JPairGenerator;

public class JsonObject implements Json{

    private final LinkedHashMap<String, Value> map;
    public JsonObject(){
        map = new LinkedHashMap<String, Value>();
    }

    public JsonObject(LinkedHashMap<String,Value> map){
        this.map = map;
    }

    /*convert  String  to Json */
    public JsonObject(String json){
        json = json.replaceAll("\n","");
        map = new LinkedHashMap<String, Value>();
        for(JsonPair jsonPair:new JPairGenerator(json)){
            map.put(jsonPair.getKey(),jsonPair.getValue());
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        map.forEach((k,v)->
        {
            sb.append(k);
            sb.append(":");
            sb.append(v);
            sb.append(",");
        });
        if(sb.length()!=1)
            sb.deleteCharAt(sb.length()-1);
        sb.append("}");
        return sb.toString();
    }

    public boolean addRecord(String key,Value value){
        if(map.containsKey(key)) {
            throw new KeyDuplicate();
        }
        map.put(key,value);
        return true;
    }

    public boolean deleteRecord(String key) {
        if(map.containsKey(key)){
            map.remove(key);
            return true;
        }
        return false;
    }

    public boolean changeRecord(String key, Value value) {
        if(map.containsKey(key)){
            map.put(key,value);
            return true;
        }
        return false;
    }

    public Value getRecord(String key) {
        return map.get(key);
    }
}

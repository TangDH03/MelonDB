package MelonJson;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import Exception.KeyDuplicate;
import MelonJson.entity.BooleanValue;
import MelonJson.entity.JsonPair;
import MelonJson.entity.Value;
import MelonJson.entity.ValueFactory;
import MelonJson.util.JPairGenerator;
//TODO overwrite the equals and hashcode
public class JsonObject implements Json{
    private final LinkedHashMap<String, Value> map;
    private String name;
    public JsonObject(){
        GenerateName();
        map = new LinkedHashMap<String, Value>();
    }

    public JsonObject(LinkedHashMap<String,Value> map){
        GenerateName();
        this.map = map;
    }

    /*convert  String  to Json */
    public JsonObject(String json){
        GenerateName();
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

    public boolean addRecord(String key,String value){
        return addRecord(key, ValueFactory.CreatValue(value));
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

    public boolean changeRecord(String key,String value){
        return changeRecord(key,ValueFactory.CreatValue(value));
    }



    public Value getRecord(String key) {
        return map.get(key);
    }

    /*
    * this is the subset of json
    * */
    @Override
    public boolean isSubSet(Json json){
        for(Map.Entry<String,Value> entry:map.entrySet()){
            if(json.getRecord(entry.getKey())==null
                    ||!json.getRecord(entry.getKey()).get().equals(entry.getValue().get())){
                return false;
            }
        }
        return true;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JsonObject)) return false;
        JsonObject that = (JsonObject) o;
        return map.equals(that.map);
    }

    @Override
    public int hashCode() {
        return map.hashCode();
    }


    private void GenerateName(){
        name = String.valueOf(System.currentTimeMillis())+".json";
    }
}

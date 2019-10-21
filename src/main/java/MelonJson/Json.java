package MelonJson;


import MelonJson.entity.Value;

public interface Json {

    boolean addRecord(String key, Value value);

    boolean addRecord(String key,String value);

    boolean deleteRecord(String key);

    boolean changeRecord(String key,Value value);

    boolean changeRecord(String key,String value);

    Value getRecord(String key);

    boolean isSubSet(Json json);


}

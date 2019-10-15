package MelonJson;


import MelonJson.entity.Value;

public interface Json {

    boolean addRecord(String key, Value value);

    boolean deleteRecord(String key);

    boolean changeRecord(String key,Value value);

    Value getRecord(String key);
}

package MelonJson.entity;

import MelonJson.Json;

public class JsonValue implements Value{
    private final Json mJson;
    public JsonValue(Json mJson){
        this.mJson = mJson;
    }
    public Json get() {
        return mJson;
    }



    //TODO Override toString function
}

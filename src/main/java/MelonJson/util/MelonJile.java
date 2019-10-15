package MelonJson.util;

import java.io.File;

import MelonJson.Json;
import MelonJson.JsonObject;

public class MelonJile {

    public Json readFile(File file){ //TODO    read file to string
        Json json = new JsonObject();
        return json;
    }



    private Json string2Json(String text){  //TODO   convert String to Json
        return new JsonObject();
    }

    public boolean writeFile(Json json){ // write Json To File
        return true;
    }
}

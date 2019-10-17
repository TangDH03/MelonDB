package MelonJson.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import MelonJson.Json;
import MelonJson.JsonObject;

public class MelonJile {

    public Json readFile(File file) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        while((line = in.readLine())!=null){
            stringBuilder.append(line);
        }
        return new JsonObject(stringBuilder.toString());
    }




    public boolean writeFile(Json json){ // write Json To File
        return true;
    }
}

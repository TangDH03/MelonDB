package MelonJson.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

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
        in.close();
        return new JsonObject(stringBuilder.toString());
    }

    public boolean writeFile(Json json,File file) throws IOException { // write Json To File
        if(!file.exists()){
            file.createNewFile();
        }
        PrintWriter writer = new PrintWriter(new FileWriter(file));
        writer.write(json.toString());
        writer.flush();
        writer.close();
        return true;
    }

    public boolean deleteFile(File file){
        try {
            Files.delete(Paths.get(file.getCanonicalPath()));
        }catch (IOException e){
            e.printStackTrace();
        }
        return true;
    }


}

package MelonTable;


import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import MelonJson.Json;
import MelonJson.JsonObject;
import MelonJson.entity.Value;
import MelonJson.entity.ValueFactory;
import MelonJson.util.MelonJile;

public class Melonable implements Table {


    private final String table_dir;
    private final String name;
    private File file;
    private final List<Json> jsons;

    public Melonable(String name){
        this(name,".");
    }

    public Melonable(String name,String location){
        this.name = name;
        table_dir = location+System.getProperty("file.separator")+name;
        file = new File(table_dir);
        jsons = new ArrayList<>();
        if(!file.exists()) {
            file.mkdir();
        }else{
            MelonJile melonJile = new MelonJile();
            for(File f:file.listFiles()){
                try {
                    Json json = melonJile.readFile(f);
                    json.setName(f.getName());
                    jsons.add(json);
                }catch (IOException e){
                    e.printStackTrace();
                    System.err.println("Read Json"+f.getName()+"  fail");
                }
            }
        }
    }

    @Override
    public boolean destory() {
        if(!file.exists())
            return true;
        MelonJile melonJile = new MelonJile();
        for(File files:file.listFiles()){
            melonJile.deleteFile(files);
        }
        try {
            Files.delete(Paths.get(file.getCanonicalPath()));
        }catch (IOException e){
            e.printStackTrace();
        }
        file = null;
        return true;
    }




    @Override
    public boolean add(Json json){
        List<Json> result = searchByJson(json);
        for(Json data:result){
            if (data.equals(json))
                return false;
        }
        try {
            MelonJile melonJile = new MelonJile();
            melonJile.writeFile(json,
                    new File(table_dir+System.getProperty("file.separator")+json.getName()));
        }catch (IOException e){
            e.printStackTrace();
            System.err.println("fail to create json file  "+table_dir+System.getProperty("file.separator")+json.getName() );
        }

        jsons.add(json);
        return true;
    }

    @Override
    public List<Json> search(Json json) {
        return searchByJson(json);

    }

    @Override
    public boolean delete(Json json) {
        List<Json> result = searchByJson(json);
        for(Json data:result){
            if(data.equals(json)) {
                MelonJile melonJile = new MelonJile();
                melonJile.deleteFile(new File(table_dir+System.getProperty("file.separator")+data.getName()));
                jsons.remove(data);
                return true;
            }
        }
        return false;
    }



    @Override
    public List<Json> search(String... Querys) {
        if(Querys.length%2!=0) {
            return null;
        }
        Json queryJson = new JsonObject();
        for(int i=0;i<Querys.length-1;i++){
            queryJson.addRecord(Querys[i],ValueFactory.CreatValue(Querys[i+1]));
        }
        return searchByJson(queryJson);

    }

    @Override
    public boolean change(Json json,Json newJson) {
        if(delete(json)) {
            add(newJson);
            return true;
        }
        return false;
    }


    private List<Json> searchByJson(Json json){
        List<Json> result = new LinkedList<>();
        for(Json data:jsons){
            if(json.isSubSet(data))
                result.add(data);
        }
        return result;
    }

    public String getName() {
        return name;
    }

}

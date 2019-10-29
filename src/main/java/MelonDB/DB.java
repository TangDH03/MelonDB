package MelonDB;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import MelonJson.Json;
import MelonJson.JsonObject;
import MelonJson.entity.ValueFactory;
import MelonTable.Melonable;
import MelonTable.Table;
import javafx.scene.control.Tab;

public abstract class DB {
    private List<Table> tables;
    private Table usingTable;
    private String location;
    public DB(){
        this("./MelonDB/");
    }
    public DB(String location){
        tables = new ArrayList<>();
        usingTable = null;
        this.location = location;
        File file = new File(location);
        if(!file.exists())
            file.mkdir();
        for(File f:file.listFiles()){
            tables.add(new Melonable(f.getName(),location));
        }
    }

    public boolean creatingMelon(String name){
        for(Table table:tables){
            if(table.getName().equals(name))
                return false;
        }
        tables.add(new Melonable(name,location));
        return true;
    }

    public boolean deleteMelon(String name){
        for(Table table:tables){
            if(table.getName().equals(name)&&!usingTable.getName().equals(name)){
                tables.remove(table);
                table.destory();
                usingTable = null;
                return true;
            }
        }
        return false;
    }

    public boolean usingMelon(String name){
        for(Table table:tables){
            if(table.getName().equals(name)){
                usingTable = table;
                return true;
            }
        }
        return false;
    }

    public boolean add(String Json){
        if(usingTable==null)
            return false;
        usingTable.add(new JsonObject(Json));
        return true;
    }

    public boolean add(String ...KV){
        if(usingTable==null)
            return false;
        if(KV.length%2!=0) {
            return false;
        }
        Json AddJson = KV2Json(KV);
        usingTable.add(AddJson);
        return true;
    }



    public boolean delete(String Json){
        if(usingTable==null)
            return false;
        usingTable.delete(new JsonObject(Json));
        return true;
    }

    public boolean delete(String... KV){
        if(usingTable==null)
            return false;
        if(KV.length%2!=0){
            return false;
        }
        Json DeleteJson = KV2Json(KV);
        usingTable.delete(DeleteJson);
        return true;
    }

    public boolean change(String json,String newJson){
        if(usingTable==null)
            return false;
        return usingTable.change(new JsonObject(json),new JsonObject(newJson));
    }

    public boolean change(String json,String... KV){
        if(usingTable==null)
            return false;
        if(KV.length%2!=0)
            return false;
        return usingTable.change(new JsonObject(json),KV);
    }




    public List<Json> search(String Json){
        if(usingTable==null)
            return null;
        return usingTable.search(new JsonObject(Json));
    }


    public List<Json> search(String... Query){
        if(usingTable==null)
            return null;
        return usingTable.search(Query);
    }







    protected  Json KV2Json(String... KV){
        Json json = new JsonObject();
        for(int i=0;i<KV.length-1;i+=2){
            json.addRecord(KV[i],ValueFactory.CreatValue(KV[i+1]));
        }
        return json;
    }



}

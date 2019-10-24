package MelonDB;

import java.util.ArrayList;
import java.util.List;

import MelonJson.Json;
import MelonJson.JsonObject;
import MelonJson.entity.ValueFactory;
import MelonTable.Melonable;
import MelonTable.Table;

abstract class DB {
    private List<Table> tables;
    private Table usingTable;
    private String location;
    public DB(){
        tables = new ArrayList<>();
        usingTable = null;
        location = "./MelonDB/";
    }
    public DB(String location){
        tables = new ArrayList<>();
        usingTable = null;
        this.location = location;
    }

    public boolean creatingMelon(String name){
        for(Table table:tables){
            if(table.getName().equals(name))
                return false;
        }
        tables.add(new Melonable(name));
        return true;
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
        usingTable.change(new JsonObject(json),new JsonObject(newJson));
        return true;
    }

    public boolean change(String json,String... KV){
        if(usingTable==null)
            return false;
        if(KV.length%2!=0)
            return false;
        Json ChangeJson = KV2Json(KV);
        usingTable.change(new JsonObject(json),ChangeJson);
        return true;
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
        for(int i=0;i<KV.length-1;i++){
            json.addRecord(KV[i],ValueFactory.CreatValue(KV[i+1]));
        }
        return json;
    }



}

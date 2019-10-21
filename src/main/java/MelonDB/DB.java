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
    DB(){
        tables = new ArrayList<>();
        usingTable = null;
        location = "./MelonDB/";
    }
    DB(String location){
        tables = new ArrayList<>();
        usingTable = null;
        this.location = location;
    }

    boolean creatingMelon(String name){
        for(Table table:tables){
            if(table.getName().equals(name))
                return false;
        }
        tables.add(new Melonable(name));
        return true;
    }

    boolean usingMelon(String name){
        for(Table table:tables){
            if(table.getName().equals(name)){
                usingTable = table;
                return true;
            }
        }
        return false;
    }

    boolean add(String Json){
        if(usingTable==null)
            return false;
        usingTable.add(new JsonObject(Json));
        return true;
    }

    boolean add(String ...KV){
        if(usingTable==null)
            return false;
        if(KV.length%2!=0) {
            return false;
        }
        Json AddJson = new JsonObject();
        for(int i=0;i<KV.length-1;i++){
            AddJson.addRecord(KV[i], ValueFactory.CreatValue(KV[i+1]));
        }
        usingTable.add(AddJson);
        return true;
    }




}

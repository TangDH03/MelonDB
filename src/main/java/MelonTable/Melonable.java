package MelonTable;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import MelonJson.Json;
import MelonJson.JsonObject;
import MelonJson.entity.ValueFactory;

public class Melonable implements Table {



    private final String name;
    private final List<Json> jsons;

    public Melonable(String name){
        this.name = name;
        jsons = new ArrayList<>();
    }

    public Melonable(String name,List<Json> jsons ){
        this.jsons = jsons;                     //TODO confuse
        this.name = name;
    }

    @Override
    public boolean add(Json json) {
        List<Json> result = searchByJson(json);
        for(Json data:result){
            if (data.equals(json))
                return false;
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
                jsons.remove(json);
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
    public boolean change(Json json) {
        if(delete(json)) {
            jsons.add(json);
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

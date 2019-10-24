package MelonTable;

import java.util.List;

import MelonJson.Json;

public interface Table {
    boolean add(Json json);
    boolean delete(Json json);
    List<Json>    search(String... Querys);
    List<Json>  search(Json json);
    String getName();
    boolean change(Json json,Json newjson); //TODO
    boolean destory();
}

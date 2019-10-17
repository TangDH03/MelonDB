package MelonJson.util;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import MelonJson.entity.JsonPair;
import MelonJson.entity.JsonValue;
import MelonJson.entity.ValueFactory;

public class JPairGenerator implements Iterable<JsonPair> {

    private static final  String bValue = "true|false";
    private static final  String sValue = "\".*?\"";
    private static final  String iValue = "-?\\d+";
    private static final  String dValue = "[\\\\+\\\\-]{0,1}[0-9]+[\\\\.\\\\,][0-9]+";
    private static final  String Key = "\"[^\\s]+?\"";
    private static final String KV = Key+":"+"("+"("+sValue+")"+"|"+"("+bValue+")"+"|"+"("+dValue+")"+"|"+"("+iValue+")" +")";
    private static final String JsonValue = "^\\{"+KV+"("+","+KV+")"+"*"+"\\}$";
    private static final Pattern pattern = Pattern.compile(JsonValue);
    private final Matcher matcher;
    private String JsonString;

    public JPairGenerator(String jsonString){
        this.JsonString = jsonString;
        matcher = pattern.matcher(jsonString);
    }





    public Iterator<JsonPair> iterator() {
        return new Iterator<JsonPair>() {
            public boolean hasNext() {
                return matcher.find();
            }

            public JsonPair next() {
                String s = matcher.group();
                String[] key_value = s.split(":");
                return new JsonPair(key_value[0], ValueFactory.CreatValue(key_value[1]));
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}

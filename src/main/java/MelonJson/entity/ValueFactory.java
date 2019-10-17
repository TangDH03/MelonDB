package MelonJson.entity;

import java.util.regex.Pattern;

public class ValueFactory {

    private static final  String bValue = "true|false";
    private static final  String sValue = "\".*?\"";
    private static final  String iValue = "-?\\d+";
    private static final  String dValue = "[\\\\+\\\\-]{0,1}[0-9]+[\\\\.\\\\,][0-9]+";
    public static Value CreatValue(String s){
        if(Pattern.matches(bValue,s))
            return new BooleanValue(s);
        else if(Pattern.matches(sValue,s))
            return new StringValue(s);
        else if(Pattern.matches(dValue,s))
            return new DoubleValue(Double.valueOf(s));
        else if(Pattern.matches(iValue,s))
            return new IntegerValue(Integer.valueOf(s));
        return null;
    }
}

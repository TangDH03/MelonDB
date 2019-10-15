package MelonJson.entity;

public class StringValue implements Value {
    private final String mString;
    public StringValue(String mString){
        this.mString = mString;
    }
    public String get() {
        return mString;
    }
}

package MelonJson.entity;

public class IntegerValue implements Value {
    private final Integer mInteger;
    public IntegerValue(Integer mInteger){
        this.mInteger = mInteger;
    }
    public Integer get() {
        return mInteger;
    }
}

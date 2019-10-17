package MelonJson.entity;

public class DoubleValue implements Value {

    private final Double mdouble;
    public DoubleValue(Double mdouble){
        this.mdouble = mdouble;
    }
    public Double get() {
        return mdouble;
    }

    @Override
    public String toString(){
        return String.valueOf(mdouble);
    }
}

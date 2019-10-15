package MelonJson.entity;

public class BooleanValue implements Value {
    private final Boolean mBoolean;

    public BooleanValue(Boolean mBoolean){
        this.mBoolean = mBoolean;
    }

    public Boolean get() {
        return mBoolean;
    }

}

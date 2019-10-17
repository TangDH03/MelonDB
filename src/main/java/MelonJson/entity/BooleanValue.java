package MelonJson.entity;

public class BooleanValue implements Value {
    private final Boolean mBoolean;

    public BooleanValue(Boolean mBoolean){
        this.mBoolean = mBoolean;
    }
    public BooleanValue(String strValue){
        if(strValue.equals("true"))
            mBoolean = true;
        else if(strValue.equals("false"))
            mBoolean = false;
        else
            mBoolean = null;
    }
    public Boolean get() {
        return mBoolean;
    }
    @Override
    public String toString(){
        return String.valueOf(mBoolean);
    }

}

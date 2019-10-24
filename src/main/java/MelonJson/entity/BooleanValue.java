package MelonJson.entity;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BooleanValue)) return false;
        BooleanValue that = (BooleanValue) o;
        return that.get().equals(this.get());
    }

    @Override
    public int hashCode() {
        return this.get().hashCode();
    }
}

package MelonJson.entity;

import java.util.Objects;

public class StringValue implements Value {
    private final String mString;
    public StringValue(String mString){
        this.mString = mString;
    }
    public String get() {
        return mString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StringValue)) return false;
        StringValue that = (StringValue) o;
        return that.get().equals(this.get());
    }

    @Override
    public int hashCode() {
        return this.get().hashCode();
    }

    @Override
    public String toString(){
        return   mString ;
    }
}

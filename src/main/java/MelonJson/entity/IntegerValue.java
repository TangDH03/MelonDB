package MelonJson.entity;

import java.util.Objects;

public class IntegerValue implements Value {
    private final Integer mInteger;
    public IntegerValue(Integer mInteger){
        this.mInteger = mInteger;
    }
    public Integer get() {
        return mInteger;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IntegerValue)) return false;
        IntegerValue that = (IntegerValue) o;
        return that.get().equals(that.get());
    }

    @Override
    public int hashCode() {
        return this.get().hashCode();
    }

    @Override
    public String toString(){
        return String.valueOf(mInteger);
    }
}

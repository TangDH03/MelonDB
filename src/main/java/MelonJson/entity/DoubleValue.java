package MelonJson.entity;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DoubleValue)) return false;
        DoubleValue that = (DoubleValue) o;
        return this.get().equals(that.get());
    }

    @Override
    public int hashCode() {
        return this.get().hashCode();
    }
}

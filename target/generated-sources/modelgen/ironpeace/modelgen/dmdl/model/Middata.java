package ironpeace.modelgen.dmdl.model;
import com.asakusafw.runtime.model.DataModel;
import com.asakusafw.runtime.model.DataModelKind;
import com.asakusafw.runtime.model.ModelInputLocation;
import com.asakusafw.runtime.model.ModelOutputLocation;
import com.asakusafw.runtime.model.PropertyOrder;
import com.asakusafw.runtime.value.IntOption;
import com.asakusafw.runtime.value.LongOption;
import ironpeace.modelgen.dmdl.io.MiddataInput;
import ironpeace.modelgen.dmdl.io.MiddataOutput;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.apache.hadoop.io.Writable;
/**
 * middataを表すデータモデルクラス。
 */
@DataModelKind("DMDL")@ModelInputLocation(MiddataInput.class)@ModelOutputLocation(MiddataOutput.class)@PropertyOrder({
            "keycode", "mid1", "mid2"}) public class Middata implements DataModel<Middata>, Writable {
    private final IntOption keycode = new IntOption();
    private final LongOption mid1 = new LongOption();
    private final LongOption mid2 = new LongOption();
    @Override@SuppressWarnings("deprecation") public void reset() {
        this.keycode.setNull();
        this.mid1.setNull();
        this.mid2.setNull();
    }
    @Override@SuppressWarnings("deprecation") public void copyFrom(Middata other) {
        this.keycode.copyFrom(other.keycode);
        this.mid1.copyFrom(other.mid1);
        this.mid2.copyFrom(other.mid2);
    }
    /**
     * keycodeを返す。
     * @return keycode
     * @throws NullPointerException keycodeの値が<code>null</code>である場合
     */
    public int getKeycode() {
        return this.keycode.get();
    }
    /**
     * keycodeを設定する。
     * @param value 設定する値
     */
    @SuppressWarnings("deprecation") public void setKeycode(int value) {
        this.keycode.modify(value);
    }
    /**
     * <code>null</code>を許すkeycodeを返す。
     * @return keycode
     */
    public IntOption getKeycodeOption() {
        return this.keycode;
    }
    /**
     * keycodeを設定する。
     * @param option 設定する値、<code>null</code>の場合にはこのプロパティが<code>null</code>を表すようになる
     */
    @SuppressWarnings("deprecation") public void setKeycodeOption(IntOption option) {
        this.keycode.copyFrom(option);
    }
    /**
     * mid1を返す。
     * @return mid1
     * @throws NullPointerException mid1の値が<code>null</code>である場合
     */
    public long getMid1() {
        return this.mid1.get();
    }
    /**
     * mid1を設定する。
     * @param value 設定する値
     */
    @SuppressWarnings("deprecation") public void setMid1(long value) {
        this.mid1.modify(value);
    }
    /**
     * <code>null</code>を許すmid1を返す。
     * @return mid1
     */
    public LongOption getMid1Option() {
        return this.mid1;
    }
    /**
     * mid1を設定する。
     * @param option 設定する値、<code>null</code>の場合にはこのプロパティが<code>null</code>を表すようになる
     */
    @SuppressWarnings("deprecation") public void setMid1Option(LongOption option) {
        this.mid1.copyFrom(option);
    }
    /**
     * mid2を返す。
     * @return mid2
     * @throws NullPointerException mid2の値が<code>null</code>である場合
     */
    public long getMid2() {
        return this.mid2.get();
    }
    /**
     * mid2を設定する。
     * @param value 設定する値
     */
    @SuppressWarnings("deprecation") public void setMid2(long value) {
        this.mid2.modify(value);
    }
    /**
     * <code>null</code>を許すmid2を返す。
     * @return mid2
     */
    public LongOption getMid2Option() {
        return this.mid2;
    }
    /**
     * mid2を設定する。
     * @param option 設定する値、<code>null</code>の場合にはこのプロパティが<code>null</code>を表すようになる
     */
    @SuppressWarnings("deprecation") public void setMid2Option(LongOption option) {
        this.mid2.copyFrom(option);
    }
    @Override public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("{");
        result.append("class=middata");
        result.append(", keycode=");
        result.append(this.keycode);
        result.append(", mid1=");
        result.append(this.mid1);
        result.append(", mid2=");
        result.append(this.mid2);
        result.append("}");
        return result.toString();
    }
    @Override public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + keycode.hashCode();
        result = prime * result + mid1.hashCode();
        result = prime * result + mid2.hashCode();
        return result;
    }
    @Override public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj == null) {
            return false;
        }
        if(this.getClass() != obj.getClass()) {
            return false;
        }
        Middata other = (Middata) obj;
        if(this.keycode.equals(other.keycode) == false) {
            return false;
        }
        if(this.mid1.equals(other.mid1) == false) {
            return false;
        }
        if(this.mid2.equals(other.mid2) == false) {
            return false;
        }
        return true;
    }
    @Override public void write(DataOutput out) throws IOException {
        keycode.write(out);
        mid1.write(out);
        mid2.write(out);
    }
    @Override public void readFields(DataInput in) throws IOException {
        keycode.readFields(in);
        mid1.readFields(in);
        mid2.readFields(in);
    }
}
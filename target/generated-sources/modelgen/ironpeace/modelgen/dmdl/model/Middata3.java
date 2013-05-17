package ironpeace.modelgen.dmdl.model;
import com.asakusafw.runtime.model.DataModel;
import com.asakusafw.runtime.model.DataModelKind;
import com.asakusafw.runtime.model.ModelInputLocation;
import com.asakusafw.runtime.model.ModelOutputLocation;
import com.asakusafw.runtime.model.PropertyOrder;
import com.asakusafw.runtime.value.IntOption;
import com.asakusafw.runtime.value.LongOption;
import com.asakusafw.vocabulary.model.Joined;
import com.asakusafw.vocabulary.model.Key;
import ironpeace.modelgen.dmdl.io.Middata3Input;
import ironpeace.modelgen.dmdl.io.Middata3Output;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.apache.hadoop.io.Writable;
/**
 * middata3を表すデータモデルクラス。
 */
@DataModelKind("DMDL")@Joined(terms = {@Joined.Term(source = OriginalData.class, mappings = {@Joined.Mapping(source = 
                "keycode", destination = "keycode"),@Joined.Mapping(source = "data1", destination = "data1"),@Joined.
                Mapping(source = "data2", destination = "data2"),@Joined.Mapping(source = "data3", destination = "data3"
                )}, shuffle = @Key(group = {"keycode"})),@Joined.Term(source = Middata.class, mappings = {@Joined.
                Mapping(source = "keycode", destination = "keycode"),@Joined.Mapping(source = "mid1", destination = 
                "mid1"),@Joined.Mapping(source = "mid2", destination = "mid2")}, shuffle = @Key(group = {"keycode"}))})@
        ModelInputLocation(Middata3Input.class)@ModelOutputLocation(Middata3Output.class)@PropertyOrder({"keycode", 
            "data1", "data2", "data3", "mid1", "mid2"}) public class Middata3 implements DataModel<Middata3>, Writable {
    private final IntOption keycode = new IntOption();
    private final LongOption data1 = new LongOption();
    private final LongOption data2 = new LongOption();
    private final LongOption data3 = new LongOption();
    private final LongOption mid1 = new LongOption();
    private final LongOption mid2 = new LongOption();
    @Override@SuppressWarnings("deprecation") public void reset() {
        this.keycode.setNull();
        this.data1.setNull();
        this.data2.setNull();
        this.data3.setNull();
        this.mid1.setNull();
        this.mid2.setNull();
    }
    @Override@SuppressWarnings("deprecation") public void copyFrom(Middata3 other) {
        this.keycode.copyFrom(other.keycode);
        this.data1.copyFrom(other.data1);
        this.data2.copyFrom(other.data2);
        this.data3.copyFrom(other.data3);
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
     * data1を返す。
     * @return data1
     * @throws NullPointerException data1の値が<code>null</code>である場合
     */
    public long getData1() {
        return this.data1.get();
    }
    /**
     * data1を設定する。
     * @param value 設定する値
     */
    @SuppressWarnings("deprecation") public void setData1(long value) {
        this.data1.modify(value);
    }
    /**
     * <code>null</code>を許すdata1を返す。
     * @return data1
     */
    public LongOption getData1Option() {
        return this.data1;
    }
    /**
     * data1を設定する。
     * @param option 設定する値、<code>null</code>の場合にはこのプロパティが<code>null</code>を表すようになる
     */
    @SuppressWarnings("deprecation") public void setData1Option(LongOption option) {
        this.data1.copyFrom(option);
    }
    /**
     * data2を返す。
     * @return data2
     * @throws NullPointerException data2の値が<code>null</code>である場合
     */
    public long getData2() {
        return this.data2.get();
    }
    /**
     * data2を設定する。
     * @param value 設定する値
     */
    @SuppressWarnings("deprecation") public void setData2(long value) {
        this.data2.modify(value);
    }
    /**
     * <code>null</code>を許すdata2を返す。
     * @return data2
     */
    public LongOption getData2Option() {
        return this.data2;
    }
    /**
     * data2を設定する。
     * @param option 設定する値、<code>null</code>の場合にはこのプロパティが<code>null</code>を表すようになる
     */
    @SuppressWarnings("deprecation") public void setData2Option(LongOption option) {
        this.data2.copyFrom(option);
    }
    /**
     * data3を返す。
     * @return data3
     * @throws NullPointerException data3の値が<code>null</code>である場合
     */
    public long getData3() {
        return this.data3.get();
    }
    /**
     * data3を設定する。
     * @param value 設定する値
     */
    @SuppressWarnings("deprecation") public void setData3(long value) {
        this.data3.modify(value);
    }
    /**
     * <code>null</code>を許すdata3を返す。
     * @return data3
     */
    public LongOption getData3Option() {
        return this.data3;
    }
    /**
     * data3を設定する。
     * @param option 設定する値、<code>null</code>の場合にはこのプロパティが<code>null</code>を表すようになる
     */
    @SuppressWarnings("deprecation") public void setData3Option(LongOption option) {
        this.data3.copyFrom(option);
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
        result.append("class=middata3");
        result.append(", keycode=");
        result.append(this.keycode);
        result.append(", data1=");
        result.append(this.data1);
        result.append(", data2=");
        result.append(this.data2);
        result.append(", data3=");
        result.append(this.data3);
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
        result = prime * result + data1.hashCode();
        result = prime * result + data2.hashCode();
        result = prime * result + data3.hashCode();
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
        Middata3 other = (Middata3) obj;
        if(this.keycode.equals(other.keycode) == false) {
            return false;
        }
        if(this.data1.equals(other.data1) == false) {
            return false;
        }
        if(this.data2.equals(other.data2) == false) {
            return false;
        }
        if(this.data3.equals(other.data3) == false) {
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
        data1.write(out);
        data2.write(out);
        data3.write(out);
        mid1.write(out);
        mid2.write(out);
    }
    @Override public void readFields(DataInput in) throws IOException {
        keycode.readFields(in);
        data1.readFields(in);
        data2.readFields(in);
        data3.readFields(in);
        mid1.readFields(in);
        mid2.readFields(in);
    }
}
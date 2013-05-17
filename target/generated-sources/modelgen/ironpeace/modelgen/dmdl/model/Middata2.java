package ironpeace.modelgen.dmdl.model;
import com.asakusafw.runtime.model.DataModel;
import com.asakusafw.runtime.model.DataModelKind;
import com.asakusafw.runtime.model.ModelInputLocation;
import com.asakusafw.runtime.model.ModelOutputLocation;
import com.asakusafw.runtime.model.PropertyOrder;
import com.asakusafw.runtime.value.IntOption;
import com.asakusafw.runtime.value.StringOption;
import ironpeace.modelgen.dmdl.io.Middata2Input;
import ironpeace.modelgen.dmdl.io.Middata2Output;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
/**
 * middata2を表すデータモデルクラス。
 */
@DataModelKind("DMDL")@ModelInputLocation(Middata2Input.class)@ModelOutputLocation(Middata2Output.class)@PropertyOrder({
            "keycode", "alert1", "alert2"}) public class Middata2 implements DataModel<Middata2>, Writable {
    private final IntOption keycode = new IntOption();
    private final StringOption alert1 = new StringOption();
    private final StringOption alert2 = new StringOption();
    @Override@SuppressWarnings("deprecation") public void reset() {
        this.keycode.setNull();
        this.alert1.setNull();
        this.alert2.setNull();
    }
    @Override@SuppressWarnings("deprecation") public void copyFrom(Middata2 other) {
        this.keycode.copyFrom(other.keycode);
        this.alert1.copyFrom(other.alert1);
        this.alert2.copyFrom(other.alert2);
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
     * alert1を返す。
     * @return alert1
     * @throws NullPointerException alert1の値が<code>null</code>である場合
     */
    public Text getAlert1() {
        return this.alert1.get();
    }
    /**
     * alert1を設定する。
     * @param value 設定する値
     */
    @SuppressWarnings("deprecation") public void setAlert1(Text value) {
        this.alert1.modify(value);
    }
    /**
     * <code>null</code>を許すalert1を返す。
     * @return alert1
     */
    public StringOption getAlert1Option() {
        return this.alert1;
    }
    /**
     * alert1を設定する。
     * @param option 設定する値、<code>null</code>の場合にはこのプロパティが<code>null</code>を表すようになる
     */
    @SuppressWarnings("deprecation") public void setAlert1Option(StringOption option) {
        this.alert1.copyFrom(option);
    }
    /**
     * alert2を返す。
     * @return alert2
     * @throws NullPointerException alert2の値が<code>null</code>である場合
     */
    public Text getAlert2() {
        return this.alert2.get();
    }
    /**
     * alert2を設定する。
     * @param value 設定する値
     */
    @SuppressWarnings("deprecation") public void setAlert2(Text value) {
        this.alert2.modify(value);
    }
    /**
     * <code>null</code>を許すalert2を返す。
     * @return alert2
     */
    public StringOption getAlert2Option() {
        return this.alert2;
    }
    /**
     * alert2を設定する。
     * @param option 設定する値、<code>null</code>の場合にはこのプロパティが<code>null</code>を表すようになる
     */
    @SuppressWarnings("deprecation") public void setAlert2Option(StringOption option) {
        this.alert2.copyFrom(option);
    }
    @Override public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("{");
        result.append("class=middata2");
        result.append(", keycode=");
        result.append(this.keycode);
        result.append(", alert1=");
        result.append(this.alert1);
        result.append(", alert2=");
        result.append(this.alert2);
        result.append("}");
        return result.toString();
    }
    @Override public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + keycode.hashCode();
        result = prime * result + alert1.hashCode();
        result = prime * result + alert2.hashCode();
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
        Middata2 other = (Middata2) obj;
        if(this.keycode.equals(other.keycode) == false) {
            return false;
        }
        if(this.alert1.equals(other.alert1) == false) {
            return false;
        }
        if(this.alert2.equals(other.alert2) == false) {
            return false;
        }
        return true;
    }
    /**
     * alert1を返す。
     * @return alert1
     * @throws NullPointerException alert1の値が<code>null</code>である場合
     */
    public String getAlert1AsString() {
        return this.alert1.getAsString();
    }
    /**
     * alert1を設定する。
     * @param alert10 設定する値
     */
    @SuppressWarnings("deprecation") public void setAlert1AsString(String alert10) {
        this.alert1.modify(alert10);
    }
    /**
     * alert2を返す。
     * @return alert2
     * @throws NullPointerException alert2の値が<code>null</code>である場合
     */
    public String getAlert2AsString() {
        return this.alert2.getAsString();
    }
    /**
     * alert2を設定する。
     * @param alert20 設定する値
     */
    @SuppressWarnings("deprecation") public void setAlert2AsString(String alert20) {
        this.alert2.modify(alert20);
    }
    @Override public void write(DataOutput out) throws IOException {
        keycode.write(out);
        alert1.write(out);
        alert2.write(out);
    }
    @Override public void readFields(DataInput in) throws IOException {
        keycode.readFields(in);
        alert1.readFields(in);
        alert2.readFields(in);
    }
}
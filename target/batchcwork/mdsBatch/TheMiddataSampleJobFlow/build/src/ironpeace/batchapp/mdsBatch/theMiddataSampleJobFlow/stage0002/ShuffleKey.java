package ironpeace.batchapp.mdsBatch.theMiddataSampleJobFlow.stage0002;
import com.asakusafw.runtime.flow.SegmentedWritable;
import com.asakusafw.runtime.value.IntOption;
import ironpeace.modelgen.dmdl.model.Middata2;
import ironpeace.modelgen.dmdl.model.Middata3;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
/**
 * ステージ#2シャッフルで利用するKeyクラス。
 */
@SuppressWarnings("deprecation") public final class ShuffleKey implements SegmentedWritable {
    /**
     * シャッフルフェーズを通した演算子のポート番号。
     */
    public int portId = -1;
    @Override public int getSegmentId() {
        return this.portId;
    }
    /**
     * MiddleDataSampleOperator.joinMid3AndMid2#mid3が利用するキー (keycode)
     */
    public IntOption groupElem0Term1 = new IntOption();
    /**
     * MiddleDataSampleOperator.joinMid3AndMid2#mid3のキーの元になるモデルオブジェクトを設定する
     * @param source 設定するモデルオブジェクト
     */
    public void setPort1(Middata3 source) {
        this.portId = 1;
        this.groupElem0Term1.copyFrom(source.getKeycodeOption());
    }
    /**
     * MiddleDataSampleOperator.joinMid3AndMid2#mid2のキーの元になるモデルオブジェクトを設定する
     * @param source 設定するモデルオブジェクト
     */
    public void setPort2(Middata2 source) {
        this.portId = 2;
        this.groupElem0Term1.copyFrom(source.getKeycodeOption());
    }
    /**
     * 指定のキーのグループ情報をこのオブジェクトに複製する
     * @param original コピーするキー
     */
    public void copyGroupFrom(ShuffleKey original) {
        this.portId = original.portId;
        if(this.portId < 0) {
            return;
        }
        switch(this.portId) {
            case 1:
            case 2:
                this.groupElem0Term1.copyFrom(original.groupElem0Term1);
                break;
            default:
                throw new AssertionError(this.portId = original.portId);
        }
    }
    @Override public void write(DataOutput out) throws IOException {
        switch(this.portId) {
            case 1:
                out.writeInt(1);
                this.groupElem0Term1.write(out);
                break;
            case 2:
                out.writeInt(2);
                this.groupElem0Term1.write(out);
                break;
            default:
                throw new AssertionError(this.portId);
        }
    }
    @Override public void readFields(DataInput in) throws IOException {
        this.portId = in.readInt();
        switch(this.portId) {
            case 1:
                this.groupElem0Term1.readFields(in);
                break;
            case 2:
                this.groupElem0Term1.readFields(in);
                break;
            default:
                throw new AssertionError(this.portId);
        }
    }
}
package ironpeace.batchapp.mdsBatch.theMiddataSampleJobFlow.stage0001;
import com.asakusafw.runtime.flow.SegmentedWritable;
import ironpeace.modelgen.dmdl.model.Middata;
import ironpeace.modelgen.dmdl.model.OriginalData;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
/**
 * ステージ#1シャッフルで利用する値クラス。
 */
@SuppressWarnings("deprecation") public final class ShuffleValue implements SegmentedWritable {
    /**
     * セグメント番号。
     */
    public int segmentId = -1;
    @Override public int getSegmentId() {
        return this.segmentId;
    }
    /**
     * MiddleDataSampleOperator.joinOriginalAndMid#orignalが利用するモデル (1)。
     */
    public OriginalData port0001 = new OriginalData();
    /**
     * MiddleDataSampleOperator.joinOriginalAndMid#midが利用するモデル (2)。
     */
    public Middata port0002 = new Middata();
    /**
     * MiddleDataSampleOperator.joinOriginalAndMid#orignalのモデルオブジェクトを返す。
     */
    public OriginalData getPort1() {
        if(this.segmentId != 1) throw new AssertionError();
        return this.port0001;
    }
    /**
     * MiddleDataSampleOperator.joinOriginalAndMid#orignalで使用するモデルオブジェクトを設定する。
     * @param model 設定するモデルオブジェクト
     */
    public void setPort1(OriginalData model) {
        this.segmentId = 1;
        this.port0001.copyFrom(model);
    }
    /**
     * MiddleDataSampleOperator.joinOriginalAndMid#midのモデルオブジェクトを返す。
     */
    public Middata getPort2() {
        if(this.segmentId != 2) throw new AssertionError();
        return this.port0002;
    }
    /**
     * MiddleDataSampleOperator.joinOriginalAndMid#midで使用するモデルオブジェクトを設定する。
     * @param model 設定するモデルオブジェクト
     */
    public void setPort2(Middata model) {
        this.segmentId = 2;
        this.port0002.copyFrom(model);
    }
    @Override public void write(DataOutput out) throws IOException {
        switch(this.segmentId) {
            case 1:
                out.writeInt(1);
                this.port0001.write(out);
                break;
            case 2:
                out.writeInt(2);
                this.port0002.write(out);
                break;
            default:
                throw new AssertionError(this.segmentId);
        }
    }
    @Override public void readFields(DataInput in) throws IOException {
        this.segmentId = in.readInt();
        switch(this.segmentId) {
            case 1:
                this.port0001.readFields(in);
                break;
            case 2:
                this.port0002.readFields(in);
                break;
            default:
                throw new AssertionError(this.segmentId);
        }
    }
}
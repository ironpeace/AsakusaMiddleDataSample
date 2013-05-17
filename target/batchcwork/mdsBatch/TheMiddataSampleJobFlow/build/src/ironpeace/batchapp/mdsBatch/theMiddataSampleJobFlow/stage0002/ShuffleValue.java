package ironpeace.batchapp.mdsBatch.theMiddataSampleJobFlow.stage0002;
import com.asakusafw.runtime.flow.SegmentedWritable;
import ironpeace.modelgen.dmdl.model.Middata2;
import ironpeace.modelgen.dmdl.model.Middata3;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
/**
 * ステージ#2シャッフルで利用する値クラス。
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
     * MiddleDataSampleOperator.joinMid3AndMid2#mid3が利用するモデル (1)。
     */
    public Middata3 port0001 = new Middata3();
    /**
     * MiddleDataSampleOperator.joinMid3AndMid2#mid2が利用するモデル (2)。
     */
    public Middata2 port0002 = new Middata2();
    /**
     * MiddleDataSampleOperator.joinMid3AndMid2#mid3のモデルオブジェクトを返す。
     */
    public Middata3 getPort1() {
        if(this.segmentId != 1) throw new AssertionError();
        return this.port0001;
    }
    /**
     * MiddleDataSampleOperator.joinMid3AndMid2#mid3で使用するモデルオブジェクトを設定する。
     * @param model 設定するモデルオブジェクト
     */
    public void setPort1(Middata3 model) {
        this.segmentId = 1;
        this.port0001.copyFrom(model);
    }
    /**
     * MiddleDataSampleOperator.joinMid3AndMid2#mid2のモデルオブジェクトを返す。
     */
    public Middata2 getPort2() {
        if(this.segmentId != 2) throw new AssertionError();
        return this.port0002;
    }
    /**
     * MiddleDataSampleOperator.joinMid3AndMid2#mid2で使用するモデルオブジェクトを設定する。
     * @param model 設定するモデルオブジェクト
     */
    public void setPort2(Middata2 model) {
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
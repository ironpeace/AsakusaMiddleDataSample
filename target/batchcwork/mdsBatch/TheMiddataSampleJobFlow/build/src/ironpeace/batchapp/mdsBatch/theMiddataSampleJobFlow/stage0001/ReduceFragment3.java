package ironpeace.batchapp.mdsBatch.theMiddataSampleJobFlow.stage0001;
import com.asakusafw.runtime.core.Result;
import ironpeace.modelgen.dmdl.model.Middata;
import ironpeace.modelgen.dmdl.model.Middata3;
import ironpeace.modelgen.dmdl.model.OriginalData;
/**
 * {@code 
         * [orignal->MiddleDataSampleOperator.joinOriginalAndMid(operator#1393000393), mid->MiddleDataSampleOperator.joinOriginalAndMid(operator#1393000393)]
         * }の処理を担当するマッププログラムの断片。
 */
@SuppressWarnings("deprecation") public final class ReduceFragment3 extends com.asakusafw.runtime.flow.Rendezvous<
        ShuffleValue> {
    private final Result<Middata3> joined;
    private final Result<Middata> missed;
    private boolean sawMaster;
    private OriginalData cache = new OriginalData();
    private Middata3 cache0 = new Middata3();
    /**
     * インスタンスを生成する。
     * @param joined {@code MiddleDataSampleOperator.joinOriginalAndMid#joined}への出力
     * @param missed {@code MiddleDataSampleOperator.joinOriginalAndMid#missed}への出力
     */
    public ReduceFragment3(Result<Middata3> joined, Result<Middata> missed) {
        this.joined = joined;
        this.missed = missed;
    }
    @Override public void process(ShuffleValue value) {
        switch(value.getSegmentId()) {
            case 1:
                this.process0001(value.getPort1());
                break;
            case 2:
                this.process0002(value.getPort2());
                break;
            default:
                throw new AssertionError(value);
        }
    }
    @Override public void begin() {
        this.sawMaster = false;
    }
    @Override public void end() {
    }
    private void process0001(OriginalData value) {
        if(this.sawMaster == false) {
            this.cache.copyFrom(value);
            this.sawMaster = true;
        }
    }
    private void process0002(Middata value) {
        if(this.sawMaster) {
            this.cache0.reset();
            this.cache0.setKeycodeOption(this.cache.getKeycodeOption());
            this.cache0.setData1Option(this.cache.getData1Option());
            this.cache0.setData2Option(this.cache.getData2Option());
            this.cache0.setData3Option(this.cache.getData3Option());
            this.cache0.setMid1Option(value.getMid1Option());
            this.cache0.setMid2Option(value.getMid2Option());
            this.joined.add(this.cache0);
        }
        else {
            this.missed.add(value);
        }
    }
}
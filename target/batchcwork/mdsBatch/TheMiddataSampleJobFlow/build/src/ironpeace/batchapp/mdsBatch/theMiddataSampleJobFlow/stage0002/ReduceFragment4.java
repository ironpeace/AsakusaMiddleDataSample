package ironpeace.batchapp.mdsBatch.theMiddataSampleJobFlow.stage0002;
import com.asakusafw.runtime.core.Result;
import ironpeace.modelgen.dmdl.model.Middata2;
import ironpeace.modelgen.dmdl.model.Middata3;
import ironpeace.modelgen.dmdl.model.PreResult;
/**
 * {@code 
         * [mid3->MiddleDataSampleOperator.joinMid3AndMid2(operator#40515936), mid2->MiddleDataSampleOperator.joinMid3AndMid2(operator#40515936)]
         * }の処理を担当するマッププログラムの断片。
 */
@SuppressWarnings("deprecation") public final class ReduceFragment4 extends com.asakusafw.runtime.flow.Rendezvous<
        ShuffleValue> {
    private final Result<PreResult> joined;
    private final Result<Middata2> missed;
    private boolean sawMaster;
    private Middata3 cache = new Middata3();
    private PreResult cache0 = new PreResult();
    /**
     * インスタンスを生成する。
     * @param joined {@code MiddleDataSampleOperator.joinMid3AndMid2#joined}への出力
     * @param missed {@code MiddleDataSampleOperator.joinMid3AndMid2#missed}への出力
     */
    public ReduceFragment4(Result<PreResult> joined, Result<Middata2> missed) {
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
    private void process0001(Middata3 value) {
        if(this.sawMaster == false) {
            this.cache.copyFrom(value);
            this.sawMaster = true;
        }
    }
    private void process0002(Middata2 value) {
        if(this.sawMaster) {
            this.cache0.reset();
            this.cache0.setKeycodeOption(this.cache.getKeycodeOption());
            this.cache0.setData1Option(this.cache.getData1Option());
            this.cache0.setData2Option(this.cache.getData2Option());
            this.cache0.setData3Option(this.cache.getData3Option());
            this.cache0.setMid1Option(this.cache.getMid1Option());
            this.cache0.setMid2Option(this.cache.getMid2Option());
            this.cache0.setAlert1Option(value.getAlert1Option());
            this.cache0.setAlert2Option(value.getAlert2Option());
            this.joined.add(this.cache0);
        }
        else {
            this.missed.add(value);
        }
    }
}
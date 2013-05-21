package ironpeace.batchapp.mdsBatch.theMiddataSampleJobFlow.stage0001;
import com.asakusafw.runtime.core.Result;
import ironpeace.modelgen.dmdl.model.Middata;
import ironpeace.modelgen.dmdl.model.OriginalData;
import ironpeace.operator.MiddleDataSampleOperatorImpl;
/**
 * {@code [orignal->MiddleDataSampleOperator.convertToMidFromOriginal(operator#631120219)]}の処理を担当するマッププログラムの断片。
 */
@SuppressWarnings("deprecation") public final class MapFragment2 implements Result<OriginalData> {
    private final Result<OriginalData> original;
    private final Result<Middata> out;
    private MiddleDataSampleOperatorImpl op = new MiddleDataSampleOperatorImpl();
    /**
     * インスタンスを生成する。
     * @param original {@code MiddleDataSampleOperator.convertToMidFromOriginal#original}への出力
     * @param out {@code MiddleDataSampleOperator.convertToMidFromOriginal#out}への出力
     */
    public MapFragment2(Result<OriginalData> original, Result<Middata> out) {
        this.original = original;
        this.out = out;
    }
    @Override public void add(OriginalData result) {
        Middata v = this.op.convertToMidFromOriginal(result);
        this.original.add(result);
        this.out.add(v);
    }
}
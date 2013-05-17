package ironpeace.batchapp.mdsBatch.theMiddataSampleJobFlow.stage0002;
import com.asakusafw.runtime.core.Result;
import ironpeace.modelgen.dmdl.model.Middata2;
import ironpeace.modelgen.dmdl.model.OriginalData;
import ironpeace.operator.MiddleDataSampleOperatorImpl;
/**
 * {@code [orignal->MiddleDataSampleOperator.convertToMid2FromOriginalAndMid(operator#1202547531)]}の処理を担当するマッププログラムの断片。
 */
@SuppressWarnings("deprecation") public final class MapFragment1 implements Result<OriginalData> {
    private final Result<OriginalData> original;
    private final Result<Middata2> out;
    private MiddleDataSampleOperatorImpl op = new MiddleDataSampleOperatorImpl();
    /**
     * インスタンスを生成する。
     * @param original {@code MiddleDataSampleOperator.convertToMid2FromOriginalAndMid#original}への出力
     * @param out {@code MiddleDataSampleOperator.convertToMid2FromOriginalAndMid#out}への出力
     */
    public MapFragment1(Result<OriginalData> original, Result<Middata2> out) {
        this.original = original;
        this.out = out;
    }
    @Override public void add(OriginalData result) {
        Middata2 v = this.op.convertToMid2FromOriginalAndMid(result);
        this.original.add(result);
        this.out.add(v);
    }
}
package ironpeace.batchapp.mdsBatch.theMiddataSampleJobFlow.stage0002;
import com.asakusafw.runtime.core.Result;
import ironpeace.modelgen.dmdl.model.Middata2;
import ironpeace.modelgen.dmdl.model.Middata3;
import ironpeace.operator.MiddleDataSampleOperatorImpl;
/**
 * {@code [mid3->MiddleDataSampleOperator.convertToMid2FromMid3(operator#1879721096)]}の処理を担当するマッププログラムの断片。
 */
@SuppressWarnings("deprecation") public final class MapFragment2 implements Result<Middata3> {
    private final Result<Middata3> original;
    private final Result<Middata2> out;
    private MiddleDataSampleOperatorImpl op = new MiddleDataSampleOperatorImpl();
    /**
     * インスタンスを生成する。
     * @param original {@code MiddleDataSampleOperator.convertToMid2FromMid3#original}への出力
     * @param out {@code MiddleDataSampleOperator.convertToMid2FromMid3#out}への出力
     */
    public MapFragment2(Result<Middata3> original, Result<Middata2> out) {
        this.original = original;
        this.out = out;
    }
    @Override public void add(Middata3 result) {
        Middata2 v = this.op.convertToMid2FromMid3(result);
        this.original.add(result);
        this.out.add(v);
    }
}
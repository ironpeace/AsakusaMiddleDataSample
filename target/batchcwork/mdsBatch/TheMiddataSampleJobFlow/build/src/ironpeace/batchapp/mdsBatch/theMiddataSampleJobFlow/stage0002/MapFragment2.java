package ironpeace.batchapp.mdsBatch.theMiddataSampleJobFlow.stage0002;
import com.asakusafw.runtime.core.Result;
import ironpeace.modelgen.dmdl.model.Middata3;
/**
 * {@code [in->padding(pseud#2035159355)]}の処理を担当するマッププログラムの断片。
 */
@SuppressWarnings("deprecation") public final class MapFragment2 implements Result<Middata3> {
    private final Result<Middata3> out;
    /**
     * インスタンスを生成する。
     * @param out {@code padding#out}への出力
     */
    public MapFragment2(Result<Middata3> out) {
        this.out = out;
    }
    @Override public void add(Middata3 result) {
        this.out.add(result);
    }
}
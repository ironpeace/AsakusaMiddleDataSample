package ironpeace.batchapp.mdsBatch.theMiddataSampleJobFlow.stage0001;
import com.asakusafw.runtime.core.Result;
import ironpeace.modelgen.dmdl.model.OriginalData;
/**
 * {@code [in->padding(pseud#1654792719)]}の処理を担当するマッププログラムの断片。
 */
@SuppressWarnings("deprecation") public final class MapFragment2 implements Result<OriginalData> {
    private final Result<OriginalData> out;
    /**
     * インスタンスを生成する。
     * @param out {@code padding#out}への出力
     */
    public MapFragment2(Result<OriginalData> out) {
        this.out = out;
    }
    @Override public void add(OriginalData result) {
        this.out.add(result);
    }
}
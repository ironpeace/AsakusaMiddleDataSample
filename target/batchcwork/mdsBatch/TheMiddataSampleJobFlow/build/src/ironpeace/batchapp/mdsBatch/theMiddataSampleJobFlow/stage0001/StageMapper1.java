package ironpeace.batchapp.mdsBatch.theMiddataSampleJobFlow.stage0001;
import com.asakusafw.runtime.flow.RuntimeResourceManager;
import com.asakusafw.runtime.flow.VoidResult;
import ironpeace.modelgen.dmdl.model.OriginalData;
import java.io.IOException;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Mapper;
/**
 * {@code 
         * [in->padding(pseud#1654792719){owner=FlowBlock&#64;1351281524}, orignal->MiddleDataSampleOperator.convertToMidFromOriginal(operator#40515936){owner=FlowBlock&#64;1351281524}]
         * }の処理を担当するマッププログラム。
 */
@SuppressWarnings("deprecation") public final class StageMapper1 extends Mapper<NullWritable, OriginalData, ShuffleKey, 
        ShuffleValue> {
    private OriginalData cache = new OriginalData();
    private RuntimeResourceManager runtimeResourceManager;
    private MapFragment1 line0;
    private MapFragment2 line;
    @Override public void setup(Context context) throws IOException, InterruptedException {
        this.runtimeResourceManager = new RuntimeResourceManager(context.getConfiguration());
        this.runtimeResourceManager.setup();
        final MapOutputFragment1 shuffle = new MapOutputFragment1(context);
        this.line = new MapFragment2(shuffle);
        final MapOutputFragment2 shuffle0 = new MapOutputFragment2(context);
        this.line0 = new MapFragment1(new VoidResult<OriginalData>(), shuffle0);
    }
    @Override public void cleanup(Context context) throws IOException, InterruptedException {
        this.runtimeResourceManager.cleanup();
        this.runtimeResourceManager = null;
        this.line0 = null;
        this.line = null;
    }
    @Override public void run(Context context) throws IOException, InterruptedException {
        this.setup(context);
        while(context.nextKeyValue()) {
            cache.copyFrom(context.getCurrentValue());
            this.line.add(cache);
            cache.copyFrom(context.getCurrentValue());
            this.line0.add(cache);
        }
        this.cleanup(context);
    }
}
package ironpeace.batchapp.mdsBatch.theMiddataSampleJobFlow.stage0002;
import com.asakusafw.runtime.flow.RuntimeResourceManager;
import com.asakusafw.runtime.flow.VoidResult;
import ironpeace.modelgen.dmdl.model.Middata3;
import java.io.IOException;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Mapper;
/**
 * {@code 
         * [mid3->MiddleDataSampleOperator.convertToMid2FromMid3(operator#1879721096){owner=FlowBlock&#64;1130907398}, in->padding(pseud#1301353792){owner=FlowBlock&#64;1130907398}]
         * }の処理を担当するマッププログラム。
 */
@SuppressWarnings("deprecation") public final class StageMapper1 extends Mapper<NullWritable, Middata3, ShuffleKey, 
        ShuffleValue> {
    private Middata3 cache = new Middata3();
    private RuntimeResourceManager runtimeResourceManager;
    private MapFragment1 line0;
    private MapFragment2 line;
    @Override public void setup(Context context) throws IOException, InterruptedException {
        this.runtimeResourceManager = new RuntimeResourceManager(context.getConfiguration());
        this.runtimeResourceManager.setup();
        final MapOutputFragment2 shuffle0 = new MapOutputFragment2(context);
        this.line = new MapFragment2(new VoidResult<Middata3>(), shuffle0);
        final MapOutputFragment1 shuffle = new MapOutputFragment1(context);
        this.line0 = new MapFragment1(shuffle);
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
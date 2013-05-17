package ironpeace.batch;

import ironpeace.jobflow.MiddataSampleJobFlow;

import com.asakusafw.vocabulary.batch.Batch;
import com.asakusafw.vocabulary.batch.BatchDescription;

@Batch(name="mdsBatch")
public class MiddleDataSampleBatch extends BatchDescription {

	@Override
	protected void describe() {
		run(MiddataSampleJobFlow.class).soon();
	}

}

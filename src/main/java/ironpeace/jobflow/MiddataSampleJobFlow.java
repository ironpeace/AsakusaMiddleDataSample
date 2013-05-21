package ironpeace.jobflow;

import ironpeace.modelgen.dmdl.model.OriginalData;
import ironpeace.modelgen.dmdl.model.Result;
import ironpeace.operator.MiddleDataSampleOperatorFactory;
import ironpeace.operator.MiddleDataSampleOperatorFactory.ConvertToMid2FromMid3;
import ironpeace.operator.MiddleDataSampleOperatorFactory.ConvertToMidFromOriginal;
import ironpeace.operator.MiddleDataSampleOperatorFactory.ConvertToResult;
import ironpeace.operator.MiddleDataSampleOperatorFactory.JoinMid3AndMid2;
import ironpeace.operator.MiddleDataSampleOperatorFactory.JoinOriginalAndMid;

import com.asakusafw.vocabulary.flow.Export;
import com.asakusafw.vocabulary.flow.FlowDescription;
import com.asakusafw.vocabulary.flow.Import;
import com.asakusafw.vocabulary.flow.In;
import com.asakusafw.vocabulary.flow.JobFlow;
import com.asakusafw.vocabulary.flow.Out;
import com.asakusafw.vocabulary.flow.util.CoreOperatorFactory;

@JobFlow(name = "TheMiddataSampleJobFlow")
public class MiddataSampleJobFlow extends FlowDescription {
	
	final In<OriginalData> originaldata;
	final Out<Result> result;
	final CoreOperatorFactory coreOp = new CoreOperatorFactory();
	
	public MiddataSampleJobFlow (
			@Import(name="orignaldata", description=OriginaldataFromCsv.class)
			In<OriginalData> originaldata,
			@Export(name="result", description=ResultToCsv.class)
			Out<Result> result
			) {
		this.originaldata = originaldata;
		this.result = result;
	}

	@Override
	protected void describe() {
		MiddleDataSampleOperatorFactory operators
			= new MiddleDataSampleOperatorFactory();
		
		ConvertToMidFromOriginal convertedMid
			= operators.convertToMidFromOriginal(originaldata);
		coreOp.stop(convertedMid.original);
		
		JoinOriginalAndMid joinedMid3
			= operators.joinOriginalAndMid(originaldata, convertedMid.out);
		coreOp.stop(joinedMid3.missed);

		ConvertToMid2FromMid3 convertedMid2
			= operators.convertToMid2FromMid3(joinedMid3.joined);
		coreOp.stop(convertedMid2.original);
		
		JoinMid3AndMid2 joinedPreResult
			= operators.joinMid3AndMid2(joinedMid3.joined, convertedMid2.out);
		coreOp.stop(joinedPreResult.missed);
		
		ConvertToResult convertedResult
			= operators.convertToResult(joinedPreResult.joined);
		coreOp.stop(convertedResult.original);
		
		result.add(convertedResult.out);
	}

}

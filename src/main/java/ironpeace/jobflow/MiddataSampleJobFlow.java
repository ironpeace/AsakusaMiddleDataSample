package ironpeace.jobflow;

import ironpeace.modelgen.dmdl.model.OriginalData;
import ironpeace.modelgen.dmdl.model.Result;
import ironpeace.operator.MiddleDataSampleOperatorFactory;
import ironpeace.operator.MiddleDataSampleOperatorFactory.ConvertToMid2FromOriginalAndMid;
import ironpeace.operator.MiddleDataSampleOperatorFactory.ConvertToMidFromOriginal;
import ironpeace.operator.MiddleDataSampleOperatorFactory.ConvertToResult;
import ironpeace.operator.MiddleDataSampleOperatorFactory.JoinData;
import ironpeace.operator.MiddleDataSampleOperatorFactory.JoinData2;

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
		MiddleDataSampleOperatorFactory operators = new MiddleDataSampleOperatorFactory();
		
		ConvertToMidFromOriginal convert = operators.convertToMidFromOriginal(originaldata);
		coreOp.stop(convert.original);
		
		ConvertToMid2FromOriginalAndMid convert2 = operators.convertToMid2FromOriginalAndMid(originaldata);
		coreOp.stop(convert2.original);
		
		JoinData joindata = operators.joinData(originaldata, convert.out);
		
		JoinData2 joindata2 = operators.joinData2(joindata.joined, convert2.out);
		
		ConvertToResult convert3 = operators.convertToResult(joindata2.joined);
		coreOp.stop(convert3.original);
		
		result.add(convert3.out);
	}

}

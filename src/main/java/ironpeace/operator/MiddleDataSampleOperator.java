package ironpeace.operator;


import ironpeace.modelgen.dmdl.model.Middata;
import ironpeace.modelgen.dmdl.model.Middata2;
import ironpeace.modelgen.dmdl.model.Middata3;
import ironpeace.modelgen.dmdl.model.OriginalData;
import ironpeace.modelgen.dmdl.model.PreResult;
import ironpeace.modelgen.dmdl.model.Result;

import com.asakusafw.vocabulary.operator.Convert;
import com.asakusafw.vocabulary.operator.MasterJoin;

public abstract class MiddleDataSampleOperator {

	private Middata mid = new Middata();
	private Middata2 mid2 = new Middata2();
	private Result result = new Result();
	

	@Convert
	public Middata convertToMidFromOriginal(OriginalData orignal){
		mid.setKeycode(orignal.getKeycode());
		mid.setMid1(orignal.getData1() + orignal.getData2());
		mid.setMid2(orignal.getData2() + orignal.getData3());
		return mid;
	}
	
	@Convert
	public Middata2 convertToMid2FromOriginalAndMid(OriginalData orignal){
		mid2.setKeycode(mid.getKeycode());
		if(mid.getMid1() > orignal.getData3()){
			mid2.setAlert1AsString("A");
		}else{
			mid2.setAlert2AsString("B");
		}
		return mid2;
	}
	
	@MasterJoin
	public abstract Middata3 joinOriginalAndMid(OriginalData orignal, Middata mid);
	
	@MasterJoin
	public abstract PreResult joinMid3AndMid2(Middata3 mid3, Middata2 mid2);
	
	@Convert
	public Result convertToResult(PreResult pre){
		result.setKeycode(pre.getKeycode());
		result.setData1(pre.getData1());
		result.setData2(pre.getData2());
		result.setData3(pre.getData3());
		result.setAlert1(pre.getAlert1());
		result.setAlert2(pre.getAlert2());
		return result;
	}
	
	
}

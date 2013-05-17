package ironpeace.operator;
import ironpeace.modelgen.dmdl.model.Middata;
import ironpeace.modelgen.dmdl.model.Middata2;
import ironpeace.modelgen.dmdl.model.Middata3;
import ironpeace.modelgen.dmdl.model.OriginalData;
import ironpeace.modelgen.dmdl.model.PreResult;
import javax.annotation.Generated;
/**
 * {@link MiddleDataSampleOperator}に関する演算子実装クラス。
 */
@Generated("OperatorImplementationClassGenerator:0.0.1") public class MiddleDataSampleOperatorImpl extends 
        MiddleDataSampleOperator {
    /**
     * インスタンスを生成する。
     */
    public MiddleDataSampleOperatorImpl() {
        return;
    }
    @Override public Middata3 joinOriginalAndMid(OriginalData orignal, Middata mid) {
        throw new UnsupportedOperationException("マスタ結合演算子は組み込みの方法で処理されます");
    }
    @Override public PreResult joinMid3AndMid2(Middata3 mid3, Middata2 mid2) {
        throw new UnsupportedOperationException("マスタ結合演算子は組み込みの方法で処理されます");
    }
}
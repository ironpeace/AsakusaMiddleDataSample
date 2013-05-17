package ironpeace.operator;
import com.asakusafw.vocabulary.flow.Operator;
import com.asakusafw.vocabulary.flow.Source;
import com.asakusafw.vocabulary.flow.graph.FlowBoundary;
import com.asakusafw.vocabulary.flow.graph.FlowElementResolver;
import com.asakusafw.vocabulary.flow.graph.ObservationCount;
import com.asakusafw.vocabulary.flow.graph.OperatorDescription;
import com.asakusafw.vocabulary.flow.graph.ShuffleKey;
import com.asakusafw.vocabulary.operator.Convert;
import com.asakusafw.vocabulary.operator.MasterJoin;
import ironpeace.modelgen.dmdl.model.Middata;
import ironpeace.modelgen.dmdl.model.Middata2;
import ironpeace.modelgen.dmdl.model.Middata3;
import ironpeace.modelgen.dmdl.model.OriginalData;
import ironpeace.modelgen.dmdl.model.PreResult;
import ironpeace.modelgen.dmdl.model.Result;
import java.util.Arrays;
import javax.annotation.Generated;
/**
 * {@link MiddleDataSampleOperator}に関する演算子ファクトリークラス。
 * @see MiddleDataSampleOperator
 */
@Generated("OperatorFactoryClassGenerator:0.0.1") public class MiddleDataSampleOperatorFactory {
    /**
     */
    public static final class JoinOriginalAndMid implements Operator {
        private final FlowElementResolver $;
        /**
         */
        public final Source<Middata3> joined;
        /**
         * 結合に失敗したデータ
         */
        public final Source<Middata> missed;
        JoinOriginalAndMid(Source<OriginalData> orignal, Source<Middata> mid) {
            OperatorDescription.Builder builder = new OperatorDescription.Builder(MasterJoin.class);
            builder.declare(MiddleDataSampleOperator.class, MiddleDataSampleOperatorImpl.class, "joinOriginalAndMid");
            builder.declareParameter(OriginalData.class);
            builder.declareParameter(Middata.class);
            builder.addInput("orignal", orignal, new ShuffleKey(Arrays.asList(new String[]{"keycode"}), Arrays.asList(
                    new ShuffleKey.Order[]{})));
            builder.addInput("mid", mid, new ShuffleKey(Arrays.asList(new String[]{"keycode"}), Arrays.asList(new 
                    ShuffleKey.Order[]{})));
            builder.addOutput("joined", Middata3.class);
            builder.addOutput("missed", mid);
            builder.addAttribute(FlowBoundary.SHUFFLE);
            builder.addAttribute(ObservationCount.DONT_CARE);
            this.$ = builder.toResolver();
            this.$.resolveInput("orignal", orignal);
            this.$.resolveInput("mid", mid);
            this.joined = this.$.resolveOutput("joined");
            this.missed = this.$.resolveOutput("missed");
        }
        /**
         * この演算子の名前を設定する。
         * @param newName 設定する名前
         * @return この演算子オブジェクト (this)
         * @throws IllegalArgumentException 引数に{@code null}が指定された場合
         */
        public MiddleDataSampleOperatorFactory.JoinOriginalAndMid as(String newName) {
            this.$.setName(newName);
            return this;
        }
    }
    /**
     * @param orignal
     * @param mid
     * @return 生成した演算子オブジェクト
     * @see MiddleDataSampleOperator#joinOriginalAndMid(OriginalData, Middata)
     */
    public MiddleDataSampleOperatorFactory.JoinOriginalAndMid joinOriginalAndMid(Source<OriginalData> orignal, Source<
            Middata> mid) {
        return new MiddleDataSampleOperatorFactory.JoinOriginalAndMid(orignal, mid);
    }
    /**
     */
    public static final class JoinMid3AndMid2 implements Operator {
        private final FlowElementResolver $;
        /**
         */
        public final Source<PreResult> joined;
        /**
         * 結合に失敗したデータ
         */
        public final Source<Middata2> missed;
        JoinMid3AndMid2(Source<Middata3> mid3, Source<Middata2> mid2) {
            OperatorDescription.Builder builder0 = new OperatorDescription.Builder(MasterJoin.class);
            builder0.declare(MiddleDataSampleOperator.class, MiddleDataSampleOperatorImpl.class, "joinMid3AndMid2");
            builder0.declareParameter(Middata3.class);
            builder0.declareParameter(Middata2.class);
            builder0.addInput("mid3", mid3, new ShuffleKey(Arrays.asList(new String[]{"keycode"}), Arrays.asList(new 
                    ShuffleKey.Order[]{})));
            builder0.addInput("mid2", mid2, new ShuffleKey(Arrays.asList(new String[]{"keycode"}), Arrays.asList(new 
                    ShuffleKey.Order[]{})));
            builder0.addOutput("joined", PreResult.class);
            builder0.addOutput("missed", mid2);
            builder0.addAttribute(FlowBoundary.SHUFFLE);
            builder0.addAttribute(ObservationCount.DONT_CARE);
            this.$ = builder0.toResolver();
            this.$.resolveInput("mid3", mid3);
            this.$.resolveInput("mid2", mid2);
            this.joined = this.$.resolveOutput("joined");
            this.missed = this.$.resolveOutput("missed");
        }
        /**
         * この演算子の名前を設定する。
         * @param newName0 設定する名前
         * @return この演算子オブジェクト (this)
         * @throws IllegalArgumentException 引数に{@code null}が指定された場合
         */
        public MiddleDataSampleOperatorFactory.JoinMid3AndMid2 as(String newName0) {
            this.$.setName(newName0);
            return this;
        }
    }
    /**
     * @param mid3
     * @param mid2
     * @return 生成した演算子オブジェクト
     * @see MiddleDataSampleOperator#joinMid3AndMid2(Middata3, Middata2)
     */
    public MiddleDataSampleOperatorFactory.JoinMid3AndMid2 joinMid3AndMid2(Source<Middata3> mid3, Source<Middata2> mid2) 
            {
        return new MiddleDataSampleOperatorFactory.JoinMid3AndMid2(mid3, mid2);
    }
    /**
     */
    public static final class ConvertToMidFromOriginal implements Operator {
        private final FlowElementResolver $;
        /**
         * 入力された内容
         */
        public final Source<OriginalData> original;
        /**
         */
        public final Source<Middata> out;
        ConvertToMidFromOriginal(Source<OriginalData> orignal) {
            OperatorDescription.Builder builder1 = new OperatorDescription.Builder(Convert.class);
            builder1.declare(MiddleDataSampleOperator.class, MiddleDataSampleOperatorImpl.class, 
                    "convertToMidFromOriginal");
            builder1.declareParameter(OriginalData.class);
            builder1.addInput("orignal", orignal);
            builder1.addOutput("original", orignal);
            builder1.addOutput("out", Middata.class);
            builder1.addAttribute(ObservationCount.DONT_CARE);
            this.$ = builder1.toResolver();
            this.$.resolveInput("orignal", orignal);
            this.original = this.$.resolveOutput("original");
            this.out = this.$.resolveOutput("out");
        }
        /**
         * この演算子の名前を設定する。
         * @param newName1 設定する名前
         * @return この演算子オブジェクト (this)
         * @throws IllegalArgumentException 引数に{@code null}が指定された場合
         */
        public MiddleDataSampleOperatorFactory.ConvertToMidFromOriginal as(String newName1) {
            this.$.setName(newName1);
            return this;
        }
    }
    /**
     * @param orignal
     * @return 生成した演算子オブジェクト
     * @see MiddleDataSampleOperator#convertToMidFromOriginal(OriginalData)
     */
    public MiddleDataSampleOperatorFactory.ConvertToMidFromOriginal convertToMidFromOriginal(Source<OriginalData> 
            orignal) {
        return new MiddleDataSampleOperatorFactory.ConvertToMidFromOriginal(orignal);
    }
    /**
     */
    public static final class ConvertToMid2FromOriginalAndMid implements Operator {
        private final FlowElementResolver $;
        /**
         * 入力された内容
         */
        public final Source<OriginalData> original;
        /**
         */
        public final Source<Middata2> out;
        ConvertToMid2FromOriginalAndMid(Source<OriginalData> orignal) {
            OperatorDescription.Builder builder2 = new OperatorDescription.Builder(Convert.class);
            builder2.declare(MiddleDataSampleOperator.class, MiddleDataSampleOperatorImpl.class, 
                    "convertToMid2FromOriginalAndMid");
            builder2.declareParameter(OriginalData.class);
            builder2.addInput("orignal", orignal);
            builder2.addOutput("original", orignal);
            builder2.addOutput("out", Middata2.class);
            builder2.addAttribute(ObservationCount.DONT_CARE);
            this.$ = builder2.toResolver();
            this.$.resolveInput("orignal", orignal);
            this.original = this.$.resolveOutput("original");
            this.out = this.$.resolveOutput("out");
        }
        /**
         * この演算子の名前を設定する。
         * @param newName2 設定する名前
         * @return この演算子オブジェクト (this)
         * @throws IllegalArgumentException 引数に{@code null}が指定された場合
         */
        public MiddleDataSampleOperatorFactory.ConvertToMid2FromOriginalAndMid as(String newName2) {
            this.$.setName(newName2);
            return this;
        }
    }
    /**
     * @param orignal
     * @return 生成した演算子オブジェクト
     * @see MiddleDataSampleOperator#convertToMid2FromOriginalAndMid(OriginalData)
     */
    public MiddleDataSampleOperatorFactory.ConvertToMid2FromOriginalAndMid convertToMid2FromOriginalAndMid(Source<
            OriginalData> orignal) {
        return new MiddleDataSampleOperatorFactory.ConvertToMid2FromOriginalAndMid(orignal);
    }
    /**
     */
    public static final class ConvertToResult implements Operator {
        private final FlowElementResolver $;
        /**
         * 入力された内容
         */
        public final Source<PreResult> original;
        /**
         */
        public final Source<Result> out;
        ConvertToResult(Source<PreResult> pre) {
            OperatorDescription.Builder builder3 = new OperatorDescription.Builder(Convert.class);
            builder3.declare(MiddleDataSampleOperator.class, MiddleDataSampleOperatorImpl.class, "convertToResult");
            builder3.declareParameter(PreResult.class);
            builder3.addInput("pre", pre);
            builder3.addOutput("original", pre);
            builder3.addOutput("out", Result.class);
            builder3.addAttribute(ObservationCount.DONT_CARE);
            this.$ = builder3.toResolver();
            this.$.resolveInput("pre", pre);
            this.original = this.$.resolveOutput("original");
            this.out = this.$.resolveOutput("out");
        }
        /**
         * この演算子の名前を設定する。
         * @param newName3 設定する名前
         * @return この演算子オブジェクト (this)
         * @throws IllegalArgumentException 引数に{@code null}が指定された場合
         */
        public MiddleDataSampleOperatorFactory.ConvertToResult as(String newName3) {
            this.$.setName(newName3);
            return this;
        }
    }
    /**
     * @param pre
     * @return 生成した演算子オブジェクト
     * @see MiddleDataSampleOperator#convertToResult(PreResult)
     */
    public MiddleDataSampleOperatorFactory.ConvertToResult convertToResult(Source<PreResult> pre) {
        return new MiddleDataSampleOperatorFactory.ConvertToResult(pre);
    }
}
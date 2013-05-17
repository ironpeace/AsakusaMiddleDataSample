package ironpeace.modelgen.dmdl.io;
import com.asakusafw.runtime.io.ModelInput;
import com.asakusafw.runtime.io.RecordParser;
import ironpeace.modelgen.dmdl.model.Middata3;
import java.io.IOException;
/**
 * TSVファイルなどのレコードを表すファイルを入力として<code>middata3</code>を読み出す
 */
public final class Middata3Input implements ModelInput<Middata3> {
    private final RecordParser parser;
    /**
     * インスタンスを生成する。
     * @param parser 利用するパーサー
     * @throws IllegalArgumentException 引数に<code>null</code>が指定された場合
     */
    public Middata3Input(RecordParser parser) {
        if(parser == null) {
            throw new IllegalArgumentException("parser");
        }
        this.parser = parser;
    }
    @Override public boolean readTo(Middata3 model) throws IOException {
        if(parser.next() == false) {
            return false;
        }
        parser.fill(model.getKeycodeOption());
        parser.fill(model.getData1Option());
        parser.fill(model.getData2Option());
        parser.fill(model.getData3Option());
        parser.fill(model.getMid1Option());
        parser.fill(model.getMid2Option());
        parser.endRecord();
        return true;
    }
    @Override public void close() throws IOException {
        parser.close();
    }
}
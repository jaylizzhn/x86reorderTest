package x86CompilerReorderTest;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.II_Result;

@JCStressTest
@State
@Outcome(id = "1, 2",expect = Expect.ACCEPTABLE,desc = "Should r2 always be set to 1?")
@Outcome(id = "0, 0",expect = Expect.ACCEPTABLE,desc = "Should r2 always be set to 1?")
@Outcome(id = "0, 2",expect = Expect.ACCEPTABLE_INTERESTING,desc = "reordered")
@Outcome(id = "1, 0",expect = Expect.ACCEPTABLE,desc = "Should r2 always be set to 1?")
public class ScTest31 {
    int data;
    int flag;

    @Actor
    public void actor1(){
        data = 1;
        flag = 2;
    }

    @Actor
    public void actor2(II_Result result){

        result.r1 = data;
        result.r2 = flag;

    }
}

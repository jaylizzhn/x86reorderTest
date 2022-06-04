package x86CompilerReorderTest;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.II_Result;

@JCStressTest
@State
@Outcome(id = "1, 1",expect = Expect.ACCEPTABLE,desc = "ordered")
@Outcome(id = "0, 1",expect = Expect.ACCEPTABLE,desc = "ordered")
@Outcome(id = "1, 0",expect = Expect.ACCEPTABLE,desc = "ordered")
@Outcome(id = "0, 0",expect = Expect.ACCEPTABLE_INTERESTING,desc = "bypass")
public class TsoTest41 {
    int x;
    int y;

    @Actor
    public void actor1(II_Result result){
        x = 1;
        result.r1 = y;
    }

    @Actor
    public void actor2(II_Result result){
        y = 1;
        result.r2 = x;
    }
}

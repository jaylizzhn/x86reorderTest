package x86CompilerReorderTest;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.IIII_Result;

@JCStressTest
@State
@Outcome(id = "1, 0, 1, 0",expect = Expect.ACCEPTABLE_INTERESTING,desc = "compiler reorder")
@Outcome(id = "1, 0, 1, 1",expect = Expect.ACCEPTABLE,desc = "expected")
@Outcome(id = "1, 1, 1, 0",expect = Expect.ACCEPTABLE,desc = "expected")
@Outcome(id = "1, 1, 1, 1",expect = Expect.ACCEPTABLE,desc = "expected")

public class TsoTest43Volatile {
    volatile int x;
    volatile int y;

    @Actor
    public void actor1(IIII_Result result){
        x = 1;
        result.r1 = x;
        result.r2 = y;
    }

    @Actor
    public void actor2(IIII_Result result){
        y = 1;
        result.r3 = y;
        result.r4 = x;
    }
}

package x86CompilerReorderTest;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.II_Result;

@JCStressTest
@State
@Outcome(id = "2, 1",expect = Expect.ACCEPTABLE,desc = "Should r2 always be set to 1?")
public class ScTest31Volatile {
    volatile int data;
    volatile int flag;

    @Actor
    public void actor1(){
        data = 1;
        flag = 2;
    }

    @Actor
    public void actor2(II_Result result){
        do {
            result.r1 = flag;
        } while (result.r1 != 2);

        result.r2 = data;

    }
}

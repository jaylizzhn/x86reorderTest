/*
    Credit to:
    https://www.bilibili.com/read/cv15906402?spm_id_from=333.999.0.0
 */


package x86CompilerReorderTest;


import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.II_Result;

@JCStressTest
@State
@Outcome(id = "1, 1",expect = Expect.ACCEPTABLE,desc = "ordered")
@Outcome(id = "0, 1",expect = Expect.ACCEPTABLE,desc = "ordered")
@Outcome(id = "1, 0",expect = Expect.ACCEPTABLE_INTERESTING,desc = "reordered")
@Outcome(id = "0, 0",expect = Expect.ACCEPTABLE,desc = "ordered")

public class EqxHolderTest {
    private final Holder h1 = new Holder();
    private final Holder h2 = h1;

    @Actor
    public void actor(II_Result result){
        final Holder x1 = this.h1;
        final Holder x2 = this.h2;

        x1.trap = 1;
        x2.trap = 1;

        result.r1 = x1.a;
        result.r2 = x2.a;
    }


    private static class Holder{
        int a;
        int trap;
    }

    @Actor
    public void actor1(){
        h1.a = 1;
    }
}

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
public class EqxTest {
    int x;

    @Actor
    public void actor1(){
        x = 1;
    }

    @Actor
    public void actor2(II_Result result){
        result.r1 = x;
        result.r2 = x;
    }
}

package runners;

import com.intuit.karate.junit5.Karate;


public class ParallelExecutionTest {


    @Karate.Test
    Karate testAll() {
        return Karate.run("classpath:features")
                .tags("@SmokeTest")   // optional
                .relativeTo(getClass());
    }
}

package runners;

import org.junit.Test;
import com.intuit.karate.Results;
import com.intuit.karate.Runner;

public class ParallelExecutionRunner {

    @Test
    public void testParallel() {
        System.out.println("starting tests!");
        //Executes without tag
        //Results results = Runner.path("classpath:/features/getUserProfile.feature").parallel(1);// change feature file name 

        //Execute with tag
        Results results = Runner.path("classpath:/features").tags("@GetUserProfile").parallel(2);

        System.out.println("ERROR MESSAGE: " + results.getErrorMessages());
        System.out.println("FAIL COUNT: " + results.getFailCount());

    }

}
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import com.intuit.karate.junit5.Karate;

class TestRunner {
    
 
	/*RUN ALL TESTS*/
     @Karate.Test
     Karate testAll() {
         return Karate.run().relativeTo(getClass());
     }
	
	
     /*RUN TEST BY TAG
     @Karate.Test
     Karate testTags() {
         return Karate.run().tags("@petstore_user").relativeTo(getClass());
     }
     	*/
     
     
}

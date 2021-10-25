

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import com.intuit.karate.junit5.Karate;

class TestRunnerParallel {
    
 
    
	  
//  @Test
//	void testParallel() {
//		Results results = Runner.path("classpath:oapi").parallel(10);
////		generateReport(results.getReportDir());
//		assertEquals(0, results.getFailCount(), results.getErrorMessages());
//	}
    

//
//	public static void generateReport(String karateOutputPath) {
//		Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[] { "json" }, true);
//		List<String> jsonPaths = new ArrayList(jsonFiles.size());
//		jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
//		Configuration config = new Configuration(new File("target"), "demo");
//		ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
//		reportBuilder.generateReports();
//	}
}

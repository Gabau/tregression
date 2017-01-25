package tregression.handler;

import java.io.IOException;
import java.net.MalformedURLException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jdt.core.JavaModelException;

import tregression.junit.TestCaseAnalyzer;

public class EvaluationTrialHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Job job = new Job("Do evaluation") {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				runSingeTrial();
				return Status.OK_STATUS;
			}
		};
		
		job.schedule();
		
		return null;
	}
	
	private void runSingeTrial(){
		TestCaseAnalyzer analyzer = new TestCaseAnalyzer();
		
		//TODO BUG TimeOutException in JVM
//		String testClassName = "org.apache.commons.math.analysis.interpolation.LinearInterpolatorTest";
//		String testMethodName = "testInterpolateLinear";
//		String mutationFile = "C:\\Users\\YUNLIN~1\\AppData\\Local\\Temp\\"
//				+ "apache-common-math-2.2\\2081_22_1\\MathUtils.java";
//		String mutatedClass = "org.apache.commons.math.util.MathUtils";
		
//		String testClassName = "test.SimpleCalculatorTest";
//		String testMethodName = "testCalculator";
//		String mutationFile = "C:\\microbat_evaluation\\mutation\\110_29_1\\SimpleCalculator.java";
//		double unclearRate = 0.1;
//		boolean enableLoopInference = true;
//		boolean isReuseTrace = false;
//		int optionSearchLimit = 1000;
		
		String testClassName = "org.apache.commons.math.analysis.polynomials.PolynomialsUtilsTest";
		String testMethodName = "testFirstChebyshevPolynomials";
		String mutationFile = "C:\\microbat_evaluation_regression\\apache-common-math-2.2\\197_31_1\\PolynomialsUtils.java";
		double unclearRate = 0.0;
		boolean enableLoopInference = false;
		boolean isReuseTrace = true;
		int optionSearchLimit = 1000;
		
		try {
			analyzer.runEvaluationForSingleTrial(testClassName, testMethodName, mutationFile, 
					unclearRate, enableLoopInference, isReuseTrace, optionSearchLimit);
		} catch (JavaModelException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

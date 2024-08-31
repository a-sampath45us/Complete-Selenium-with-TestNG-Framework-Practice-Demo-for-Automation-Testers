package testpractice;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

//ITestListener interface which implements Testng listeners
//Listeners keep on Listening to our tests whether they fail or pass
//Listeners has so many intelligent methods if a test is pass or fail it will reroute the execution to a specific block of methods present in TestNG Listeners

public class TestNGListeners implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//System.out.println("I succesfully executed listeners pass code");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//screenshot code
		//response code if API is failed
		System.out.println("I successfully executed listeners fail code"+" "+result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
}

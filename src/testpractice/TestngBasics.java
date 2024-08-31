package testpractice;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestngBasics {

	
	//TestNG test cases are executed with @Test annotation followed by method
	//we can define multiple test cases in a single class
	//TestNG Hierarchy Test Suite->Test Folder(Module)->Test Cases
	//we can modularize the testcases based up on functionality and trigger them accordingly
	//we can also get a control exclusion of running specific methods
	//clear cut understanding on annotations
	//Global environment variables can be incorporated through selenium
	//Parameterizing with multiple data sets by running tests with multiple combinations
	//TestNG Annotations help with Inheritance to remove boiler plate code in Tests
	/*Inheritance extends keyword connects parent class and child class. we can write codes like invoking chrome url and maxing the window in parent class
	 * to keep child class clean. We can write Before & After Methods in parent class and a test in child class In execution it refers to parent & class
	 * and executes the code in sequential. And also we can write method in Parent class and call that method to child class by creating a method in child class.
	 * we can call methods present in another class to this class using Inheritance extends keyword and by creating object of another class in this class then we can
	 * access methods present in another class and use those in this class.
	 */
	
	//XML
	/*<suite name="Loan Department">
	<test name="Personal Loan">//module
	<classes>
	
	<class name="test.day1">//PL module test cases
	   <methods>
	        <include name = "Demo"/>//Include this method/test case from PL module to perform execution
	   </methods>
	</class>
	<class name="test.day2"/>//PL Module test cases
	<class name="test.day4"/>//Home Loan Module test cases
	
	</classes>
	</test>
	
	<test name="Car Loan">//module
	<classes>
	  <class name="test.day3">
	          <methods>
	               <exclude name="MobileLogincarLoan"/>//excluding this method/test case from Car Loan Module from performing execution
	               <exclude name="Mobile.*"/> //eliminates all methods names starting with "Mobile" from execution 
	          </methods>
	    </class>     
	</classes>
	</test>
	</suite>*/
	
	//XML - Executing Test Cases at Package Level
	/*<suite name="Loan Department">
	<test name="Personal Loan">//module
	  
	    <packages>
	        <package name="test"/>
	    </packages>    
	    
	</test>
	</suite>*/
	
	//XML - usage of Groups in XML(Groups comes between test and classes)
	/*<suite name="Suite">
	  <test thread-count="5" name="Test">
		  <groups>
			  <run>
				  <include name="smoke"/> //here we can use exclude also
			  </run>
		  </groups>
	    <classes>
	      <class name="testpractice.TestngBasics"/>
	    </classes>
	  </test>
	</suite>*/
	
	//XML - Running Tests parallel //we can run this parallel execution at Test Folder Level & Class Level(parallel="classes")
	/*<suite name="Loan Department" parallel="tests" thread-count="2"> //thread count is how many tests I want to run parallelly
	</suite>*/
	
	@Test
	public void Demo()
	{
		System.out.println("I am in a Demo Method/Test Case");
	}
	
	@Test(groups={"smoke"}) //using Groups tag //suppose if there are 100 test cases in those 40 are smoke test cases then using groups we can execute only smoke test cases
	public void WebLogin()
	{
		System.out.println("I am in a WebLogin Method/Test Case for Groups Smoke Example");
	}
	
	@Test
	public void ZLogin()
	{
		System.out.println("I am in a ZLogin Method/Test Case for depends keyword example");
	}
	
	@Test(dependsOnMethods={"ZLogin"}) //using depends keyword //using depends we can execute methods based on priority rather than alphabetical order 
	public void ALogin()
	{
		System.out.println("I am in a ALogin Method/Test Case for depends keyword example");
	}
	
	@Test(enabled=false) //when bug is already found in this test case we use enabled to avoid this method in exection
	public void BugFoundAlready()
	{
		System.out.println("Bug Already Found in this test");
	}
	
	@Test(timeOut=4000) //Wait for 40secs before TestNG fails this test case
	public void TimeOut()
	{
		System.out.println("Giving a TimeOut because it is taking longer than expected");
	}
	
	@Parameters({"URL","APIKey"}) //(Refer testng2.xml) we can use "parameters" to define variables/anything globally at Suite Level & Test Folder Level  
	@Test 
	public void ParameterEx(String urlname,String key)
	{
		System.out.println(urlname);
		System.out.println(key);
	}
	
	@BeforeMethod
	public void BfMethod()
	{
		System.out.println("I will execute before every method/test case");//scope of this belongs to a class level
	}
	
	@AfterMethod
	public void AfMethod()
	{
		System.out.println("I will execute after every method/test case");//scope of this belongs to a class level
	}
	
	@BeforeClass
	public void BfClass()
	{
		System.out.println("I will execute before this class");//scope of this belongs to a class level
	}
	
	@AfterClass
	public void AfClass()
	{
		System.out.println("I will execute after this class");//scope of this belongs to a class level
	}
	
	@BeforeTest
	public void prerequisite()
	{
		System.out.println("I will execute before this test folder");
	}
	
	@AfterTest
	public void lastexecution()
	{
		System.out.println("I will execute after this test folder");
	}
	
	@BeforeSuite
	public void BfSuite()
	{
		System.out.println("I will execute before suite");
	}
	
	@AfterSuite
	public void AfSuite()
	{
		System.out.println("I will execute after suite");
	}
	
	@DataProvider //Parameterizing with multiple data sets by running tests with multiple combinations
	public Object[][] getData()
	{
		//1st Combination - username & password - Good Credit History
		//2nd Combination - username & password - No Credit History
		//3rd Combination - username & password - Fraud Credit History
		Object[][] data = new Object[3][2];//3 refers combinations(rows) //2 refers username & password(columns)(passing two values for each run)
		//1st Data Set
		data[0][0]="username1";
		data[0][1]="pass1";
		//2nd Data Set
		data[1][0]="username2";
		data[1][1]="pass2";
		//3rd Data Set
		data[2][0]="username3";
		data[2][1]="pass3";
		
		return data;
	}
	
	@Test(dataProvider="getData") //Test case parameterizing with multiple data sets 
	public void TCWMDS(String username,String password)
	{
		System.out.println(username+" "+password);
	}
	
	@Test
	public void TestListen()
	{
		System.out.println("I am failing bcoz to trigger testng listeners");
		Assert.assertTrue(false);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

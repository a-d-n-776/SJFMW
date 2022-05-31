
package GLDT_TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import BIPS.BIPS_Login;
import GLDT_Other_Methods.Make_Cell_Empty;
import GLDT_Methods.GLDT_TestCase_Steps;
public class GLDT_TestCases {
	
	@BeforeClass
	public void Make_Cell_Empty() throws Exception {
		Make_Cell_Empty.Delete_Cell_Contents();
	}
	@BeforeMethod
	public void Tama_User_Login() throws Exception {
		BIPS_Login.TAMA_User_Login();
	
	}
	
	//@Test (priority=1)
	public static void GLDT_TC_01() throws Exception {
	    GLDT_TestCase_Steps.initiate_gldt();
	}
	
	//@Test (priority=2)
	public static void GLDT_TC_02() throws Exception {
	    GLDT_TestCase_Steps.Initiate_And_Complete_RAprocess_GLDT();
	}
	
	//@Test (priority=3)
	public static void GLDT_TC_03() throws Exception {
	    GLDT_TestCase_Steps.CompleteRAprocess_For_Open_Case_GLDT();
	}
		
	//Not working for me
	//working when unselect the country.
	//@Test (priority=4)
	public void GLDT_TC_04() throws Exception {
	    GLDT_TestCase_Steps.Verify_error_message();
	}
	
	//@Test (priority=5)  
	public static void GLDT_TC_05() throws Exception {
    GLDT_TestCase_Steps.Open_And_Close_Open_case_gldt();
	}
	
	//@Test (priority=6)  
	public static void GLDT_TC_06() throws Exception {
    GLDT_TestCase_Steps.Open_And_Close_PendingChildCaseProcessing_gldt();
	}

	
	////////////////////////
	
	@Test (priority=7)
	public static void GLDT_TC_07() throws Exception {
	    GLDT_TestCase_Steps.initiate_gldtProductsCheckBox();
	}
	@Test (priority=8)
	public static void GLDT_TC_08() throws Exception {
	    GLDT_TestCase_Steps.initiate_gldtProductsCheckBox_And_RAprocess();
		
	}
	
	@Test (priority=9)
	public static void GLDT_TC_09() throws Exception {
	    GLDT_TestCase_Steps.CompleteRAprocess_For_Open_Case_GLDT_ProductsCheckBox();
	}
	
	
	
	
	
	
	
	
//	@AfterClass
//	public void Test() throws Exception {
//		ExcelReportGenerator.main(null);
//	}	
//	public static void main(String[] args) throws Exception {
//		GLDT_TestCases gl = new GLDT_TestCases();
//		gl.Make_Cell_Empty();
//		gl.Tama_User_Login();
//		gl.GLDT_TC_04();
//		TestNGCustomReportListener test = new TestNGCustomReportListener();
//		test.generateReport(null, null, null);
//		ExcelReportGenerator.main(null);
//	}
}



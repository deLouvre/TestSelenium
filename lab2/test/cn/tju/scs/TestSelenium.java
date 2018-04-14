package cn.tju.scs;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestSelenium {
	
	private AutoTesting autoTesting;
	private String username;
	private String password;
	private String expected;
	
	public TestSelenium(String username, String password, String expected) {
		// TODO Auto-generated constructor stub
		this.username = username;
		this.password = password;
		this.expected = expected;
	}

	@Before
	public void setUp() throws Exception {
		autoTesting = new AutoTesting();		
	}
	
	@Parameters
	public static Collection<Object[]> data() throws Exception{
		File excelFile = new File("D:\\Junior\\»Ìº˛≤‚ ‘\\input.xlsx");
		InputStream input = new FileInputStream(excelFile);	
		XSSFWorkbook workBook = new XSSFWorkbook(input);
		XSSFSheet sheet = workBook.getSheetAt(0);
		Object[][] object = new Object[5][3];
		for(int i = 0; i < 5; i++){				
			object[i][0]=sheet.getRow(i).getCell(0).toString();
			object[i][1]=sheet.getRow(i).getCell(0).toString().substring(4);
			object[i][2]=sheet.getRow(i).getCell(1).toString();			
	}	
//		Object[][] object = {
//				{"3015218071","218071","https://github.com/sssstupid"}				
//		};  
        return Arrays.asList(object);		
	}

	@Test
	public void test() {
		assertEquals(this.expected, autoTesting.getAddress(username, password));
	}
	
	@After
	public void tearDown() throws Exception {
	}

}

package ExcelCopy;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import java.util.Iterator;

//import com.tngtech.java.junit.dataprovider.DataProvider;
import java.util.ArrayList;

public class DriverExcel {
	
@DataProvider(name = "getExcelData")
	public Iterator<Object[]> getTestData() throws Exception
	{
		TestUtil utilk= new TestUtil();
		ArrayList<Object[]> testData=utilk.getDataFromExcel();
		return testData.iterator();
	}

@Test(dataProvider="getExcelData")
public void getTradeData(String tradeType, String notional, String ccypair)
{
	
	//String val1=tradeType;
	System.out.println("TradeType->"+tradeType+"Notional->"+notional+"CCY pair->"+ccypair);
	
}

/*@Test(expectedExceptions="ArithmaticExeption")
public void getException()
{
	
	//String val1=tradeType;
	System.out.println("");
	
}*/

}

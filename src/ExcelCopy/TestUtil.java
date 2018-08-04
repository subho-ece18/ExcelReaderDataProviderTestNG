package ExcelCopy;
import java.util.ArrayList;

public class TestUtil {
	
	//static Xls_Reader reader;
	Xls_Reader reader=null;
	//Xls_Reader copyreader=null;
	public ArrayList<Object[]>  getDataFromExcel(){
		
		ArrayList<Object[]> readList= new ArrayList<Object[]>();
		//ArrayList<TradeDetails> copyTradeList= new ArrayList<TradeDetails>();*/
		
		
		
		String file=System.getProperty("user.dir")+"\\src\\TradeBook.xlsx";
		//String copyfile=System.getProperty("user.dir")+"\\src\\TradeBookcopy.xlsx";
		try{

			reader=new Xls_Reader(file);
			//copyreader=new Xls_Reader(copyfile);
			for( int rownum=2;rownum<=reader.getRowCount("Cash");rownum++)
			{
			String tradeType=reader.getCellData("Cash", "TradeType", rownum);
			String notional=reader.getCellData("Cash", "Notional", rownum);
			String CCYPair=reader.getCellData("Cash", "CCYPair", rownum);
			Object obj[]={tradeType,notional,CCYPair};
			readList.add(obj);
		    }
			
			//compareExcel(reader,copyreader);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return readList;
	}
	
	public ArrayList<TradeDetails> compareExcel(Xls_Reader reader,Xls_Reader copyreader) 
	{
		int count=0;
		ArrayList<TradeDetails> compareTradeList= new ArrayList<TradeDetails>();
		if(reader.getRowCount("Cash")==copyreader.getRowCount("Cash"))
		{
		for( int rownum=2;rownum<=reader.getRowCount("Cash");rownum++)
		{
			if(
						(reader.getCellData("Cash", "TradeType", rownum).equals
						(copyreader.getCellData("Cash", "TradeType", rownum)))
						&&
						(reader.getCellData("Cash", "Notional", rownum).equals
						(copyreader.getCellData("Cash", "Notional", rownum)))
						&&
						(reader.getCellData("Cash", "CCYPair", rownum).equals
						(copyreader.getCellData("Cash", "CCYPair", rownum)))
					)
				{
					count++;
				}
				else
				{   TradeDetails tradeDetails=new TradeDetails();
				    tradeDetails.setRowNum(rownum);
					tradeDetails.setTradeType(copyreader.getCellData("Cash", "TradeType", rownum));
					tradeDetails.setNotional(copyreader.getCellData("Cash", "Notional", rownum));
					tradeDetails.setcCYPair(copyreader.getCellData("Cash", "CCYPair", rownum));
					compareTradeList.add(tradeDetails);
				}
			
			
		
		}
		}
		else
		{
			TradeDetails tradeDetails=new TradeDetails();
			tradeDetails.setTradeType("RowCount Mismatched");
			tradeDetails.setNotional("RowCount Mismatched");
			tradeDetails.setcCYPair("RowCount Mismatched");
			compareTradeList.add(tradeDetails);
		}
		
	/*	
		 * 
		 * /*TradeDetails tradeDetails=new TradeDetails();
			tradeDetails.setTradeType(reader.getCellData("Cash", "TradeType", rownum));
			tradeDetails.setNotional(Integer.parseInt(reader.getCellData("Cash", "Notional", rownum)));
			tradeDetails.setcCYPair(reader.getCellData("Cash", "CCYPair", rownum));
			originalTradeList.add(tradeDetails);for( int rownum=2;rownum<=copyreader.getRowCount("Cash");rownum++)
		{
			TradeDetails tradeDetails=new TradeDetails();
			tradeDetails.setTradeType(reader.getCellData("Cash", "TradeType", rownum));
			tradeDetails.setNotional(Integer.parseInt(reader.getCellData("Cash", "Notional", rownum)));
			tradeDetails.setcCYPair(reader.getCellData("Cash", "CCYPair", rownum));
			copyTradeList.add(tradeDetails);
		}*/
		
		
		
		
		return compareTradeList;
	}
	
	public static void main(String args[])
	{
		
		Xls_Reader reader=null;
		Xls_Reader copyreader=null;
		TestUtil utilk= new TestUtil();
		
		String file=System.getProperty("user.dir")+"\\src\\TradeBook.xlsx";
		String copyfile=System.getProperty("user.dir")+"\\src\\TradeBookcopy.xlsx";
		try{

			reader=new Xls_Reader(file);
			copyreader=new Xls_Reader(copyfile);
		ArrayList<TradeDetails> unMatchdList=utilk.compareExcel(reader, copyreader);
		
		if(unMatchdList.size()>0)
		{
			System.out.println("File Mismatch");
			for(TradeDetails t:unMatchdList)
			{
				if(t.getTradeType().equals("RowCount Mismatched"))
				{
					System.out.println("RowCount Mismatched");
					break;
				}
				else
				{System.out.println("Mismatched happened in this row(s)"+t.getRowNum());
					System.out.print(t.getTradeType()+"----");
					System.out.print(t.getNotional()+"----");
					System.out.println(t.getcCYPair());
				}
			}
		}
		else
		{
			System.out.println("Matched");
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}

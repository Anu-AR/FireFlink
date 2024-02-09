package Excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelTest {

	public static void main(String[] args) throws Throwable {
		
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\Dataprovider.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("Dataprovider");
		int rowcount = sh.getLastRowNum();
		int cellcount = sh.getRow(0).getLastCellNum();
	
	for(int i = 0; i<=rowcount; i++) 	//row
	{
		for (int j = 0; j <cellcount; j++) 		//column
		{
		String value = sh.getRow(i).getCell(j).getStringCellValue();
		
		System.out.print(value+"  ");
		}
		System.out.println();
	}
	
	}
}

package Excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcelTest {

	public static void main(String[] args) throws Throwable {
		
	
	FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\Dataprovider.xlsx");
	Workbook wb = WorkbookFactory.create(fi);
	Sheet sh = wb.getSheet("data");
//int rowcount = sh.getLastRowNum();
//int cellcount = sh.getRow(0).getLastCellNum();
sh.getRow(0).createCell(0).setCellValue("testyantra");
sh.createRow(0).createCell(1).setCellValue("Bangalore");
sh.getRow(1).createCell(0).setCellValue("Qsp");
sh.createRow(1).createCell(1).setCellValue("Mysore");

FileOutputStream fout = new FileOutputStream(".\\src\\test\\resources\\Dataprovider.xlsx");
wb.write(fout);
wb.close();
}
}
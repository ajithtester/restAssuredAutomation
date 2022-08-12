package excelRead;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadTestData {

	public static String FileLocation = "./TestData/IEB_Data.xlsx";
	public static String AccountCreation = "AccountCreation";
	public static String LoginAccount =  "Login";
	public static String ChangePassword =  "ChangePassword";
	
	
	public static String readTestData(int row, int col, String SheetName) throws Throwable {
		File f = new File(FileLocation);
		FileInputStream fi = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet s = wb.getSheet(SheetName);
		Row r = s.getRow(row);
		Cell c = r.getCell(col);
		String Data = c.toString();
		return Data;

	}
}

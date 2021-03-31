package day15;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//writing data to excel file
public class ExcelSheetIOCreateNewSheet {
	public static void main(String[] args) throws IOException, InvalidFormatException {
		
//		XSSFWorkbook workbook = (XSSFWorkbook) WorkbookFactory.create(new File("Sample.xlsx"));
		FileInputStream file = new FileInputStream(new File("test1.xlsx"));
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		XSSFSheet sheet = workbook.createSheet("Samplesheet2");
//		System.out.println(sheet.getSheetName());
		//Create a new row in current sheet
		Row row = sheet.createRow(2);
		
		//Create a new cell in current row
		Cell cell = row.createCell(0);
		
		//Set value to new value
		cell.setCellValue(123456);
		
		try {
		    FileOutputStream out = new FileOutputStream(new File("test1.xlsx"));
		    workbook.write(out);
		    out.close();
		    System.out.println("Excel written successfully..");
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}
		workbook.close();
	}
}

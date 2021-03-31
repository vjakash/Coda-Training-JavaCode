package day15;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//Reading data from excel file
public class ExcelSheetIODemo {
	public static void main(String[] args) throws FileNotFoundException {
		try {

		    FileInputStream file = new FileInputStream(new File("test.xlsx"));
		    
		    //Get the workbook instance for XLS file 
		    XSSFWorkbook workbook = new XSSFWorkbook(file);

		    //Get first sheet from the workbook
		    XSSFSheet sheet = workbook.getSheetAt(0);
		    
		    //Iterate through each rows from first sheet
		    Iterator < Row > rowIterator = sheet.iterator();
		    while (rowIterator.hasNext()) {
		        Row row = rowIterator.next();

		        //For each row, iterate through each columns
		        Iterator < Cell > cellIterator = row.cellIterator();
		        while (cellIterator.hasNext()) {

		            Cell cell = cellIterator.next();
		            System.out.print(cell+"\t\t");	
//		            switch (cell.getCellType()) {
//		                case BOOLEAN:
//		                    System.out.print(cell.getBooleanCellValue() + "\t\t");
//		                    break;
//		                case NUMERIC:
//		                    System.out.print(cell.getNumericCellValue() + "\t\t");
//		                    break;
//		                case STRING:
//		                    System.out.print(cell.getStringCellValue() + "\t\t");
//		                    break;					
//		            }
		        }
		        System.out.println("");
		    }
		    file.close();
		    workbook.close();

		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
}

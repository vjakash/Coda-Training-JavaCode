package invoicePack;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelGenerator extends InvoiceGenerator{

	@Override
	public void generate(String invoiceNumber, Map<String, String> companyAddress, Map<String, String> billingAddress,
			Map<String, ArrayList<Float>> products, float discount, float tax,String filepath) {
		try {
			String fileName=filepath+"/"+invoiceNumber+".xlsx";
//			String filepath1="/Users/vj/eclipse-workspace/JavaTraining/invoices/"+"test"+".xlsx";
			
			File f = new File(fileName);
			f.createNewFile();
			
			XSSFWorkbook workbook = new XSSFWorkbook();
			
			XSSFSheet sheet = workbook.createSheet("invoice");
			
			
			Font font = workbook.createFont();  
            font.setFontName("Courier New");  
            font.setBold(true);  
            
            CellStyle style = workbook.createCellStyle();
			style.setAlignment(HorizontalAlignment.CENTER);
			style.setFont(font);
			

			Font font1 = workbook.createFont();  
            font1.setFontName("Courier New");  
            font1.setBold(false);  
            
            CellStyle style1 = workbook.createCellStyle();
			style1.setAlignment(HorizontalAlignment.CENTER);
			style1.setFont(font1);
			
			sheet.addMergedRegion(CellRangeAddress.valueOf("A1:F1"));
			//Create a new row in current sheet
			Row row = sheet.createRow(0); 
			
			//Create a new cell in current row
			Cell cell = row.createCell(0);
			
			//Set value to new value
			cell.setCellValue(new XSSFRichTextString("Company - Address"));
			cell.setCellStyle(style);
			
			row=sheet.createRow(1);
			cell=row.createCell(0);
			cell.setCellValue("Name");
			cell.setCellStyle(style);
			
			cell=row.createCell(1);
			cell.setCellValue("Door-no");
			cell.setCellStyle(style);
			
			cell=row.createCell(2);
			cell.setCellValue("Street");
			cell.setCellStyle(style);
			
			cell=row.createCell(3);
			cell.setCellValue("Area");
			cell.setCellStyle(style);
			
			cell=row.createCell(4);
			cell.setCellValue("City");
			cell.setCellStyle(style);
			
			cell=row.createCell(5);
			cell.setCellValue("Pincode");
			cell.setCellStyle(style);
			
			row=sheet.createRow(2);
			cell=row.createCell(0);
			cell.setCellValue(companyAddress.get("name"));
			cell.setCellStyle(style1);
			
			cell=row.createCell(1);
			cell.setCellValue(companyAddress.get("doorno"));
			cell.setCellStyle(style1);
			
			cell=row.createCell(2);
			cell.setCellValue(companyAddress.get("street"));
			cell.setCellStyle(style1);
			
			cell=row.createCell(3);
			cell.setCellValue(companyAddress.get("area"));
			cell.setCellStyle(style1);
			
			cell=row.createCell(4);
			cell.setCellValue(companyAddress.get("city"));
			cell.setCellStyle(style1);
			
			cell=row.createCell(5);
			cell.setCellValue(companyAddress.get("pincode"));
			cell.setCellStyle(style1);
			
			sheet.addMergedRegion(CellRangeAddress.valueOf("A4:F4"));
			sheet.addMergedRegion(CellRangeAddress.valueOf("A5:F5"));
			 
			row = sheet.createRow(4); 
			 cell = row.createCell(0);			
			cell.setCellValue(new XSSFRichTextString("Billing - Address"));
			cell.setCellStyle(style);
			
			row=sheet.createRow(5);
			cell=row.createCell(0);
			cell.setCellValue("Name");
			cell.setCellStyle(style);
			
			cell=row.createCell(1);
			cell.setCellValue("Door-no");
			cell.setCellStyle(style);
			
			cell=row.createCell(2);
			cell.setCellValue("Street");
			cell.setCellStyle(style);
			
			cell=row.createCell(3);
			cell.setCellValue("Area");
			cell.setCellStyle(style);
			
			cell=row.createCell(4);
			cell.setCellValue("City");
			cell.setCellStyle(style);
			
			cell=row.createCell(5);
			cell.setCellValue("Pincode");
			cell.setCellStyle(style);
			
			
			row=sheet.createRow(6);
			cell=row.createCell(0);
			cell.setCellValue(billingAddress.get("name"));
			cell.setCellStyle(style1);
			
			cell=row.createCell(1);
			cell.setCellValue(billingAddress.get("doorno"));
			cell.setCellStyle(style1);
			
			cell=row.createCell(2);
			cell.setCellValue(billingAddress.get("street"));
			cell.setCellStyle(style1);
			
			cell=row.createCell(3);
			cell.setCellValue(billingAddress.get("area"));
			cell.setCellStyle(style1);
			
			cell=row.createCell(4);
			cell.setCellValue(billingAddress.get("city"));
			cell.setCellStyle(style1);
			
			cell=row.createCell(5);
			cell.setCellValue(billingAddress.get("pincode"));
			cell.setCellStyle(style1);
			
			sheet.addMergedRegion(CellRangeAddress.valueOf("A8:D8"));
			sheet.addMergedRegion(CellRangeAddress.valueOf("A9:D9"));
			
			row = sheet.createRow(8); 
			 cell = row.createCell(0);			
			cell.setCellValue(new XSSFRichTextString("Products"));
			cell.setCellStyle(style);
			
			row=sheet.createRow(9);
			cell=row.createCell(0);
			cell.setCellValue("Product-Name");
			cell.setCellStyle(style);
			
			cell=row.createCell(1);
			cell.setCellValue("Quantity");
			cell.setCellStyle(style);
			
			cell=row.createCell(2);
			cell.setCellValue("Unit-Price");
			cell.setCellStyle(style);
			
			cell=row.createCell(3);
			cell.setCellValue("Total");
			cell.setCellStyle(style);
			int i=10;
			for(Map.Entry<String, ArrayList<Float>> item: products.entrySet()) {
				row=sheet.createRow(i);
				cell=row.createCell(0);
				cell.setCellValue(item.getKey());
				cell.setCellStyle(style1);
				
				cell=row.createCell(1);
				cell.setCellValue(item.getValue().get(0));
				cell.setCellStyle(style1);
				
				cell=row.createCell(2);
				cell.setCellValue(roundDecimel(item.getValue().get(1),2));
				cell.setCellStyle(style1);
				
				cell=row.createCell(3);
				cell.setCellValue(roundDecimel(item.getValue().get(0)*item.getValue().get(1),2));
				cell.setCellStyle(style1);
				i++;
			}
			ArrayList<Float> calculatedFields=calculate(products, discount, tax);
			row=sheet.createRow(i++);
			cell=row.createCell(2);
			cell.setCellValue("Sub-Total");
			cell.setCellStyle(style);
			
			cell=row.createCell(3);
			cell.setCellValue(calculatedFields.get(0));
			cell.setCellStyle(style1);
			
			row=sheet.createRow(i++);
			cell=row.createCell(2);
			cell.setCellValue("Discount");
			cell.setCellStyle(style);
			
			cell=row.createCell(3);
			cell.setCellValue(roundDecimel(calculatedFields.get(1),2));
			cell.setCellStyle(style1);
			
			row=sheet.createRow(i++);
			cell=row.createCell(2);
			cell.setCellValue("Tax");
			cell.setCellStyle(style);
			
			cell=row.createCell(3);
			cell.setCellValue(roundDecimel(calculatedFields.get(2),2));
			cell.setCellStyle(style1);
			
			row=sheet.createRow(i++);
			cell=row.createCell(2);
			cell.setCellValue("Total");
			cell.setCellStyle(style);
			
			cell=row.createCell(3);
			cell.setCellValue(roundDecimel(calculatedFields.get(3),2));
			cell.setCellStyle(style);
			
			for(i=0;i<sheet.getRow(1).getPhysicalNumberOfCells(); i++) {
				sheet.autoSizeColumn(i);
			}
			try {
			    FileOutputStream out = new FileOutputStream(f);
			    workbook.write(out);
			    out.close();
			    System.out.println("Excel invoice generated...");
			} catch (FileNotFoundException e) {
			    e.printStackTrace();
			} catch (IOException e) {
			    e.printStackTrace();
			}
			workbook.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
}

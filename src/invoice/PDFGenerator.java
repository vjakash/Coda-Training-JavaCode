package invoice;

import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFGenerator extends InvoiceGenerator {
	private static DecimalFormat df = new DecimalFormat("0.00");
	@Override
	public void generate(String invoiceNumber,Map<String,String> companyAddress,Map<String,String> billingAddress,Map<String,ArrayList<Float>> products,float discount,float tax) {
		try {
			String fileName="/Users/vj/eclipse-workspace/JavaTraining/invoices/"+invoiceNumber+".pdf";
			Document document=new Document();
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(fileName));
			document.open();
			
			//fonts and colors
			final CMYKColor blueColor=new CMYKColor(255, 0, 0, 0);
			final CMYKColor whiteColor=new CMYKColor(1, 1, 1, 1);
			final Font whiteFont = FontFactory.getFont(FontFactory.HELVETICA, 14, Font.NORMAL, whiteColor);
			final Font blueFont = FontFactory.getFont(FontFactory.HELVETICA, 26, Font.NORMAL, blueColor);
			final Font redFont = FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLD, new CMYKColor(0, 255, 0, 0));
			final Font yellowFont = FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD, new CMYKColor(0, 0, 255, 0));
			
			//top rectangle bar
	        PdfContentByte canvas = writer.getDirectContent();
	        Rectangle rect1 = new Rectangle(0, 900, 600, 806);//lower left x,lower left y, upper right x,upper right y
	        rect1.setBackgroundColor(new CMYKColor(255, 0, 0, 0));
	        rect1.setBorder(Rectangle.BOX);
	        rect1.setBorderWidth(1);
	        canvas.rectangle(rect1);
	        
			//logo of company
			Image image1 = Image.getInstance("/Users/vj/eclipse-workspace/JavaTraining/presidio-logo.png");
			image1.setAbsolutePosition(400f, 675f);
			image1.scaleAbsolute(200, 200);
			document.add(image1);
			
	        //company details
			Paragraph para1=new Paragraph("Presidio",blueFont);
			document.add(para1);
			
			 para1=new Paragraph(companyAddress.get("doorno")+","+companyAddress.get("street"));
			document.add(para1);
			
			PdfPTable table = new PdfPTable(3);
			table.setWidthPercentage(100);
			table.setSpacingBefore(5f);
			table.addCell(getCell(companyAddress.get("area"), Element.ALIGN_LEFT));
			table.addCell(getCell("", Element.ALIGN_CENTER));
			table.addCell(getCell("Date: "+LocalDateTime.now().toLocalDate().toString(), Element.ALIGN_RIGHT));
			document.add(table);
			
			table = new PdfPTable(3);
			float[] columnWidths = { 1f, 0.5f, 1.5f };//column width
			table.setWidths(columnWidths);
			table.setWidthPercentage(100);
			table.setSpacingBefore(5f);
			table.addCell(getCell(companyAddress.get("city")+"-"+companyAddress.get("pincode"), Element.ALIGN_LEFT));
			table.addCell(getCell("", Element.ALIGN_CENTER));
			table.addCell(getCell("Invoice Number: "+invoiceNumber, Element.ALIGN_RIGHT));
			document.add(table);

			//billing address
			para1=new Paragraph("Bill To",blueFont);
			para1.setSpacingBefore(17);
			document.add(para1);
			
			//line below billing address
			rect1 = new Rectangle(36,656,580,656f);
	        rect1.setBackgroundColor(blueColor);
	        rect1.setBorder(Rectangle.BOX);
	        rect1.setBorderWidth(1);
	        canvas.rectangle(rect1);
	        
			
			para1=new Paragraph(billingAddress.get("name"),FontFactory.getFont(FontFactory.HELVETICA, 14, Font.NORMAL, blueColor));
			para1.setSpacingBefore(10f);
			para1.setIndentationLeft(15);
			document.add(para1);
			
			para1=new Paragraph(billingAddress.get("doorno")+","+billingAddress.get("street"));
			para1.setIndentationLeft(15);
			document.add(para1);
			
			para1=new Paragraph(billingAddress.get("area"));
			para1.setIndentationLeft(15);
			document.add(para1);
			
			para1=new Paragraph(billingAddress.get("city")+"-"+billingAddress.get("pincode"));
			para1.setIndentationLeft(15);
			document.add(para1);
			
			//products list table
			table=new PdfPTable(4);
			table.setWidthPercentage(100); // Width 100%
			table.setSpacingBefore(20f); // Space before table
			table.setSpacingAfter(10f); // Space after table
			 columnWidths =new float[] { 2f,1f, 1f, 1f };//column width
			table.setWidths(columnWidths);
			
			PdfPCell cell1 = new PdfPCell(new Paragraph("Description",whiteFont));
			cell1.setPadding(10);
			cell1.setPaddingBottom(10);
			cell1.setBackgroundColor(blueColor);
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);

			PdfPCell cell2 = new PdfPCell(new Paragraph("QTY",whiteFont));
			cell2.setBackgroundColor(blueColor);
			cell2.setPadding(10);
			cell2.setPaddingBottom(10);
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);

			PdfPCell cell3 = new PdfPCell(new Paragraph("Unit Price",whiteFont));
			cell3.setBackgroundColor(blueColor);
			cell3.setPadding(10);
			cell3.setPaddingBottom(10);
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			
			PdfPCell cell4 = new PdfPCell(new Paragraph("Total",whiteFont));
			cell4.setBackgroundColor(blueColor);
			cell4.setPadding(10);
			cell4.setPaddingBottom(10);
			cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);

			table.addCell(cell1);
			table.addCell(cell2);
			table.addCell(cell3);
			table.addCell(cell4);
			
			for(Map.Entry<String, ArrayList<Float>> pair : products.entrySet()) {
				 cell1 = new PdfPCell(new Paragraph(pair.getKey()));
				cell1.setPadding(10);
				cell1.setPaddingBottom(10);
				cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
								
				cell2 = new PdfPCell(new Paragraph(pair.getValue().get(0).toString()));
				cell2.setPadding(10);
				cell2.setPaddingBottom(10);
				cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);

				 cell3 = new PdfPCell(new Paragraph(pair.getValue().get(1).toString()));
				cell3.setPadding(10);
				cell3.setPaddingBottom(10);
				cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
				
				 cell4 = new PdfPCell(new Paragraph(""+(pair.getValue().get(0)*pair.getValue().get(1))));
				cell4.setPadding(10);
				cell4.setPaddingBottom(10);
				cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);

				table.addCell(cell1);
				table.addCell(cell2);
				table.addCell(cell3);
				table.addCell(cell4);
			}
			document.add(table);

			ArrayList<Float> calculatedFields=calculate(products, discount, tax);
			table = new PdfPTable(3);
			columnWidths = new float[] { 7f, 1f, 1f };//column width
			table.setWidths(columnWidths);
			table.setWidthPercentage(100);
			table.setSpacingBefore(5f);
			table.addCell(getCell("Sub Total:", Element.ALIGN_RIGHT));
			table.addCell(getCell("", Element.ALIGN_CENTER));
			table.addCell(getCell(df.format(calculatedFields.get(0)), Element.ALIGN_CENTER));
			document.add(table);
			
			table = new PdfPTable(3);
			columnWidths = new float[] { 7f, 1f, 1f };//column width
			table.setWidths(columnWidths);
			table.setWidthPercentage(100);
			table.setSpacingBefore(5f);
			table.addCell(getCell("Discount:", Element.ALIGN_RIGHT));
			table.addCell(getCell("", Element.ALIGN_CENTER));
			table.addCell(getCell("-"+df.format(calculatedFields.get(1)), Element.ALIGN_CENTER));
			document.add(table);
			
			table = new PdfPTable(3);
			columnWidths = new float[] { 7f, 1f, 1f };//column width
			table.setWidths(columnWidths);
			table.setWidthPercentage(100);
			table.setSpacingBefore(5f);
			table.addCell(getCell("Tax:", Element.ALIGN_RIGHT));
			table.addCell(getCell("", Element.ALIGN_CENTER));
			table.addCell(getCell("+"+df.format(calculatedFields.get(2)), Element.ALIGN_CENTER));
			document.add(table);
			
			rect1 = new Rectangle(356,290,580,290f);
	        rect1.setBackgroundColor(blueColor);
	        rect1.setBorder(Rectangle.BOX);
	        rect1.setBorderWidth(1);
	        canvas.rectangle(rect1);
	        
			table = new PdfPTable(3);
			columnWidths = new float[] { 7f, 1f, 1f };//column width
			table.setWidths(columnWidths);
			table.setWidthPercentage(100);
			table.setSpacingBefore(17f);
			table.addCell(getCell("Total:", Element.ALIGN_RIGHT));
			table.addCell(getCell("", Element.ALIGN_CENTER));
			table.addCell(getCell(df.format(calculatedFields.get(3)), Element.ALIGN_CENTER));
			document.add(table);

			
			document.close();
			System.out.println("Invoice PDF Generated");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	private static PdfPCell getCell(String text, int alignment) {
		PdfPCell cell = new PdfPCell(new Paragraph(text));
	    cell.setPadding(0);
	    cell.setHorizontalAlignment(alignment);
	    cell.setBorderWidth(0);;
	    return cell;
	}
}

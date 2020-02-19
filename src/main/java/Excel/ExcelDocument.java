package Excel;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import Entity.Customer;

public class ExcelDocument extends AbstractExcelView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setHeader("Content-Disposition", "attachment;filename=\"user_list.xls\"");
		List<Customer> user=(List<Customer>) model.get("customers");
		Sheet sheet=workbook.createSheet("Customer");
		
		 // create style for header cells
	    CellStyle style = workbook.createCellStyle();
	    Font font = workbook.createFont();
	    font.setFontName("Arial");
	    style.setFillForegroundColor(HSSFColor.BLUE.index);
	    //style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	    //font.setBold(true);
	    font.setColor(HSSFColor.BLACK.index);
	    style.setFont(font);
		
		Row header=sheet.createRow(0);
		
		header.createCell(0).setCellValue("ID");
		 header.getCell(0).setCellStyle(style);
		header.createCell(1).setCellValue("firstName");
		 header.getCell(1).setCellStyle(style);
		header.createCell(2).setCellValue("lastName");
		 header.getCell(2).setCellStyle(style);
		header.createCell(3).setCellValue("email");
		 header.getCell(3).setCellStyle(style);
		
		int rownum=1;
		
		for(Customer cust:user) {
			Row row=sheet.createRow(rownum++);
			
			row.createCell(0).setCellValue(cust.getId());
			row.createCell(1).setCellValue(cust.getFirstName());
			row.createCell(2).setCellValue(cust.getLastName());
			row.createCell(3).setCellValue(cust.getEmail());
			
		}
		
	}

}

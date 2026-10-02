package com.canteen.canteenms.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.canteen.canteenms.model.FoodList;
import com.canteen.canteenms.model.UserList;

public class UserExcelExporter {
	
	private HSSFWorkbook workbook;
	
	private HSSFSheet sheet;
	
	private List<UserList> userList;
	
	
	public UserExcelExporter(List<UserList> userList) {
		super();
		this.workbook = new HSSFWorkbook();
		this.sheet = workbook.createSheet("UserReport");
		this.userList = userList;
	}

	private void writeHeaderRow() {
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue("User ID");
		
		cell = row.createCell(1);
		cell.setCellValue("User Name");
		
		cell = row.createCell(2);
		cell.setCellValue("Preference");
		
		cell = row.createCell(3);
		cell.setCellValue("Email");
		
		cell = row.createCell(4);
		cell.setCellValue("Role");
	}
	
	private void writeDataRows() {
		int rowIndex = 1;
		
		for(UserList user : userList) {
			Row row = sheet.createRow(rowIndex);
			Cell cell = row.createCell(0);
			cell.setCellValue(user.getUserId());
			
			cell = row.createCell(1);
			cell.setCellValue(user.getName());
			
			cell = row.createCell(2);
			cell.setCellValue(user.getPreference());
			
			cell = row.createCell(3);
			cell.setCellValue(user.getUserEmail());
			
			cell = row.createCell(4);
			cell.setCellValue(user.getRole());
			
			rowIndex++;
		}
	}
	
	public void export(HttpServletResponse response) {
		writeHeaderRow();
		writeDataRows();
		
		try {
			ServletOutputStream outputStream = response.getOutputStream();
			workbook.write(outputStream);
			workbook.close();
			outputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

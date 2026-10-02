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

public class FoodExcelExporter {
	
	private HSSFWorkbook workbook;
	
	private HSSFSheet sheet;
	
	private List<FoodList> foodList;
	
	
	public FoodExcelExporter(List<FoodList> foodList) {
		super();
		this.workbook = new HSSFWorkbook();
		this.sheet = workbook.createSheet("Menu");
		this.foodList = foodList;
	}

	private void writeHeaderRow() {
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue("Food ID");
		
		cell = row.createCell(1);
		cell.setCellValue("Food Name");
		
		cell = row.createCell(2);
		cell.setCellValue("Food Type");
		
		cell = row.createCell(3);
		cell.setCellValue("Meal");
		
		cell = row.createCell(4);
		cell.setCellValue("Food Price");
	}
	
	private void writeDataRows() {
		int rowIndex = 1;
		
		for(FoodList food : foodList) {
			Row row = sheet.createRow(rowIndex);
			Cell cell = row.createCell(0);
			cell.setCellValue(food.getFoodId());
			
			cell = row.createCell(1);
			cell.setCellValue(food.getFoodName());
			
			cell = row.createCell(2);
			cell.setCellValue(food.getCategory());
			
			cell = row.createCell(3);
			cell.setCellValue(food.getMeal());
			
			cell = row.createCell(4);
			cell.setCellValue(food.getFoodPrice());
			
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

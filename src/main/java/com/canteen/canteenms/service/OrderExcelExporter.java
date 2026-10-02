package com.canteen.canteenms.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;

import com.canteen.canteenms.model.FoodList;
import com.canteen.canteenms.model.OrderList;
import com.canteen.canteenms.model.UserList;
import com.canteen.canteenms.model.UserReport;

public class OrderExcelExporter {

	private UserService adminUserService = new UserServiceImpl();

	private HSSFWorkbook workbook;

	private HSSFSheet sheet;

	private List<UserReport> orderList;

	public OrderExcelExporter(List<UserReport> userReport) {
		super();
		this.workbook = new HSSFWorkbook();
		this.sheet = workbook.createSheet("OrderReport");
		this.orderList = userReport;
	}

	private void writeHeaderRow() {
		Row row = sheet.createRow(0);

		Cell cell = row.createCell(0);
		cell.setCellValue("User ID");

		cell = row.createCell(1);
		cell.setCellValue("User Name");

		cell = row.createCell(2);
		cell.setCellValue("Total Breakfast");

		cell = row.createCell(3);
		cell.setCellValue("Total Lunch");

		cell = row.createCell(4);
		cell.setCellValue("Total Opt-Out");

		cell = row.createCell(5);
		cell.setCellValue("Total Both");

	}

	private void writeDataRows() {
		int rowIndex = 1;

		for (UserReport order : orderList) {
			Row row = sheet.createRow(rowIndex);
			Cell cell = row.createCell(0);
			cell.setCellValue(order.getUserId());

			cell = row.createCell(1);
			cell.setCellValue(order.getUserName());

			cell = row.createCell(2);
			cell.setCellValue(order.getNoOfBreakfast());

			cell = row.createCell(3);
			cell.setCellValue(order.getNoOfLunch());

			cell = row.createCell(4);
			cell.setCellValue(order.getNoOfOptOut());
			
			cell = row.createCell(5);
			cell.setCellValue(order.getNoOfBoth());

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

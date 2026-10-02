package com.canteen.canteenms.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.canteen.canteenms.model.FoodList;
import com.canteen.canteenms.model.OrderList;
import com.canteen.canteenms.model.UserList;
import com.canteen.canteenms.model.UserReport;
import com.canteen.canteenms.service.AdminService;
import com.canteen.canteenms.service.AdminServiceImpl;
import com.canteen.canteenms.service.AdminUserService;
import com.canteen.canteenms.service.AdminUserServiceImpl;
import com.canteen.canteenms.service.FoodExcelExporter;
import com.canteen.canteenms.service.OrderExcelExporter;
import com.canteen.canteenms.service.ReportService;
import com.canteen.canteenms.service.UserExcelExporter;
import com.canteen.canteenms.service.UserService;

@Controller
public class AdminMenuController {

	// Object of AdminService
	@Autowired
	AdminServiceImpl as;

	@Autowired
	AdminUserServiceImpl adminUserServiceImpl;

	@Autowired
	private AdminUserService adminuserReport;

	@Autowired
	private ReportService report;

	@Autowired
	private UserService userService;

	// To show the admin dashboard page
	@RequestMapping("/admin/")
	public String showAdminDashboard(Principal admin, Model model) {
		UserList userList = this.userService.getUserDetailsByEmail(admin.getName());
		model.addAttribute("adminName", userList.getName());
		//System.out.println(userList.getUserEmail());
		return "admindashboard.html";
	}

	// To show the existing menu fetched from database
	@GetMapping("/admin/menu")
	public String showMenu(Model model) {
		model.addAttribute("foodList", as.getAllFoodItems());
		return "adminMenu.html";
	}

	// To show the form for adding food items
	@RequestMapping("/admin/addItemForm")
	public String addMenuPage() {
		return "addFoodForm.html";
	}

	// To handle response after submitting the add food form
	@PostMapping("/admin/addItem/")
	public String addMenu(@ModelAttribute FoodList food) {
		//System.out.println(food);
		String msg = as.addFoodItem(food);
		if (msg.equals("Success")) {
			return "redirect:/admin/menu";
		} else {
			return "redirect:/admin/addItemForm";
		}
	}

	// To show the update food item form
	@RequestMapping("/admin/update/{foodId}")
	public String showUpdateMenuForm(@PathVariable String foodId, Model model) {
		long fId = Long.parseLong(foodId);
		FoodList food = as.getFoodById(fId);
		model.addAttribute("food", food);
		return "updateFoodForm.html";
	}

	// Update the food details for the food submitted
	@PostMapping("/admin/updateItem/")
	public String submitUpdateForm(@ModelAttribute FoodList food) {
		try {
			as.updateFoodItem(food);
		} catch (Exception e) {
			return "updateFoodForm.html";
		}
		return "redirect:/admin/menu";
	}

	// To update an existing food item
	@RequestMapping("/admin/delete/{FoodId}")
	public String showConfirmDelete(@PathVariable String FoodId, Model model) {
		int fId = Integer.parseInt(FoodId);
		FoodList food = as.getFoodById(fId);
		model.addAttribute("food", food);
		return "deleteConfirm.html";
	}

	// To delete food item from menu
	@RequestMapping("/admin/confirmdelete/{FoodId}")
	public String deleteMenu(@PathVariable String FoodId) {
		// as.deleteFoodById(Integer.parseInt(FoodId));
		FoodList food = as.getFoodById(Long.parseLong(FoodId));
		food.setFoodStatus("Unavailable");
		as.updateFoodItem(food);
		return "redirect:/admin/menu";
	}

	@RequestMapping("/admin/exportOptions")
	public String showExportOptions() {
		return "exportOptions.html";
	}

	// export menu report
	@GetMapping("/admin/menuReport")
	public void exportMenuReport(HttpServletResponse response) {
		response.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=Menu.xls";

		response.setHeader(headerKey, headerValue);
		List<FoodList> foodList = as.getAllFoodItems();

		FoodExcelExporter excelExporter = new FoodExcelExporter(foodList);
		excelExporter.export(response);
	}

	// export user details report
	@GetMapping("/admin/userReport")
	public void exportUserReport(HttpServletResponse response) {
		response.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=UserReport.xls";

		response.setHeader(headerKey, headerValue);
		List<UserList> userList = adminUserServiceImpl.viewAllUser();

		UserExcelExporter excelExporter = new UserExcelExporter(userList);
		excelExporter.export(response);
	}

	// export order details
	@GetMapping("/admin/orderReport")
	public void exportOrderReport(HttpServletResponse response) {
		
		response.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=OrderReport.xls";

		response.setHeader(headerKey, headerValue);


		List<UserList> userList = adminuserReport.viewAllUser();
		List<UserReport> userReport = new ArrayList<>();
		List<FoodList> foodList = new ArrayList<>();
		long breakfast=0, lunch=0, optOut=0, both=0;
		for (UserList user : userList) {
			breakfast = 0;
			lunch = 0;
			optOut = 0;
			both = 0;

			List<OrderList> orderList = this.report.findAllOrder(user.getUserId());
			//System.out.println(orderList);
			orderList.sort((o1, o2) -> o1.getSavetime().compareTo(o2.getSavetime()));

			for (int i = orderList.size() - 1; i >= 0; i--) {
				if (orderList.get(i).getOrderStatus().equals("OptOut")) {
					optOut++;
					orderList.remove(i);
				}
			}
			System.out.println(orderList);
			for (OrderList order : orderList) {
				foodList.add(this.userService.findById(order.getFoodId()));
			}
			if (orderList.size() > 1) {
				for (int i = orderList.size() - 1; i >= 1; i--) {
					if (orderList.get(i).getSavetime().equals(orderList.get(i - 1).getSavetime())) {
						if (foodList.get(i).getMeal().equals(foodList.get(i - 1).getMeal())) {
							foodList.remove(i);
							orderList.remove(i);
						}
					}
				}
				for (int i = orderList.size() - 1; i >= 1; i--) {
					if (orderList.get(i).getSavetime().equals(orderList.get(i - 1).getSavetime())) {
						if (!foodList.get(i).getMeal().equals(foodList.get(i - 1).getMeal())) {
							both++;
							orderList.remove(i);
							foodList.remove(i);
							i--;
							orderList.remove(i);
							foodList.remove(i);
						}
					}
				}
			}
			for (int i = foodList.size() - 1; i >= 0; i--) {
				if (foodList.get(i).getMeal().equals("Breakfast")) {
					breakfast++;
				} else {
					lunch++;
				}
			}
			System.out.println(lunch);

			userReport.add(new UserReport(user.getUserId(), user.getName(), breakfast, lunch, optOut, both));
			
			foodList.clear();

		}
		OrderExcelExporter ordEx = new OrderExcelExporter(userReport);

		ordEx.export(response);
	}

}

package com.canteen.canteenms.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.canteen.canteenms.model.ResetPassword;
import com.canteen.canteenms.model.UserList;
import com.canteen.canteenms.model.Users;
import com.canteen.canteenms.service.ResetPasswordService;
import com.canteen.canteenms.service.UserService;

@Controller
public class ResetPasswordController {
	@Autowired
	ResetPasswordService rps;
	
	@Autowired
	UserService userService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	
	@RequestMapping("/admin/resetPasswordForm")
	public String PasswordPageAdmin() {
		
		return "ResetPasswordFormAdmin.html";
	}
	
	
	@RequestMapping("/user/resetPasswordForm")
	public String PasswordPageUser() {
		
		return "ResetPasswordFormUser.html";
	}
	
	
	@RequestMapping("/resetadmin" )
	public ModelAndView resetadminpassword(Principal admin,@ModelAttribute ResetPassword rpassword)
	{
		ModelAndView model = new  ModelAndView();
		UserList userobj= this.userService.getUserDetailsByEmail(admin.getName());
		Users usersobj = this.rps.getUsers(admin.getName());
		
		if(passwordEncoder.matches(rpassword.getOldpassword(), userobj.getPassword())){
			userobj.setPassword(passwordEncoder.encode(rpassword.getPassword()));
			usersobj.setPassword(passwordEncoder.encode(rpassword.getPassword()));
			this.rps.resetPassword(userobj);
			this.rps.resetUsersPassword(usersobj);
			model.addObject("msg","Password Updated Successfully");
			model.setViewName("resetPasswordFormAdmin.html");
			return model;
		}
		model.addObject("msg","Incorrect Old Password");
		model.setViewName("resetPasswordFormAdmin.html");
		return model;
	}
	
	
	@RequestMapping(value="/resetuser" ,method=RequestMethod.POST)
	public ModelAndView resetuserpassword(Principal user,@ModelAttribute ResetPassword rpassword)
	{
		
		ModelAndView model = new  ModelAndView();
		UserList userobj= this.userService.getUserDetailsByEmail(user.getName());
		Users usersobj = this.rps.getUsers(user.getName());
		
		//rpassword.setOldpassword(passwordEncoder.encode(rpassword.getOldpassword()));
		//System.out.println(userobj.getPassword()+" "+rpassword.getOldpassword());
		if(passwordEncoder.matches(rpassword.getOldpassword(), userobj.getPassword())) {
			System.out.println(rpassword.getPassword());
			userobj.setPassword(passwordEncoder.encode(rpassword.getPassword()));
			usersobj.setPassword(passwordEncoder.encode(rpassword.getPassword()));
			this.rps.resetPassword(userobj);
			model.addObject("msg","Password Updated Successfully");
			model.setViewName("resetPasswordFormAdmin.html");
			return model;
		}
		model.addObject("msg","Incorrect Old Password");
		model.setViewName("resetPasswordFormUser.html");
		return model;
	
	}
	
	
	
	/*
	 * @RequestMapping(value="/resetuser" ) public String
	 * resetuserpassword(Principal admin,@ModelAttribute ResetPassword
	 * rpassword,Model model) { UserList userobj= this.rps.getUser(admin.getName());
	 * if(userobj.getPassword() == rpassword.getOldpassword()) {
	 * userobj.setPassword(rpassword.getPassword());
	 * this.rps.resetPassword(userobj);
	 * model.addAttribute("msg","Successfully Updated Password"); return
	 * "redirect:/user/resetPasswordForm"; }
	 * model.addAttribute("msg","Old Password Incoreect"); return
	 * "redirect:/user/resetPasswordForm"; }
	 */

}

package com.payments.controller;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.payments.model.Login;
import com.payments.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	private LoginService userService;

	@PostMapping(path = "/login")
	public ResponseEntity<String> login(@RequestBody Login user) {
//		logger.info("Loging in user..........");
		Login oauthUser = userService.login(user.getLogin_id(), user.getPassword());
		String result = "";
		if (oauthUser == null) {
			//logger.info("Loging failed as user provided wrong credentials");
			result = "Wrong credentials. Please try again with correct ID and password";
			return new ResponseEntity<String>(result, HttpStatus.BAD_REQUEST);
		}
		result = "Login successful";
//		logger.info(user.getUserId() + " log in successful and user has a role: " + result);
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}

//	@GetMapping("/login")
//
//	public ModelAndView login() {
//		ModelAndView mav = new ModelAndView("login");
//		mav.addObject("user", new Login());
//		return mav;
//	}
//
//	@PostMapping("/login")
//	public String login(@ModelAttribute("user") Login user) {
//
//		Login oauthUser = userService.login(user.getLogin_id(), user.getPassword());
//
//		System.out.print(oauthUser);
//		if (Objects.nonNull(oauthUser)) {
//
//			return "redirect:/";
//
//		} else {
//			return "redirect:/login";
//
//		}
//
//	}
//
//	@RequestMapping(value = { "/logout" }, method = RequestMethod.POST)
//	public String logoutDo(HttpServletRequest request, HttpServletResponse response) {
//
//		return "redirect:/login";
//	}

}
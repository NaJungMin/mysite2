package com.bit2015.mysite2.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit2015.mysite2.service.UserService;
import com.bit2015.mysite2.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping( "/joinform" )
	public String joinform() {
		return "user/joinform";
	}

	@RequestMapping( "/joinsuccess" )
	public String joinSuccess() {
		return "user/joinsuccess";
	}

	@RequestMapping( "/loginform" )
	public String loginform() {
		return "user/loginform";
	}
	
	@RequestMapping( "/login" )
	public String login( HttpSession session, @ModelAttribute UserVo userVo ) {
		UserVo vo = userService.login( userVo );
		if( vo == null ) {
			return "redirect:/user/loginform";
		}
		
		// 로긴처리
		session.setAttribute( "authUser", vo );
		return "redirect:/";
	}	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		//session = session.getSession();
		if(session == null){
			return "redirect:/";
		}
		
		//로그아웃처리
		session.removeAttribute("authUser");
		session.invalidate();
		
		return "redirect:/";
	}
	
	
	@RequestMapping( "/join" )
	public String join( @ModelAttribute UserVo userVo ) {
		userService.join( userVo );
		return "redirect:/user/joinsuccess";
		//return "user/joinsuccess";
	}
	
	@RequestMapping("/modifyform")
	public String updateform() {
		
		return "user/modifyform";
	}
	
	@RequestMapping("/modify")
	public String modifyform(@ModelAttribute UserVo userVo, String repassword) {
		System.out.println("UserController:" + userVo);
		System.out.println(repassword);
		userVo.setPassword(repassword);
		
		userService.update(userVo);
		return "redirect:/user/modifysuccess";
	}
	
	@RequestMapping("/modifysuccess")
	public String modifysuccess() {
		
		return "user/modifysuccess";
	}

	@RequestMapping("/checkemail")
	@ResponseBody
	public Object checkemail(String email) {
		UserVo userVo = null;
		System.out.println("checkemail : " + email);
		userVo = userService.checkemail(email);
		
		Map<String, String> map = new HashMap<String, String>();
		
		if(userVo == null){
			map.put("result", "not exist");
		}else {
			map.put("result", "exist");
		}
		//System.out.println(map);
		return map;
	}
	
}
package com.bit2015.mysite2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit2015.mysite2.service.GuestBookService;
import com.bit2015.mysite2.vo.GuestBookVo;

@Controller
@RequestMapping("/guestbook")
public class GuestBookController {
	
	@Autowired
	GuestBookService guestBookService;
	
	@RequestMapping("")
	public String guestbook() {
		return "redirect:/guestbook/list";
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		List<GuestBookVo> list = guestBookService.getList();
		model.addAttribute("list", list);
		return "guestbook/list";
	}
	
	@RequestMapping("/insert")
	public String insert(@ModelAttribute GuestBookVo guestBookVo, Model model){
		guestBookService.insert(guestBookVo);
		return "redirect:/guestbook/list";
	}
	
	@RequestMapping("/deleteform/{no}")
	public String deleteform(@PathVariable("no") long no){
		//System.out.println(no);
		//guestBookService.delete(no);
		//guestBookService.delete("나","나나");
		return "guestbook/deleteform";
	}
	
	@RequestMapping("/delete/{no}")
	public String delete(@PathVariable("no") long no, String password){
		//guestBookService.delete(guestBookVo);
		System.out.println("delete no : " + no + "\t password : " + password);
		guestBookService.delete(no, password);
		return "redirect:/guestbook/list";
	}
	
	
	/* @RequestMapping("/login")
	public String login(HttpSession session, @ModelAttribute UserVo userVo) {
		UserVo vo = userService.login(userVo);
		if(vo == null){
			return "redirect:/user/loginform";
		}
		
		// 로긴 처리
		session.setAttribute("authUser", vo);
		
		return "redirect:/";
	}*/
	
	
	
	
	/*	@RequestMapping("/joinsuccess")
	public String joinsuccess() {
		return "user/joinsuccess";
	}
	
	@RequestMapping("/loginform")
	public String loginform() {
		return "user/loginform";
	}
	
	@RequestMapping("/login")
	public String login(HttpSession session, @ModelAttribute UserVo userVo) {
		UserVo vo = userService.login(userVo);
		if(vo == null){
			return "redirect:/user/loginform";
		}
		
		// 로긴 처리
		session.setAttribute("authUser", vo);
		
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
	
	@RequestMapping("/join")
	public String join(@ModelAttribute UserVo userVo) {
		System.out.println(userVo);
		userService.join(userVo);
		return "redirect:/user/joinsuccess";
	}
	
	@RequestMapping("/updateform")
	public String updateform() {
		
		return "user/updateform";
	}
	
	@RequestMapping("/update")
	public String updateform(@ModelAttribute UserVo userVo, String repassword) {
		System.out.println("UserController:" + userVo);
		System.out.println(repassword);
		userVo.setPassword(repassword);
		
		userService.update(userVo);
		return "redirect:/user/updatesuccess";
	}
	
	@RequestMapping("/updatesuccess")
	public String updatesuccess() {
		
		return "user/updatesuccess";
	}*/
	
}

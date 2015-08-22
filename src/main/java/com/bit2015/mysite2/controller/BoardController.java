package com.bit2015.mysite2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit2015.mysite2.service.BoardService;
import com.bit2015.mysite2.vo.BoardVo;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping("")
	public String guestbook() {
		return "redirect:/board/list";
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		List<BoardVo> list = boardService.getList();
		model.addAttribute("list", list);
		return "board/list";
	}
	
	@RequestMapping("/writeform")
	public String writeform(@ModelAttribute BoardVo boardVo, Model model){
		return "board/write";
	}
	
	@RequestMapping("/write")
	public String write(@ModelAttribute BoardVo boardVo, Model model){
		System.out.println("board controller : " + boardVo);
		boardService.write(boardVo);
		return "redirect:/board/list";
	}
	
	@RequestMapping("/view/{no}")
	public String view(@PathVariable("no") long no, Model model){
		System.out.println("board controller : " + no);
		//System.out.println("board controller : " + boardVo);
		BoardVo vo = boardService.getView(no);
		model.addAttribute("vo",vo);
		System.out.println("board controller : " + vo);
		return "board/updateform";
	}
	
	//updateform 보드 수정작업 
	@RequestMapping("/updateform/{no}")
	//@ResponseBody
	public String updateform(@PathVariable("no") long no, BoardVo boardVo){
		System.out.println("board controller : " + no);
		System.out.println("board controller : " + boardVo);
		boardService.updateform(no, boardVo);
		//model.addAttribute("vo",vo);
		System.out.println("board controller : " + boardVo);
		return "redirect:/board/list";
	}
	
	@RequestMapping("/delete/no/{no}&member_no/{member_no}")
	//@ResponseBody
	public String delete(@PathVariable("no") long no, @PathVariable("member_no") long member_no){
		//System.out.println(boardVo);
		System.out.println("board controller : " + no);
		System.out.println("board controller : " + member_no);
		//System.out.println("board controller : " + boardVo);
		boardService.delete(no, member_no);
		//model.addAttribute("vo",vo);
		//System.out.println("board controller : " + boardVo);
		return "redirect:/board/list";
	}
	
	
	/*			String sno=request.getParameter("no");
			long no = Long.parseLong(sno);
			BoardDao dao = BoardDao.getInstance();
			BoardVo vo = dao.getView(no);
			dao.plusCnt(no);
			request.setAttribute( "vo", vo );
			
			ReplyDao rdao = ReplyDao.getInstance();
			List<ReplyVo> rvo = rdao.getList(no);
			request.setAttribute("rvo", rvo);
			
			request.setAttribute("post_no", no);
			
			WebUtil.forward(request, response, "/views/board/view.jsp" );*/
	
	/*
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
	}*/
	

}

package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
//servlet context에 등록해주고 @controller 하면 spring에서관리함
@Controller
@RequestMapping("/board/*")
@AllArgsConstructor//생성자 생성된거까지 @data 해주는것
@Log4j
public class BoardController {
	
	@Autowired //생성자가 실행될때 객체를 주입.
	private BoardService service;
	

	@GetMapping("/list")//get방식중에 list라는게 들어오면 list 메소드 실행하겠다
	public void list(Model model,Criteria cri ) {
		log.info("list");
		model.addAttribute("list",service.getList(cri));
		int totalCnt = service.getTotalCount(cri);
		model.addAttribute("pageMaker",new PageDTO(cri,totalCnt));
	}
	//등록구현메소드
	@PostMapping("/register")
	public String register(BoardVO board , RedirectAttributes rttr) {
		service.register(board);
		
		rttr.addFlashAttribute("result","게시글"+board.getBno()+"번이 등록");
		return "redirect:/board/list";
	}
	
	//등록페이지이동
	@GetMapping("/register")
	public void register() {
		
	}
	
	@GetMapping({"/get","/modify"})
	public void get (@RequestParam("bno")Long bno , Model model, @ModelAttribute("cri") Criteria cri) {
		model.addAttribute("board",service.get(bno));
	}
	
	
	@PostMapping("/modify")
	public String modify(BoardVO board , @ModelAttribute("cri") Criteria cri , RedirectAttributes rttr) {
		
		if(service.modify(board)) {
			rttr.addFlashAttribute("result","success");	
		}
		//rttr.addAttribute("pageNum",cri.getPageNum());
		//rttr.addAttribute("amount",cri.getAmount());
		//rttr.addAttribute("type",cri.getType());
		//rttr.addAttribute("keyword",cri.getKeyword());
		return "redirect:/board/list"+cri.getListLink();		
	}
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno , @ModelAttribute("cri") Criteria cri , RedirectAttributes rttr) {
		System.out.println(123);
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result","success");
		}
		//rttr.addAttribute("pageNum",cri.getPageNum());
		//rttr.addAttribute("amount",cri.getAmount());
		//rttr.addAttribute("type",cri.getType());
		//rttr.addAttribute("keyword",cri.getKeyword());
		return "redirect:/board/list"+cri.getListLink();
	}
	

}

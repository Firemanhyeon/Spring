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
//servlet context�뿉 �벑濡앺빐二쇨퀬 @controller �븯硫� spring�뿉�꽌愿�由ы븿
@Controller
@RequestMapping("/board/*")
@AllArgsConstructor//�깮�꽦�옄 �깮�꽦�맂嫄곌퉴吏� @data �빐二쇰뒗寃�
@Log4j
public class BoardController {
	
	@Autowired //�깮�꽦�옄媛� �떎�뻾�맆�븣 媛앹껜瑜� 二쇱엯.
	private BoardService service;
	

	@GetMapping("/list")//get諛⑹떇以묒뿉 list�씪�뒗寃� �뱾�뼱�삤硫� list 硫붿냼�뱶 �떎�뻾�븯寃좊떎
	public void list(Model model,Criteria cri ) {
		log.info("list");
		model.addAttribute("list",service.getList(cri));
		int totalCnt = service.getTotalCount(cri);
		model.addAttribute("pageMaker",new PageDTO(cri,totalCnt));
	}
	//�벑濡앷뎄�쁽硫붿냼�뱶
	@PostMapping("/register")
	public String register(BoardVO board , RedirectAttributes rttr) {
		service.register(board);
		
		rttr.addFlashAttribute("result","寃뚯떆湲�"+board.getBno()+"踰덉씠 �벑濡�");
		return "redirect:/board/list";
	}
	
	//�벑濡앺럹�씠吏��씠�룞
	@GetMapping("/register")
	public void register() {
		
	}
	
	@GetMapping({"/get","/modify"})
	public void get (@RequestParam("bno")Long bno , Model model, @ModelAttribute("cri") Criteria cri) {
		model.addAttribute("board",service.get(bno));
		System.out.println("asdf"+bno);
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

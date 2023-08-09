package org.zerock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;
import org.zerock.service.ReplyService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/replies")
@Log4j
public class ReplyController {

	@Setter(onMethod_=@Autowired)
	private ReplyService service;
	
	
	//�벑濡�
	@PostMapping(value="/new")
	public ResponseEntity<ReplyVO> create (ReplyVO vo){
		log.info("ReplyVO: "+ vo);
		int insertCount = service.register(vo);
		
		log.info("Reply Insert Count: " + insertCount);
		return insertCount ==1 
				? new ResponseEntity<ReplyVO>(vo, HttpStatus.OK)
						: new ResponseEntity<ReplyVO>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	//�쟾泥댁“�쉶(寃뚯떆湲��쓽 �뙎湲� �럹�씠吏�)
	@GetMapping(value="/pages/{bno}/{page}",
			produces = {MediaType.APPLICATION_JSON_VALUE ,MediaType.APPLICATION_ATOM_XML_VALUE}
			)
	public ResponseEntity<List<ReplyVO>> getList(@PathVariable ("page") int page, @PathVariable("bno")Long bno){
		Criteria cri = new Criteria();
		cri.setPageNum(page);
		cri.setAmount(10);
		List<ReplyVO> list = service.getList(cri, bno);
		System.out.println(bno);
		
		return new ResponseEntity<>(list , HttpStatus.OK);
	}
	
	//�닔�젙
	
	
	//�궘�젣
}

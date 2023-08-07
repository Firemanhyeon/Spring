package org.zerock.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.SampleVO;

import lombok.extern.log4j.Log4j;

//jsp 페이지 생성 (x) -> json 데이터 생성


@RestController//이거 써주면 페이지가 반환되는게아니라 데이터가 반환된다.
@RequestMapping("/sample")
@Log4j
public class SampleController {

	@GetMapping(value="/getText",produces="text/plain;charset=UTF-8")
	public String getText() {
		log.info("MIME TYPE: " +MediaType.TEXT_PLAIN_VALUE);
		return "안녕하세요";
	}
	@GetMapping(value="/getSample",
			produces= { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE})
		public SampleVO getSample() {
			return new SampleVO(100,"길동","홍");
		}

		@GetMapping(value ="/getList",
				produces=  MediaType.APPLICATION_JSON_VALUE)
		public List<SampleVO> getList(){
			//return IntStream.range(1, 10).mapToObj(i -> new SampleVO(i,"first"+i,"last"+i)).collect(Collectors.toList());
			List<SampleVO> list = new ArrayList<>();//위에와 같은구문
			for(int i=1; i<10; i++) {
				list.add(new SampleVO(i,"first"+i,"last"+i));
			}
			return list;
		}
		
		@GetMapping(value="/getMap")
		public Map<String ,SampleVO> getMap(){
			Map<String ,SampleVO> map = new HashMap<>();
			map.put("first", new SampleVO(1001,"first","last"));
			return map;
		}
		
		
		//head정보도 같이 담아서 보낸다
		@GetMapping(value="/check",params= {"height","weight"},
				produces=  MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<SampleVO> check(Double height,Double weight){
			SampleVO vo = new SampleVO(111,"kildong","hong");
			ResponseEntity<SampleVO>result =null;
			if(height<150) {
				result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
			}else {
				result = ResponseEntity.status(HttpStatus.OK).body(vo);
			}
			return result;
		}
		
		@GetMapping("/product/{cat}/{pid}")
		public String[] getPath(@PathVariable("cat") String cat , @PathVariable("pid") Integer pid) {
			return new String [] {"category: "+cat,"product: " +pid} ;
		}
}

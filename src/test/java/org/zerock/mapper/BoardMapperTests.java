package org.zerock.mapper;

import java.util.function.Consumer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Setter(onMethod_= @Autowired)
	private BoardMapper mapper;
	
	@Test
	public void testListWithPaging() {
		Criteria cri = new Criteria();
		cri.setType("");
		cri.setKeyword("test");
		
		mapper.getListWithPaging(cri).forEach(board -> {
			log.info(board);
		});
	}

	//@Test
	public void testRead() {

		//삭제
		int r =mapper.delete(3L);
		log.info(r + "건 삭제됨.");
		
//		수정
//		BoardVO board = new BoardVO();
//		board.setBno(3L);
//		board.setTitle("바뀐내용");
//		board.setContent("바뀐내용");
//		mapper.update(board);
		
//		단건조회
		BoardVO vo =mapper.read(3L);
		if(vo==null) {
			log.info("조회된결과없음");
		}else {
			log.info(vo);			
		}
	}
//	@Test
	public void testInsert() {
		BoardVO vo= new BoardVO();
		vo.setTitle("새로운글");
		vo.setContent("입력테스트");
		vo.setWriter("user01");
		
		mapper.insertSelectKey(vo);
		log.info(vo);
	}
	
	//@Test
	public void testGetList() {
		mapper.getList().forEach(new Consumer<BoardVO>() {// == board -> log.info(board)
			@Override
			public void accept(BoardVO board) {
				log.info(board);
			}
		});
	}
}

package org.zerock.service;

import static org.junit.Assert.assertNotNull;

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
public class BoardServiceTests {
	
	@Setter(onMethod_ = @Autowired)
	private BoardService service;
	
	@Test
	public void testService() {
//		BoardVO board = new BoardVO();
//		board.setTitle("서비스테스트");
//		board.setContent("서비스내용");
//		board.setWriter("user03");
//		
//		service.register(board);
//		log.info(board);
		Criteria cri = new Criteria();
		cri.setPageNum(1);
		cri.setAmount(10);
		
		service.getList(cri).forEach(brd-> log.info(brd));
	}
	
//	@Test
	public void testExist() {
		assertNotNull(service);
		log.info(service);
	}
}

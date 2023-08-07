package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {

	@Setter(onMethod_=@Autowired)
	private ReplyMapper mapper;
	
	@Test
	public void mapperTests() {
		ReplyVO vo = new ReplyVO();
		vo.setBno(200L);
		vo.setReply("200의 댓글입니다22222222222222");
		vo.setReplyer("user00");
		vo.setRno(2L);
		mapper.update(vo);
		
		Criteria cri = new Criteria();
		mapper.getListWithPaging(cri, 200L).forEach(reply -> {
			log.info(reply.toString());
		});	
	}
}

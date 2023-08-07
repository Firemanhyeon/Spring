package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardMapper {
	
	public List<BoardVO> getList();
	public List<BoardVO> getListWithPaging(Criteria cri);//리스트페이징
	public int getTotalCount(Criteria cri);
	public void insert(BoardVO board);//생성ㄴ된 pk값을 반환하지않는경우
	public void insertSelectKey(BoardVO board); //생성된 pk반환
	public BoardVO read(Long bno);//단건조회
	public int delete(Long bno);//삭제
	public int update(BoardVO board);//수정
}

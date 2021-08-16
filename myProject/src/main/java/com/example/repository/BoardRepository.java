package com.example.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.domain.Board;
import com.example.parameter.BoardParameter;

/**게시판 Repository
 * @author 이유나
 *
 */
@Repository
public interface BoardRepository {
	
	List<Board> getList();
	
	Board get(int boardIdx);
	
	void save(BoardParameter board);
	
	void update(BoardParameter board);
	
	void delete(int boardIdx);

}

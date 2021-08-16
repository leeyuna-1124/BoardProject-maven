package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.configuration.http.BaseResponse;
import com.example.configuration.http.BaseResponseCode;
import com.example.domain.Board;
import com.example.parameter.BoardParameter;
import com.example.service.BoardService;
import com.example.configuration.exception.BaseException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/board")
@Api(tags = "게시판 API")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	/**
	 * 목록 리턴
	 * @return
	 *
	 */	
	@GetMapping
	@ApiOperation(value = "목록 조회", notes = "게시물 목록 정보를 조회할 수 있습니다.")
	public BaseResponse<List<Board>> getList(){
		return new BaseResponse<List<Board>>(boardService.getList());
	}
	
	/**
	 * 상세정보 리턴
	 * @param boardIdx
	 * @return
	 *
	 */	
	@GetMapping("/{boardIdx}")
	@ApiOperation(value = "상세 조회", notes = "게시물 번호에 해당하는 상세정보를 조회할 수 있습니다.")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "boardIdx", value = "게시물 번호", example = "1")
	})
	public BaseResponse<Board> get(@PathVariable int boardIdx) {
		Board board = boardService.get(boardIdx);
		if(board == null) {
			//null 처리
			throw new BaseException(BaseResponseCode.DATA_IS_NULL, new String[] {"게시물"});
		}
		return new BaseResponse<Board>(board);
	}
	
	/**
	 * 등록/수정 처리
	 * @param param
	 * @return
	 *
	 */	
	@PutMapping
	@ApiOperation(value = "등록/수정 처리", notes = "신규 게시물 저장 및 기존 게시물 업데이트가 가능합니다.")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "boardIdx", value = "게시물 번호", example = "1"),
		@ApiImplicitParam(name = "title", value = "제목", example = "제목 예시"),
		@ApiImplicitParam(name = "content", value = "내용", example = "내용 예시")
	})
	public BaseResponse<Integer> save(BoardParameter param) {
		//제목 필수 체크
		if(StringUtils.isEmpty(param.getTitle())) {
			throw new BaseException(BaseResponseCode.VALIDATE_REQUIRED, new String[] {"title", "제목"});
		}
		//내용 필수 체크
		if(StringUtils.isEmpty(param.getContent())) {
			throw new BaseException(BaseResponseCode.VALIDATE_REQUIRED, new String[] {"content", "내용"});
		}
		boardService.save(param);
		return new BaseResponse<Integer>(param.getBoardIdx());
	}
	
	/**
	 * 삭제 처리
	 * @param boardIdx
	 * @return
	 *
	 */	
	@DeleteMapping("/{boardIdx}")
	@ApiOperation(value = "삭제 처리", notes = "게시물 번호에 해당하는 정보를 삭제합니다.")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "boardIdx", value = "게시물 번호", example = "1"),
	})
	public BaseResponse<Boolean> delete(@PathVariable int boardIdx) {
		Board board = boardService.get(boardIdx);
		if(board == null){
			return new BaseResponse<Boolean>(false);
		}
		boardService.delete(boardIdx);
        return new BaseResponse<Boolean>(true);
	}

}

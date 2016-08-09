package com.hanbit.web.mapper;

 
import java.util.List;

import org.springframework.stereotype.Repository;

import com.hanbit.web.grade.GradeDTO;
import com.hanbit.web.grade.GradeMemberDTO;


@Repository
public interface GradeMapper {
	public int input(GradeDTO grade);//기능은 추상화하고 속성은 추상화하지 않는다.
	// 성적표 등록  C 
	// 성적표 조회(학번) R
	public GradeMemberDTO getGradeByHak(int hak);
	// 성적표 조회(이름) R
	public List<GradeDTO> getGradesByName(String name);
	// 성적표 수정 U
	public int update(int hak,int java,int jsp,int sql,int spring);
	// 성적표 삭제 D
	public int delete(GradeDTO grade);
	// R 카운트 조회
	public int getCount();
	// 성적 이름 조회
	public GradeDTO getGradeById(String id);
	// 모든 성적 조회
	public List<GradeDTO> selectGradeAll();
}

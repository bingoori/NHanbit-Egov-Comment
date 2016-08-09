package com.hanbit.web.grade;

import java.util.ArrayList;
import java.util.List;


/**
 * CRUD 
 *  C : Create 생성
 *  R : Read   조회
 *  U : Update 수정
 *  D : Delete 삭제
 *@package : grade
 *@file : GradeService.java
 *@author sdwoo90@gmail.com
 *@date 2016. 3. 14.
 *@story 속성은 감추고 기능은 오픈한다.
 */
public interface GradeService {
	public int input(GradeDTO grade);//기능은 추상화하고 속성은 추상화하지 않는다.
	// 성적표 리스트 출력 R
	public List<GradeDTO> getList();
	// 성적표 조회(학번) R
	public GradeDTO getGradeByHak(int hak);
	// 성적표 조회(이름) R
	public List<GradeDTO> getGradesByName(String name);
	// 성적표 수정 U
	public int update(int hak,int java,int jsp,int sql,int spring);
	// 성적표 삭제 D
	public int delete(String id);
	// R 카운트 조회
	public int getCount();
	// 성적 이름 조회
	public GradeDTO getGradeById(String id);
	// 모든 성적 조회
	public List<GradeDTO> selectGradeAll();
}

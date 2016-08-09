package com.hanbit.web.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hanbit.web.admin.AdminDTO;
import com.hanbit.web.grade.GradeDTO;
import com.hanbit.web.grade.GradeMemberDTO;
 
@Repository
public interface AdminMapper {
	public List<GradeMemberDTO> getMemberList();
	public int addScore(GradeDTO bean);
	public AdminDTO SelectAdmin(AdminDTO aBean);
}
package com.hanbit.web.admin;

import java.util.List;
 

import com.hanbit.web.grade.GradeDTO;
import com.hanbit.web.grade.GradeMemberDTO;


public interface AdminService {
	public List<GradeMemberDTO> getMemberList();
	public int addScore(GradeDTO gBean);
	public AdminDTO getAdmin(AdminDTO aBean);

}
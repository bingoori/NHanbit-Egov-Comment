package com.hanbit.web.admin;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hanbit.web.grade.GradeDTO;
import com.hanbit.web.grade.GradeMemberDTO;

 
@Service
public class AdminServiceImpl implements AdminService {
	private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);
	private static AdminService service = new AdminServiceImpl();

	public static AdminService getService() {
		return service;
	}

	@Override
	public List<GradeMemberDTO> getMemberList() {

		return null;
	}

	@Override
	public int addScore(GradeDTO gBean) {
		return 0;
		
	}

	@Override
	public AdminDTO getAdmin(AdminDTO aBean) {
		
		return null;
	}

}
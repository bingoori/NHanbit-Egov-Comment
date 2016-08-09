package com.hanbit.web.member;

import org.springframework.stereotype.Component;

@Component
public class MemberDTO {
	private String id, password, name, addr, major, subject,role,profileImg;
	private int birth, cate; // 생 년 월 일 1980 처럼 숫자만 입력

	public int getCate() {
		return cate;
	}

	public void setCate(int cate) {
		this.cate = cate;
	}

	public MemberDTO() {
	} // 생성자 오버로딩

	public MemberDTO(String id, String password, String name, int bitrh, String addr, String major, String subject,
			int cate,String role,String profileImg) {
		this.id = id;
		this.password = password;
		this.birth = bitrh;
		this.addr = addr;
		this.name = name;
		this.major = major;
		this.subject = subject;
		this.cate = cate;
		this.role = role;
		this.profileImg = profileImg;
	}

	public String getProfileImg() {
		return profileImg;
	}

	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getBirth() {
		return birth;
	}

	public void setBirth(int birth) {
		this.birth = birth;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", password=" + password + ", name=" + name + ", addr=" + addr + ", major="
				+ major + ", subject=" + subject + ", role=" + role + ", profileImg=" + profileImg + ", birth=" + birth
				+ ", cate=" + cate + "]";
	}


}

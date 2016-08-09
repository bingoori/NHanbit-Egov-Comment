package com.hanbit.web.grade;

public class GradeMemberDTO {
	private String id, password, name, addr;
	private int hak, java, sql, jsp, spring, birth;

	public GradeMemberDTO() {
		// TODO Auto-generated constructor stub
	}
	public GradeMemberDTO(String id,int java, int jsp, int sql, int spring, String password, String name, String addr, int birth) {
		this.id = id;
		this.java = java;
		this.jsp = jsp;
		this.sql = sql;
		this.spring = spring;
		this.password = password;
		this.name = name;
		this.addr = addr;
		this.birth = birth;
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

	public int getHak() {
		return hak;
	}

	public void setHak(int hak) {
		this.hak = hak;
	}

	public int getJava() {
		return java;
	}

	public void setJava(int java) {
		this.java = java;
	}

	public int getSql() {
		return sql;
	}

	public void setSql(int sql) {
		this.sql = sql;
	}

	public int getJsp() {
		return jsp;
	}

	public void setJsp(int jsp) {
		this.jsp = jsp;
	}

	public int getSpring() {
		return spring;
	}

	public void setSpring(int spring) {
		this.spring = spring;
	}

	public int getBirth() {
		return birth;
	}

	public void setBirth(int birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		return "GradeMemberBean [id=" + id + ", password=" + password + ", name=" + name + ", addr=" + addr + ", hak="
				+ hak + ", java=" + java + ", sql=" + sql + ", jsp=" + jsp + ", spring=" + spring + ", birth=" + birth
				+ "]";
	}
}

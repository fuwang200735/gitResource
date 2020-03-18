package com.jdbc;

public class TestSVN {
                private String username;
	private String password;
                private String name;
                private String pw;
     	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
      public void test(){
           String s=name+pw;
      }
	public static void main(String[] args) {
		System.out.println("组长的操作。。。");
                                System.out.println("张三的操作。。。");
                                System.out.println("张三的代码。。。");
	}

}

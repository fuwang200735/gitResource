package com.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
public static void main(String[] args) throws SQLException {
	 String sql="select * from emp";
	 ResultSet resultSet=JDBCUtils.executeQuery(sql, null);
	 if(resultSet.next()) {
		 System.out.println(resultSet.getInt("empno"));
		 System.out.println(resultSet.getString("ename"));
	 }
	 
}
}

package com.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

public class myy {
public static void main(String[] args) throws SQLException {
	 String sql="select * from emp";
	 ResultSet resultSet=JDBCUtils.executeQuery(sql, null);
	 if(resultSet.next()) {
		 System.out.println(resultSet.getInt("MYY"));
		 System.out.println(resultSet.getString("MYY"));
	 }
	 
}
}

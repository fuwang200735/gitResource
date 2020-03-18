package com.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 封装一个JDBC工具类
 * 
 * @author newuser
 *
 */
public class JDBCUtils {
	private static final String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String user = "test";
	private static final String password = "123";// 没有密码
	private static Connection cont = null;
	private static PreparedStatement ps = null;

	// 1.加载驱动,作用加载一次，所有放到静态代码块中
	static {
		// 1.加载驱动
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 2.获得连接
	public static Connection getConnection() {
		try {
			cont = DriverManager.getConnection(url, user, password);
			return cont;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 封装一个查询的方法
	 */
	public static ResultSet executeQuery(String sql, Object[] info) {
		// 获得连接
		cont = getConnection();
		try {
			// 得到发送对象
			ps = cont.prepareStatement(sql);
			// 处理占位符
			if (info != null) {
				for (int i = 0; i < info.length; i++) {
					if(info[i] instanceof Integer) {
						ps.setInt(i + 1,(int) info[i]);
						continue;
					}else if(info[i] instanceof Date) {
						ps.setDate(i + 1,(Date) info[i]);
						continue;
					}else {
						ps.setString(i + 1,(String) info[i]);
					}
				}

			}
			return ps.executeQuery();// 将返回的结果，返回
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	/**
	 * 封装一个增删改的方法
	 */
	public static int executeUpdate(String sql, Object[] info) {
		// 获得连接
		cont = getConnection();
		try {
			// 得到发送对象
			ps = cont.prepareStatement(sql);
			// 处理占位符
			if (info != null) {
				for (int i = 0; i < info.length; i++) {
					if(info[i] instanceof Integer) {
						ps.setInt(i + 1,(int) info[i]);
						continue;
					}else if(info[i] instanceof Date) {
						ps.setDate(i + 1,(Date) info[i]);
						continue;
					}else {
						ps.setString(i + 1,(String) info[i]);
					}
					
				}
			}
			
			int rs = ps.executeUpdate();// 将返回的结果，返回
			System.out.println("操作成功！作用了"+rs+"条记录！");
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.close(null, ps, cont);
		}

		
		return -1;

	}

	public static void close(ResultSet rs, PreparedStatement ps, Connection cont) {

		try {
			if (rs != null) {
				rs.close();
			}

			if (ps != null) {
				ps.close();
			}
			if (cont != null) {
				cont.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	// 编写一个方法返回ps,cont
	public static PreparedStatement getPs() {
		return ps;
	}

	// 编写一个方法返回ps,cont
	public static Connection getCont() {
		return cont;
	}

}

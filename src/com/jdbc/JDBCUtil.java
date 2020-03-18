package com.jdbc;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import oracle.jdbc.OracleTypes;

/**
 * 封装一个JDBC工具类
 * 
 * @author newuser
 *
 */
public class JDBCUtil {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
	 String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	 String user = "test";
	 String password = "123";

	   // 1.加载驱动
	  Class.forName("oracle.jdbc.driver.OracleDriver");

	   // 2.获得连接
	  Connection conn= DriverManager.getConnection(url, user, password);

       //3、获取语句对象
      String sql="{call p_queryOut(?,?)}";
      CallableStatement call=conn.prepareCall(sql);
      
      //4、设置输入参数
      call.setInt(1, 1060);
      
      //5、注册输出参数
      call.registerOutParameter(2, OracleTypes.DOUBLE);
      
      //6、执行存储过程
      call.execute();
      
      //7、获取输出参数
      double sal=call.getDouble(2);
      System.out.println(sal);
      
      //8、释放资源
      call.close();
      conn.close();
	}
}

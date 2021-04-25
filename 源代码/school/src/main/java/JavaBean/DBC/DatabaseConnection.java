package JavaBean.DBC;

import java.sql.*;


public class  DatabaseConnection{//数据库连接

	private static final String driver="com.mysql.jdbc.Driver";
    private static final String url="jdbc:mysql://localhost:3306/text?useUnicode=true&characterEncoding=utf-8";
   	private static final String user="root";
   	private static final String password="123456";
   	private Connection conn = null ;
   	 public DatabaseConnection() throws Exception{
   	 try {
   	 Class.forName(driver);//加载数据库驱动
        conn=DriverManager.getConnection(url,user,password);//获取数据库连接
   	 }
   	catch(Exception e){
		throw e ;
	}
   	 }

	public Connection getConnection(){
		return this.conn ;
	}

}

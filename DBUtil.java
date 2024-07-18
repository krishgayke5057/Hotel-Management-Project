package Utility;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class DBUtil {
	private static Properties properties = null;
	
	private DBUtil() {
	}
	 
	 static{
		 FileInputStream fis = null;
		 String fileinfo = "C:\\Users\\krish\\eclipse-workspace\\jdbcApp2\\src\\com\\pwskills\\properties\\database.properties";
		try {
			fis = new FileInputStream(fileinfo);
			if (fis != null) {
			    properties = new Properties();
				properties.load(fis);
			}
			
		} catch (IOException e) {
				
			e.printStackTrace();
			}
			
	 }

	public static  Connection getDBConection() throws IOException, SQLException {
		
		
		String url = properties.getProperty("url");
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");

		// 1. Establishing the connection
		return DriverManager.getConnection(url,user,password);
		

	}
	
	public static void cleanUpResources(ResultSet resultset, Statement statement, Connection con) {
		// closing resultset
		if(resultset != null) {
			try {
				resultset.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
		
		// closing Statement
		if(statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
					e.printStackTrace();
			}
		}
		
		// closing Connection
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		
//		 closing fileInputStream
//		if(fis != null) {
//			try {
//				fis.close();
//			} catch (IOException e) {
//			
//				e.printStackTrace();
//			}
//		}
	}

}

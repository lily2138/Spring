package jdbc.step4;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/*
 * 실제값들의 메타데이타
 * 인터페이스 --> properties!!!!!
 * 
 * 				Collection
 *                   |
 *              Set       List             Map
 *                                           |
 *                                         HashMap     
 *                                HashTable
 *                                    |
 *                                Properties  
 */
public class DBConnectionTest1 {		
	public static void main(String[] args) throws Exception{
		Properties p = new Properties();
		p.load(new FileInputStream("src/config/db.properties"));//File System...src부터 인식 시켜야한다.
		
		String driver=p.getProperty("jdbc.mysql.driver");
		String url=p.getProperty("jdbc.mysql.url");
		String user=p.getProperty("jdbc.mysql.user");
		String pass=p.getProperty("jdbc.mysql.pass");
		
		String selectAll=p.getProperty("jdbc.sql.selectAll");
		
		Class.forName(driver);
		System.out.println("1. 드라이버 로딩 성공...");
		
		Connection conn = DriverManager.getConnection(url, user, pass);
		System.out.println("2. 디비연결 성공...");
		
		PreparedStatement st = conn.prepareStatement(selectAll);
		System.out.println("3. PreparedStatement 생성...");
		
		System.out.println("4.============ Query 실행======================\n");
		ResultSet rs=st.executeQuery();
		while(rs.next()) System.out.println(rs.getString("name")+","+rs.getString("address"));
		
	}
}

























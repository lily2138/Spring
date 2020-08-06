package jdbc.step1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * JDBC 작업 4단계
 * 1. 드라이버를 로딩...(클라이언트 메모리단에)
 * 2. 디비서버와 연결...jdbc:mysql://127.0.0.1:3306/scott...conn반환
 * 3. query를 준비시킴...
 * 		PreparedStatement st = conn.prepareStatement("sql query");
 * 
 * 4. 값이 바인딩 + 퀴리문이 실행---- 실제로 디비서버에 값이 추가/삭제/수정/가지고옴
 * 		1) ?에 해당하는 값을 먼저 바인딩
 * 		2) 쿼리문 실행
 * 			st.executeUpdate() : int --- insert/delete/update
 * 			st.executeQuery() : ResultSet --- select
 */
public class DBConnectionTest1 {

	public DBConnectionTest1() {
		try {
			//1.
			Class.forName("com.mysql.cj.jdbc.Driver");//FQCN
			System.out.println("Driver Loading Success!!!");
			
			//2.
			String url = "jdbc:mysql://127.0.0.1:3306/scott?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
			Connection conn = DriverManager.getConnection(url, "root", "1234");
			System.out.println("DB Connection....");
			
			//3.
			String query = "INSERT INTO person(ssn, name, address) VALUES(?,?,?)";
			PreparedStatement st = conn.prepareStatement(query);
			System.out.println("Creating PrepareStatement......");
			
			//4.
			st.setInt(1, 111);
			st.setString(2, "박나래");
			st.setString(3, "여의도");
			
			int row = st.executeUpdate();
			System.out.println(row+"명 추가됨!!!");
			
		} catch (SQLException e) {
			System.out.println("Driver Loading Fail....");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Loading Fail....");
		} 
	}
	public static void main(String[] args) {
		new DBConnectionTest1();
		
	}

}

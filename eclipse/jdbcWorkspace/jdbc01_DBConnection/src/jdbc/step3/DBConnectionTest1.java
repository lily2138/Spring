package jdbc.step3;
/*
 * step2에서는 디비서버에 대한 정보가 프로그램상에 하드코딩 되어져 있다.
 * 
 * 해결책
 * 별도의 모듈에 디비서버에 대한 정보를 뽑아내어서 별도로 처리
 * 메타데이터화 시킨다.
 * 인터페이스 - Properties 파일 - XML
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;
import query.PersonSQL;

public class DBConnectionTest1 {
			
	public DBConnectionTest1() throws ClassNotFoundException, SQLException {	
		///1. 드라이버 로딩
		Class.forName(ServerInfo.DRIVER_NAME); //Driver FQCN
		System.out.println("1. Driver Loading....");
		
		//2. 디비연결...getConnection
		Connection conn = DriverManager.getConnection(ServerInfo.URL,ServerInfo.USER, ServerInfo.PASS);
		System.out.println("2. 디비연결 성공....");
		
		//3. 쿼리준비...prepareStatement()
		/*String query = "INSERT INTO person(ssn,name,address) VALUES(?,?,?)";
		PreparedStatement st = conn.prepareStatement(query);
		System.out.println("3. PreparedStatement 생성 성공....");
		
		//4. ?에 값을 바인딩하고 | 쿼리문 실행.... executeUpdate()
		st.setInt(1, 333);
		st.setString(2, "강동원");
		st.setString(3, "마곡동");
		
		int row = st.executeUpdate();
		System.out.println(row+"명 추가됨!!!");*/
		
		//delete.... 
		/*String query = "DELETE FROM person WHERE ssn=?";
		PreparedStatement st = conn.prepareStatement(query);
		System.out.println("PreparedStatement 생성....");
		
		st.setInt(1, 222);
		System.out.println(st.executeUpdate()+"명 삭제!!!");*/
		
		//update
		/*String query = "UPDATE person SET name = ? , address=? WHERE ssn=?";
		PreparedStatement st = conn.prepareStatement(query);
		System.out.println("PreparedStatement 생성....");
		
		st.setString(1, "박나리");
		st.setString(2, "서초동");
		st.setInt(3, 111);
		
		System.out.println(st.executeUpdate()+"명 수정!!!");*/
		
		//select....모든 레코드를 다 가져온다.
		PreparedStatement st = conn.prepareStatement(PersonSQL.ALL_PERSON);
		
		ResultSet rs = st.executeQuery(); // int | ResultSet
		while(rs.next()) {
			int ssn = rs.getInt("ssn"); //getInt(1)
			String name = rs.getString("name");
			String addr = rs.getString("address");
			System.out.println(ssn+","+name+","+addr);
		}
		
		//5. 자원 반납...자원을 열어서 사용한 순서 반대로 닫는다....
		st.close();
		conn.close();

	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		new DBConnectionTest1();
		
	}

}

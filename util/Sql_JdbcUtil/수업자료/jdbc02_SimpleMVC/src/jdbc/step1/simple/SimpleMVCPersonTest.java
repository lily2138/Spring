package jdbc.step1.simple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;

/*
    구조적으로...작성....
 * 1. 드라이버 로딩
 * 2. 디비연결
 * 3. PreparedStatement 생성
 * 4. 쿼리문 실행
 * 5. close
 * ::
 * 메소드 마다 동일한 부분이 반복되는 것은 비효율 적이다
 * 반복
 * 1) 고정적인 반복 --- 디비연결, 자원 반납 -- 공통적인 메소드로 정의...메소드 마다 호출해서 사용
 * 2) 변동적인 반복
 */
public class SimpleMVCPersonTest {	
	/// 공통적인 부분을 정의
	public Connection  getConnect() throws SQLException{
		Connection conn =DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
		System.out.println("Database Connection......");
		return conn;
	}
	
	public void closeAll(PreparedStatement ps, Connection conn)throws SQLException {
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();
	}
	
	public void closeAll(ResultSet rs,PreparedStatement ps, Connection conn)throws SQLException {
		if(rs!=null) rs.close();
		closeAll(ps, conn);
	}
	
	//비지지스 로직....DAO
	public void addPerson(int ssn, String name, String address) throws SQLException{
		Connection conn=  null;
		PreparedStatement ps = null;
		
		conn = getConnect();
		
		String query = "INSERT INTO person(ssn, name, address) VALUES(?,?,?)";
		ps = conn.prepareStatement(query);
		
		ps.setInt(1, ssn);
		ps.setString(2, name);
		ps.setString(3, address);
		
		ps.executeUpdate();
		System.out.println(name+" 님, 회원가입 되셨습니다...");	
		
		closeAll(ps, conn);
	}
	public void removePerson(int ssn) throws SQLException{
		Connection conn=  null;
		PreparedStatement ps = null;		
		
		conn = getConnect();
		
		String query = "DELETE FROM person WHERE ssn=?";
		ps = conn.prepareStatement(query);
		ps.setInt(1, ssn);
		System.out.println(ps.executeUpdate());	
		
		closeAll(ps, conn);
	}
	
	public void updatePerson() {
		//디비연결, PreparedStatement, 쿼리문 수행, close
	}
	public void searchAllPerson()throws SQLException {
		Connection conn=  null;
		PreparedStatement ps = null;	
		ResultSet rs = null;
		
		conn = getConnect();
		
		String query = "SELECT * FROM person";
		
		ps = conn.prepareStatement(query);
		
		rs = ps.executeQuery();
		while(rs.next()) {			
			System.out.println(rs.getInt("ssn")+","+rs.getString("name")+", "+rs.getString("address"));
		}	
		
		
		
	}
	public void searchAPerson() {
		//디비연결, PreparedStatement, 쿼리문 수행, close
	}
	public static void main(String[] args) {
		SimpleMVCPersonTest mvc = new SimpleMVCPersonTest();
		/*try {
			mvc.addPerson(444,"아이유","제주도");//calling			
		}catch(SQLException e) {
			System.out.println("회원 가입 실패...");
		}*/
		
		/*try {
			mvc.removePerson(444);
		}catch(SQLException e) {
			System.out.println("회원 삭제 실패...");
		}*/
		
		
	}	
	static {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("Driver Loading....Success...");
		}catch(ClassNotFoundException e) {
			System.out.println("Driver Loading....Fail...");
		}		
	}
}















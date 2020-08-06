package jdbc.step1.simple;
import java.security.spec.PSSParameterSpec;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import config.ServerInfo;
/*
 * 구조적으로 작성
 * 1. 드라이버 로딩
 * 2. db연결
 * 3. PreparedStatement 생성
 * 4. 쿼리문 실행
 * 5. close
 * ::
 * 메소드마다 동일한 부분이 반복되는 것은 비효율 적이다
 * 반복
 * 1) 고정적인 반복 ---- 디비연결, 자원반납 ---- 공통적인 메소드로 정의... 메소드마다 호출해서 사용 
 * 2) 변동적인 반복
 * 
 */
public class SimpleMVCPersonTest {
	//// 공통적인 부분을 정의
	public Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL,ServerInfo.USER , ServerInfo.PASS);
		System.out.println("Database Connection......");
		return conn;
	}
	
	//마지막에 열었던 것을 먼저 닫아야 하므로 인자값 순서를 잘 해야한다.
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException{
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();
	}
	
	// 인자값 순서 잘하기
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException{
		if(rs!=null) rs.close();
		closeAll(ps,conn);
	}
	
	//비지니스 로직...DAO (이제까지 service라고 했던것들을 DAO라고 한다 ---> data를 다루는)
	public void addPerson(int ssn, String name, String address) throws SQLException {
		//DB 연결, preparedStatement, 쿼리문 수행, close
		/*Connection conn =  DriverManager.getConnection(ServerInfo.URL,ServerInfo.USER , ServerInfo.PASS);
		String query = "INSERT INTO person(ssn, name, address) VALUES(?,?,?)";
		PreparedStatement ps = conn.prepareStatement(query);*/
		//위 세줄코드가 계속 반복되니까 하나의 메소드로 나타낸다. 
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		conn = getConnect();
		
		String query = "INSERT INTO person(ssn, name, address) VALUES(?,?,?)";
		ps = conn.prepareStatement(query);
		
		ps.setInt(1,ssn);
		ps.setString(2,name);
		ps.setString(3, address);
		
		ps.executeUpdate();
		System.out.println(name + "님 , 회원가입되셨습니다.");
		
		/*ps.close();
		conn.close();*/
		//꼭 닫아줘야한다 꼭ㄲ꼬곡꼬꼮 
		closeAll(ps,conn);
		
	}
	
	public void removePerson(int ssn) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		conn = getConnect();
		
		String query = "DELETE FROM person WHERE ssn = ?";
		ps = conn.prepareStatement(query);
		
		ps.setInt(1, ssn);
		ps.executeUpdate();
		System.out.println(ssn + "번호가 삭제되었습니다");
		
		closeAll(ps,conn);
	}
	
	public void updatePerson(int ssn, String addr) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		conn = getConnect();
		
		String query = "UPDATE person SET address = ? WHERE ssn = ?";
		ps = conn.prepareStatement(query);
		
		ps.setString(1, addr);
		ps.setInt(2, ssn);
		ps.executeUpdate();
		System.out.println(ssn + "번호가 업데이트되었습니다.");
		
		closeAll(ps,conn);		
	}
	
	// rs 선언 추가
	public void searchAllPerson() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		conn = getConnect();
		
		String query = "SELECT ssn, name, address FROM person";
		
		ps = conn.prepareStatement(query);
		
		rs = ps.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt("ssn") + " " + rs.getString("name") + " " + rs.getString("address"));
		}
		
		closeAll(rs,ps,conn);	
	}
	public static void main(String[] args) {
		SimpleMVCPersonTest mvc = new SimpleMVCPersonTest();
		
		//1 addPerson
		
/*		try{
			mvc.addPerson(444,"아이유","제주도");
		} catch(SQLException e) {
			System.out.println("실패");
		}*/
		//2 delete person
		
		try {
			mvc.removePerson(444);
		} catch(SQLException e) {
			System.out.println("실패");
		}
		
		
		//3 update person
/*		try {
			mvc.updatePerson(111, "지옥");
		} catch(SQLException e) {
			System.out.println("실패");
		}*/
		
		//4 show all info
		try {
			mvc.searchAllPerson();
		} catch (SQLException e) {
			System.out.println("실패");
		}
		
	}
	
	//static initialization block...
	static {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("Driver Loading... Success");
			
		} catch(ClassNotFoundException e) {
			
			System.out.println("Driver Loading .... Fail... ");
			
		}
		
	}
}
package jdbc.step2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnectionTest1 {	
	public static final String URL ="jdbc:mysql://127.0.0.1:3306/scott?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
	public static final String USER ="root";
	public static final String PASS ="1234";
	
	public DBConnectionTest1() throws ClassNotFoundException, SQLException{			
		//1.드라이버 로딩
		Class.forName("com.mysql.cj.jdbc.Driver");//Driver FQCN
		System.out.println("1. Driver Loading....");
		
		//2. 디비연결..getConnection
		Connection conn=DriverManager.getConnection(URL, USER, PASS);
		System.out.println("2. 디비연결 성공...");
		
		//3. 쿼리준비...prepareStatement()
		/*String query = "INSERT INTO person(ssn, name, address) VALUES(?,?,?)";
		PreparedStatement st=conn.prepareStatement(query);
		System.out.println("3. PreparedStatement 생성 성공...");
		
		//4. ?에 값을 바인딩하고 | 쿼리문 실행....executeUpdate()
		st.setInt(1, 333);
		st.setString(2, "정우성");
		st.setString(3, "혜화동");
		
		System.out.println(st.executeUpdate()+" 명 추가됨!!!");*/
		
		// delete...333번을 삭제
		/*String query = "DELETE FROM person WHERE ssn=?";
		PreparedStatement st=conn.prepareStatement(query);
		System.out.println("PreparedStatement 생성....");
		
		st.setInt(1, 333);
		System.out.println(st.executeUpdate()+"명 삭제!!!");*/
		
		//update...111번에 대한 정보를 수정
		/*String query = "UPDATE person SET name=? , address=? WHERE ssn=?";
		PreparedStatement st = conn.prepareStatement(query);
		
		st.setString(1, "박나리");
		st.setString(2, "서초동");
		st.setInt(3, 111);
		System.out.println(st.executeUpdate()+"명 수정!!!");*/
		
		
		//select....모든 레코드를 다 가져온다.
		String query = "SELECT ssn, name, address FROM person";
		PreparedStatement st = conn.prepareStatement(query);
		
		ResultSet rs=st.executeQuery();//int | ResultSet
		while(rs.next()) {
			int ssn=rs.getInt("ssn"); //getInt(1)
			String name=rs.getString("name"); 
			String addr=rs.getString("address"); 
			System.out.println(name+","+name+","+addr);
		}
		
		//5. 자원 반납...자원을 열어서 사용한 순서 반대로 닫는다...
		st.close();
		conn.close();
		
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		new DBConnectionTest1();
	}
}









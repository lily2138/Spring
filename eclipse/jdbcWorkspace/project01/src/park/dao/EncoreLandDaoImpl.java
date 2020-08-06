package park.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import park.vo.Attraction;
import park.vo.Customer;
import park.vo.UseList;

public class EncoreLandDaoImpl implements EncoreLandDao{
	
	private static EncoreLandDaoImpl db = new EncoreLandDaoImpl();
	private EncoreLandDaoImpl(){
		
	} 
	public static EncoreLandDaoImpl getInstance() {
		return db;
	}
	
	
	static Properties p = new Properties();
	public Connection getConnect() throws SQLException {
		Connection conn = null;

		try {
			p.load(new FileInputStream("src/config/jdbc.properties"));
			
			//2 key 로 읽어들인 값을 각각의 변수에 할당
			String driverName = p.getProperty("jdbc.mysql.driver");
			String url = p.getProperty("jdbc.mysql.url");
			String user = p.getProperty("jdbc.mysql.user");
			String pass = p.getProperty("jdbc.mysql.pass");

			
			//3 드라이버 로딩
			Class.forName(driverName);
			System.out.println("드라이버 로딩");
			
			//4 서버연결
			conn = DriverManager.getConnection(url,user,pass);
			System.out.println("연결 성공");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();		
	}

	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if(rs!=null) rs.close();
		closeAll(ps, conn);	
	}

	public void randAddCustomer(int n) throws SQLException {
		Connection conn = getConnect();
		//String query = "INSERT INTO customer (sex,age) VALUES(?,?)";
		PreparedStatement ps = conn.prepareStatement(p.getProperty("jdbc.sql.AddCustomer"));
		int randInt=1;
		double randDouble;
		for(int i=0;i<n;i++) {
			randDouble = Math.random();
			if(randDouble>0.5)
				ps.setString(1, "M");
			else
				ps.setString(1, "F");
			randDouble = Math.random();
			randInt = (int) (randDouble*80);
			ps.setInt(2, randInt);
			ps.executeUpdate();
		}
	}
	
	// 같은 고객이 같은 놀이기구에 연속으로 두번 useAttraction을 신청할 수 있음. useAttraction에서 예외처리 필요
	public void randUseAttraction(int n, int custN) throws SQLException {
		for(int i=0; i<n ; i++) {
			System.out.println(1+(int)(Math.random()*custN)+"======"+(1000+(int)(Math.random()*10)));
			useAttraction(1 +(int)(Math.random()*custN),1000+(int)(Math.random()*10));	
		}
	
	}
	
	
	@Override
	public void entranceCustomer(Customer c) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnect();
			
//			String query = "INSERT into customer(sex,age) values(?,?)";
			ps = conn.prepareStatement(p.getProperty("jdbc.sql.entranceCust"));

			ps.setString(1, c.getSex());
			ps.setInt(2, c.getAge());
			ps.executeUpdate();
			
			System.out.println("고객이 입장하였습니다.");
		}finally {
			closeAll(ps,conn);
		}
		
	}

	@Override
	public void useAttraction(int custNo, int attrNo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnect();
			
//			String query = "INSERT into uselist(customer_no,attraction_no,status) values(?,?,?)";
			ps = conn.prepareStatement(p.getProperty("jdbc.sql.useAttr"));

			ps.setInt(1, custNo);
			ps.setInt(2, attrNo);
			ps.setInt(3, getCurrentStatus(attrNo,conn));
			
			if(getCurrentStatus(attrNo,conn)==1)
				System.out.println("대기해야합니다");
			else if(getCurrentStatus(attrNo,conn)==0)
				System.out.println("탑승완료 ! ");
			
			ps.executeUpdate();
			
		}finally {
			closeAll(ps,conn);
		}
		
	}
	
	
	public int getCurrentStatus(int attrNo,Connection conn) throws SQLException {
		int sta = -1;
		
//		String query = "select count(status) from uselist where attraction_no = ? and status = 0";
		PreparedStatement ps = conn.prepareStatement(p.getProperty("jdbc.sql.getCurrSta"));
		
		ps.setInt(1, attrNo);
		
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			if(rs.getInt("count(status)")==getAttrInfo(attrNo,conn).getMaxPerson())
				sta = 1;
			else if(rs.getInt("count(status)")<getAttrInfo(attrNo,conn).getMaxPerson())
				sta = 0;
		}
		
		return sta;
	}
	
	

	@Override
	public void updateCustomer(Customer c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelAttr(int custNo, int attrNo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<UseList> getMyUseList(int custNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getMyInfo(int custNo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Customer cus = null;
		
		try {
			conn = getConnect();
			
//			String query = "SELECT * FROM customer where customer_no=?";
			ps = conn.prepareStatement(p.getProperty("jdbc.sql.getMyInfo"));
			ps.setInt(1, custNo);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				cus = new Customer(custNo, rs.getString("sex"),rs.getInt("age"));
			}
//			System.out.println("======"+custNo+"님 조회======");
		}finally {
			closeAll(rs,ps,conn);
		}
		return cus;
	}

	@Override
	public Attraction getAttrInfo(int attrNo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Attraction cus = null;
		
		try {
			conn = getConnect();
			
			String query = "SELECT * FROM attraction where attraction_no=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, attrNo);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				cus = new Attraction(attrNo, rs.getString("name"),rs.getInt("limitage"),rs.getInt("maxperson"),rs.getString("info"));
			}
//			System.out.println("======"+custNo+"님 조회======");
		}finally {
			closeAll(rs,ps,conn);
		}
		return cus;
	}

	public Attraction getAttrInfo(int attrNo, Connection conn) throws SQLException {

		PreparedStatement ps = null;
		ResultSet rs = null;
		Attraction cus = null;

		String query = "SELECT * FROM attraction where attraction_no=?";
		ps = conn.prepareStatement(query);
		ps.setInt(1, attrNo);
		
		rs = ps.executeQuery();
		if(rs.next()) {
			cus = new Attraction(attrNo, rs.getString("name"),rs.getInt("limitage"),rs.getInt("maxperson"),rs.getString("info"));
		}
		return cus;
	}
	
	
	@Override
	public ArrayList<Attraction> getAllAttr() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Attraction> totalRankAttr() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Attraction> ageRankAttr() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Attraction> sexRankAttr() {
		// TODO Auto-generated method stub
		return null;
	}


	public int getCount(int age) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int a=0;
		
		try {
			conn = getConnect();
			
			String query = "SELECT count(age) FROM customer where age=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, age);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				a = rs.getInt("count(age)");
			}
//			System.out.println("======"+custNo+"님 조회======");
		}finally {
			closeAll(rs,ps,conn);
		}
		return a;
	}
	
	

}

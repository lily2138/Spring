package jdbc.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;
import jdbc.dao.CustomerDAO;
import jdbc.vo.Customer;

/*
 * dao란?
 * Database Access Object의 약자로....
 * 디비에 접근하는 로직(중요한 로직.... 일명 비지니스 로직)을 담고있는 객체이다.
 * ::
 * 공통적인 로직과 가변적인 로직 둘로 나누어서 작성해준다.
 */

public class CustomerDAOImpl implements CustomerDAO {

	private static CustomerDAOImpl dao = new CustomerDAOImpl();
	private CustomerDAOImpl() { }
	public static CustomerDAOImpl getInstance() {
		return dao;
	}
	
	//공통적인 로직
	@Override
	public Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL,ServerInfo.USER , ServerInfo.PASS);
		System.out.println("Database Connection......");
		return conn;
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();
		
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if(rs!=null) rs.close();
		closeAll(ps,conn);
		
	}
	
	
	//비지니스 로직
	@Override
	public void registerCustomer(Customer vo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		conn = getConnect();
		
		String query = "INSERT INTO cust(id, pass, cust_name, address) VALUES(?,?,?,?)";
		ps = conn.prepareStatement(query);
		
		ps.setString(1,vo.getId());
		ps.setString(2,vo.getPass());
		ps.setString(3,vo.getName());
		ps.setString(4,vo.getAddress());
		
		ps.executeUpdate();
		System.out.println(vo.getName() + "님 , 회원가입되셨습니다.");
		
		/*ps.close();
		conn.close();*/
		//꼭 닫아줘야한다 꼭ㄲ꼬곡꼬꼮 
		closeAll(ps,conn);
		
	}

	@Override
	public void deleteCustomer(String id) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		conn = getConnect();
		
		String query = "DELETE FROM cust WHERE id = ?";
		ps = conn.prepareStatement(query);
		
		ps.setString(1, id);
		ps.executeUpdate();
		System.out.println(id + "님이 삭제되었습니다");
		
		closeAll(ps,conn);
		
	}

	@Override
	public void updateCustomer(Customer vo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		conn = getConnect();
		
		String query = "UPDATE cust SET pass = ?, cust_name=?, address = ? WHERE id = ?";
		ps = conn.prepareStatement(query);
		
		ps.setString(1, vo.getPass());
		ps.setString(2, vo.getName());
		ps.setString(3, vo.getAddress());
		ps.setString(4, vo.getId());
		ps.executeUpdate();
		System.out.println(vo.getId() + "업데이트되었습니다.");
		
		closeAll(ps,conn);
		
	}

	@Override
	public Customer getCustomer(String id) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Customer cus = null;
		
		conn = getConnect();
		
		String query = "SELECT * FROM cust where id=?";
		
		ps = conn.prepareStatement(query);
		ps.setString(1, id);
		
		rs = ps.executeQuery();
		if(rs.next()) {
			cus = new Customer(rs.getString("id"), rs.getString("pass"),rs.getString("cust_name"),rs.getString("address"));
		}
		closeAll(rs,ps,conn);
		
		return cus;
	}

	@Override
	public ArrayList<Customer> getAllCustomer() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList<Customer> custList = new ArrayList<>();
		
		conn = getConnect();
		String query = "SELECT id, pass, cust_name, address FROM cust";
		
		ps = conn.prepareStatement(query);
		rs = ps.executeQuery();
		while(rs.next()) {
			Customer cus = new Customer(rs.getString("id"), rs.getString("pass"),rs.getString("cust_name"),rs.getString("address"));
			custList.add(cus);
		}
		
		closeAll(rs,ps,conn);
		return custList;
	}

	@Override
	public Customer login(Customer vo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Customer cus = null;
		
		conn = getConnect();
		
		String query = "SELECT * FROM cust WHERE id=? AND pass=?";
		ps = conn.prepareStatement(query);
		ps.setString(1, vo.getId());
		ps.setString(2, vo.getPass());
		
		rs = ps.executeQuery();
		if(rs.next()) 
			cus = new Customer(rs.getString("id"), 
								rs.getString("pass"), 
								rs.getString("cust_name"), 
								rs.getString("address"));
		
		closeAll(rs,ps,conn);
		
		return cus;
	}

}

package servlet.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import config.ServerInfo;


public class MemberDAOImpl implements MemberDAO {
	private DataSource ds;
	//싱글톤
	private static MemberDAOImpl dao = new MemberDAOImpl();
	private MemberDAOImpl() {
		try {
			//Naming Service(JNDI API)....javax.naming.Context
			InitialContext ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/mysql");
			System.out.println("DataSource Lookup 성공.....");
			
		}catch(NamingException e) {
			System.out.println("DataSource Lookup 실패.....");
		}
	}
	public static MemberDAOImpl getInstance() {
		return dao;
	}
	

	@Override
	public Connection getConnection() throws SQLException {
		System.out.println("Database Connection......");
		return ds.getConnection(); //공장에서 하나의 Connection을 빌려서 나온다...
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

	@Override
	public void registerMember(MemberVO vo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnection();
			
			String query = "INSERT INTO member(id, password, name, address) VALUES(?,?,?,?)";
			ps = conn.prepareStatement(query);
			
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPassword());
			ps.setString(3, vo.getName());
			ps.setString(4, vo.getAddress());
			
			System.out.println(ps.executeUpdate()+"명 INSERT OK.... addMember()...");
		}finally {
			closeAll(ps,conn);
		}
		
	}

	@Override
	public ArrayList<MemberVO> showAllMember() throws SQLException {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList<MemberVO> memberList = new ArrayList<>();
		
		try {
			conn = getConnection();
			String query = "SELECT * FROM member";
			
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				//짱중요 
				MemberVO vo = new MemberVO(rs.getString(1),rs.getString(2),rs.getString(3), rs.getString(4));
				memberList.add(vo);
			}
//			System.out.println("======모든 고객 정보 조회======");
			
		}finally {
			closeAll(rs,ps,conn);
		}
		closeAll(rs,ps,conn);
		return memberList;
	}

	@Override
	public MemberVO findByIdMember(String id) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MemberVO mem = null;
		
		try {
			conn = getConnection();
			
			String query = "SELECT * FROM member where id=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				mem = new MemberVO(id, rs.getString("password"),rs.getString("name"),rs.getString("address"));
			}//if
			
		}finally {
			closeAll(rs,ps,conn);
		}
		
		return mem;
	}
	
	public MemberVO login(String id, String password) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MemberVO vo = null;
		
		try {
			conn = getConnection();
			String query = "SELECT * FROM member WHERE id=? AND password=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				vo = new MemberVO(id,
								  password,
								  rs.getString("name"),
								  rs.getString("address"));
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		return vo;
	}
	
	
	
	
	
/*	public static void main(String[] args) throws SQLException {
		MemberDAOImpl dao = MemberDAOImpl.getInstance();
		
		//dao.registerMember(new MemberVO("a","a","a","a"));
		//System.out.println(dao.findByIdMember("b"));
	}*/

}

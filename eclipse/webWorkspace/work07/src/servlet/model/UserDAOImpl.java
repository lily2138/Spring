package servlet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class UserDAOImpl implements UserDAO {

	private DataSource ds;
	//싱글톤
	private static UserDAOImpl dao = new UserDAOImpl();
	private UserDAOImpl() {
		try {
			//Naming Service(JNDI API)....javax.naming.Context
			InitialContext ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/mysql");
			System.out.println("DataSource Lookup 성공.....");
			
		}catch(NamingException e) {
			System.out.println("DataSource Lookup 실패.....");
		}
	}
	public static UserDAOImpl getInstance() {
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
	public ArrayList<UserVO> showAllUser() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList<UserVO> userList = new ArrayList<>();
		
		try {
			conn = getConnection();
			String query = "SELECT * FROM userinfo";
			
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				//짱중요 
				UserVO vo = new UserVO(rs.getString(1),rs.getString(2),rs.getString(3), rs.getString(4));
				userList.add(vo);
			}
//			System.out.println("======모든 고객 정보 조회======");
			
		}finally {
			closeAll(rs,ps,conn);
		}
		closeAll(rs,ps,conn);
		return userList;
	}

	@Override
	public UserVO login(String id, String password) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserVO vo = null;
		
		try {
			conn = getConnection();
			String query = "SELECT * FROM userinfo WHERE userId=? AND password=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				vo = new UserVO(id,
								  password,
								  rs.getString("name"),
								  rs.getString("email"));
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		return vo;
	}

}

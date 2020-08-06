package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.mysql.cj.Query;

import javafx.scene.shape.QuadCurve;
import util.DataSourceManager;

public class ItemDao {
	
	private DataSource ds;
	
	private static ItemDao dao= new ItemDao();
	private ItemDao() {
		//공장을 하나 받아와서 .... 그 안에 있는 Connection을 하나 빌려온다.
		ds = (DataSource)DataSourceManager.getInstance().getConnection();
	}
	public static ItemDao getInstance() {
		return dao;
	}
	
	//공통적인 로직 Connection, closeAll()
	public Connection getConnection() throws SQLException{
		System.out.println("디비연결 성공");
		return ds.getConnection();
	}
	
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException{
		if(ps!=null) ps.close();		
		if(conn != null) conn.close();
	}

	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException{		
		if(rs != null)	rs.close();
		closeAll(ps, conn);		
	}
	
	//가변적인 로직
	public ArrayList<Item> getAllItem() throws SQLException{
		ArrayList<Item> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String query = "SELECT * FROM item";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Item(
						rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
			}
		}finally {
			closeAll(rs,ps,conn);
		}
		return list;
	}
	
	public Item getItem(int itemNum) throws SQLException{
		Item item = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String query = "SELECT * FROM item WHERE item_id=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, itemNum);
			rs = ps.executeQuery();
			if(rs.next()) {
				item = new Item(itemNum, rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6));
						
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		return item;
	}
	
/*	public void addCount(Item item) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			String query = "UPDATE item SET count=? where item_id=? ";
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, item.getCount()+1);
			ps.setInt(2, item.getItemNumber());

			System.out.println(ps.executeUpdate()+" row update OK!!");		
			
		}finally {
			closeAll(ps, conn);
		}
	}*/
	
	public boolean addCount(int itemId) throws SQLException{
		boolean result = false;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String query = "UPDATE item SET count=count+1 where item_id=? ";
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, itemId);

			int row = ps.executeUpdate();	
			if(row>0)
				result=true;
			
		}finally {
			closeAll(ps, conn);
		}
		return result;
	}
}

package servlet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BookDAOImpl implements BookDAO {

	private DataSource ds;
	//싱글톤
	private static BookDAOImpl dao = new BookDAOImpl();
	private BookDAOImpl() {
		try {
			//Naming Service(JNDI API)....javax.naming.Context
			InitialContext ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/mysql");
			System.out.println("DataSource Lookup 성공.....");
			
		}catch(NamingException e) {
			System.out.println("DataSource Lookup 실패.....");
		}
	}
	public static BookDAOImpl getInstance() {
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
	public void registerBook(BookVO vo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnection();
			
			String query = "INSERT INTO book(isbn, title, catalogue, nation, publish_date, publisher, author, price, currency, description) VALUES(?,?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(query);
			
			ps.setString(1, vo.getIsbn());
			ps.setString(2, vo.getTitle());
			ps.setString(3, vo.getCatalogue());
			ps.setString(4, vo.getNation());
			ps.setString(5, vo.getPublishDate());
			ps.setString(6, vo.getPublisher());
			ps.setString(7, vo.getAuthor());
			ps.setInt(8, vo.getPrice());
			ps.setString(9, vo.getCurrency());
			ps.setString(10, vo.getDescription());
			
			System.out.println(ps.executeUpdate()+"명 INSERT OK.... addBook()...");
		}finally {
			closeAll(ps,conn);
		}
		
	}

	@Override
	public ArrayList<BookVO> showAllBook() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList<BookVO> bookList = new ArrayList<>();
		
		try {
			conn = getConnection();
			String query = "SELECT * FROM book";
			
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				//짱중요 
				BookVO vo = new BookVO(rs.getString(1),rs.getString(2),rs.getString(3), rs.getString(4),
										rs.getString(5),rs.getString(6),rs.getString(7), rs.getInt(8),
										rs.getString(9),rs.getString(10));
				bookList.add(vo);
			}
			
		}finally {
			closeAll(rs,ps,conn);
		}
		closeAll(rs,ps,conn);
		return bookList;
	}

	@Override
	public ArrayList<BookVO> findBook(String findKey, String findValue) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList<BookVO> bookList = new ArrayList<>();
		
		String query="";
		
		String title = "SELECT * FROM book WHERE title LIKE ?";
		String publisher = "SELECT * FROM book WHERE publisher LIKE ?";
		String price = "SELECT * FROM book where price <= ?";
		
		try {
			conn = getConnection();
			if(findKey.equals("title")) {
				query = title;
			}else if(findKey.equals("publisher")) {
				query = publisher;
			}else if(findKey.equals("price")) {
				query = price;
			}else {
				query = "SELECT * FROM book";
			}
			ps = conn.prepareStatement(query);
			
			if(query.equals(price)) {
				ps.setInt(1, Integer.parseInt(findValue));
			}else if(query.equals(publisher) || query.equals(title)) {
				ps.setString(1, "%"+findValue+"%");
			}
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				BookVO vo = new BookVO(rs.getString(1),rs.getString(2),rs.getString(3), rs.getString(4),
						rs.getString(5),rs.getString(6),rs.getString(7), rs.getInt(8),
						rs.getString(9),rs.getString(10));
				bookList.add(vo);
			}//if
			
		}finally {
			closeAll(rs,ps,conn);
		}
		
		return bookList;
	}
	
	@Override
	public BookVO bookView(String title) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		BookVO book = null;
		
		String query = "SELECT title, publisher, author FROM book WHERE title ?";
		try {
			conn = getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, title);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				book = new BookVO(title,
								  rs.getString("publisher"),
								  rs.getString("author"));
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		System.out.println(book);
		return book;
	}
	
	
	//데이터소스때문에 메인에서 안돌아감
	public static void main(String[] args) throws SQLException {
		BookDAOImpl dao = BookDAOImpl.getInstance();
		
		//dao.registerMember(new MemberVO("a","a","a","a"));
		//System.out.println(dao.findByIdMember("b"));
		System.out.println(dao.showAllBook());
	}


}

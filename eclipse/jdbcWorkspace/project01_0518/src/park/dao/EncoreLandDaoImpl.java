package park.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import park.exception.InvalidTransactionException;
import park.exception.RecordNotFoundException;
import park.vo.Attraction;
import park.vo.Customer;
import park.vo.UseList;

public class EncoreLandDaoImpl implements EncoreLandDao {
	static Properties p = new Properties();

	public Connection getConnect() throws SQLException {
		Connection conn = null;

		try {
			p.load(new FileInputStream("src/config/jdbc.properties"));

			// 2 key 로 읽어들인 값을 각각의 변수에 할당
			String driverName = p.getProperty("jdbc.mysql.driver");
			String url = p.getProperty("jdbc.mysql.url");
			String user = p.getProperty("jdbc.mysql.user");
			String pass = p.getProperty("jdbc.mysql.pass");

			// 3 드라이버 로딩
			Class.forName(driverName);
			//System.out.println("드라이버 로딩");

			// 4 서버연결
			conn = DriverManager.getConnection(url, user, pass);
			//System.out.println("연결 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void closeAll(PreparedStatement ps, Connection conn) {
		try {
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeAll(ps, conn);
	}

	private static EncoreLandDaoImpl db = new EncoreLandDaoImpl();

	private EncoreLandDaoImpl() {

	}

	public static EncoreLandDaoImpl getInstance() {
		return db;
	}

	// n명의 고객 추가
	public void randAddCustomer(int n) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			conn.setAutoCommit(false);
			// String query = "INSERT INTO customer (sex,age) VALUES(?,?)";
			ps = conn.prepareStatement(p.getProperty("jdbc.sql.AddCustomer"));
			int randInt = 1;
			double randDouble;
			for (int i = 0; i < n; i++) {
				randDouble = Math.random();
				if (randDouble > 0.5)
					ps.setString(1, "M");
				else
					ps.setString(1, "F");
				randDouble = Math.random();
				randInt = (int) (randDouble * 80);
				ps.setInt(2, randInt);
				ps.executeUpdate();

			}
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
			conn.setAutoCommit(true);
		} finally {
			closeAll(ps, conn);
		}

	}

	// 1번부터 custN번 까지의 고객이 1000~1009번까지의 놀이기구를 무작위로 사용하게함, n개의 사용내역 생성
	public void randUseAttraction(int n, int custN) throws SQLException {
		for (int i = 0; i < n; i++) {
			//System.out.println(1 + (int) (Math.random() * custN) + "========" + (1000 + (int) (Math.random() * 10)));
			try {
				useAttraction(1 + (int) (Math.random() * custN), 1000 + (int) (Math.random() * 10)); // 같은 고객이 같은 놀이기구에
																										// 연속으로 두번
																										// useAttraction을
																										// 신청할 수 있음.
																										// useAttraction에서
																										// 예외처리 필요
			} catch (InvalidTransactionException e) {
				System.out.println(e.getMessage());
			}
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
		} finally {
			closeAll(ps, conn);
		}

	}

	@Override
	public void useAttraction(int custNo, int attrNo) throws SQLException, InvalidTransactionException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int order = 0;
		try {
			conn = getConnect();
			
			conn.setAutoCommit(false);
			// 사용자가 대기 상태 혹은 탑승 상태에서 예약 재요청시 throw
			String query3 = "SELECT status FROM uselist WHERE customer_no = ? AND attraction_no = ? AND status =1";
			ps = conn.prepareStatement(query3);
			ps.setInt(1, custNo);
			ps.setInt(2, attrNo);
			rs = ps.executeQuery(); // 만약 대기중 인원에 사용자가 등록되어있으면
			if (rs.next()) {
				throw new InvalidTransactionException("이미 고객님은 줄을 서 있습니다.");
			}
//			String query = "INSERT into uselist(customer_no,attraction_no,status) values(?,?,?)";
			ps = conn.prepareStatement(p.getProperty("jdbc.sql.useAttr"));
			ps.setInt(1, custNo);
			ps.setInt(2, attrNo);
			ps.setInt(3, getCurrentStatus(attrNo, conn));
			
			ps.executeUpdate();
			
			
			
			// 사용자 나이가 기구 제한 연령보다 낮을시 throw
			String query1 = "SELECT limitage FROM attraction where attraction_no = ?";
			ps = conn.prepareStatement(query1);
			ps.setInt(1, attrNo);
			rs = ps.executeQuery();
			rs.next();
			int limit = rs.getInt(1);
			String query2 = "SELECT age FROM customer WHERE customer_no = ?";
			ps = conn.prepareStatement(query2);
			ps.setInt(1, custNo);
			rs = ps.executeQuery();
			rs.next();
			int age = rs.getInt(1);
			if (limit > age) {
				conn.rollback();
				conn.setAutoCommit(true);
				throw new InvalidTransactionException("사용자 나이가 더 적습니다.");
			}
			conn.commit();
			if (getCurrentStatus(attrNo, conn) == 1) {
				order= getOrder(custNo, attrNo);
				System.out.println("대기해야합니다, 대기번호 : "+order);
			}
			else if (getCurrentStatus(attrNo, conn) == 0)
				System.out.println("탑승완료 ! ");
		} finally {
			closeAll(rs, ps, conn);
		}
	}

	private void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) {
		// TODO Auto-generated method stub

	}

	public int getCurrentStatus(int attrNo, Connection conn) throws SQLException {
		int sta = -1;

//		String query = "select count(status) from uselist where attraction_no = ? and status = 0";
		PreparedStatement ps = conn.prepareStatement(p.getProperty("jdbc.sql.getCurrSta"));

		ps.setInt(1, attrNo);

		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			if (rs.getInt("count(status)") == getAttrInfo(attrNo, conn).getMaxPerson())
				sta = 1;
			else if (rs.getInt("count(status)") < getAttrInfo(attrNo, conn).getMaxPerson())
				sta = 0;
		}

		return sta;
	}

	@Override
	public void updateCustomer(Customer c) throws SQLException { //
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = getConnect();
			String query = p.getProperty("jdbc.sql.updateCustomer");
			ps = conn.prepareStatement(query);

			ps.setString(1, c.getSex());
			ps.setInt(2, c.getAge());
			ps.setInt(3, c.getCustNo());

			ps.executeUpdate();
			System.out.println("수정되었습니다.");

		} finally {
			closeAll(ps, conn);
		}
	}

	@Override
	public void cancelAttr(int custNo, int attrNo) throws SQLException, RecordNotFoundException {
		Connection conn = getConnect(); // status -2 -> 취소함
		PreparedStatement ps = null;
		ResultSet rs = null;
		// String query = "DELETE FROM uselist WHERE customer_no=?,attraction_no=?";
		try {
			String query = "SELECT * FROM uselist WHERE customer_no = ? AND attraction_no = ?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, custNo);
			ps.setInt(2, attrNo);
			rs = ps.executeQuery();
			if (!rs.next())
				throw new RecordNotFoundException();

			ps = conn.prepareStatement(p.getProperty("jdbc.sql.cancelAttr"));
			ps.setInt(1, custNo);
			ps.setInt(2, attrNo);
			ps.executeUpdate();
		} finally {
			closeAll(rs, ps, conn);
		}
	}

	@Override
	public ArrayList<UseList> getMyUseList(int custNo) throws SQLException {
		Connection conn = getConnect();
		ArrayList<UseList> ar = new ArrayList<>();
		int order = 0;
		// String query = "SELECT no, customer_no, attraction_no, usedate, status FROM
		// uselist WHERE customer_no = ?";
		PreparedStatement ps = conn.prepareStatement(p.getProperty("jdbc.sql.getMyUseList"));
		ps.setInt(1, custNo);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			UseList useList = new UseList(rs.getInt("uselist_no"), rs.getInt("customer_no"), rs.getInt("attraction_no"),
					rs.getString("usedate"), rs.getInt("status"));

			ar.add(useList);
			if(rs.getInt("status")==1) {
				order = getOrder(rs.getInt("customer_no"), rs.getInt("attraction_no"));
				System.out.println(useList.toString() + "대기번호  : "+order);
			}
			else {
				System.out.println(useList.toString());
			}
			
		}
		closeAll(rs, ps, conn);
		return ar;
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
			if (rs.next()) {
				cus = new Customer(custNo, rs.getString("sex"), rs.getInt("age"));
			}
			System.out.println(cus.toString());
//			System.out.println("======"+custNo+"님 조회======");
		} finally {
			closeAll(rs, ps, conn);
		}
		return cus;
	}

	@Override
	public Attraction getAttrInfo(int attrNo) throws SQLException { //
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Attraction attr = null;

		try {
			conn = getConnect();
			String query = p.getProperty("jdbc.sql.getAttrInfo");
			ps = conn.prepareStatement(query);

			ps.setInt(1, attrNo);
			rs = ps.executeQuery();

			rs.next();
			attr = new Attraction(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5));
		} finally {
			closeAll(rs, ps, conn);
		}
		return attr;
	}

	@Override
	public Attraction getAttrInfo(int attrNo, Connection conn) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Attraction attr = null;
		String query = "SELECT * FROM attraction where attraction_no=?";
		ps = conn.prepareStatement(query);
		ps.setInt(1, attrNo);

		rs = ps.executeQuery();
		if (rs.next()) {
			attr = new Attraction(attrNo, rs.getString("name"), rs.getInt("limitage"), rs.getInt("maxperson"),
					rs.getString("info"));
		}
		return attr;
	}

	@Override
	public ArrayList<Attraction> getAllAttr() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Attraction> arr = new ArrayList<>();

		conn = getConnect();
		ps = conn.prepareStatement(p.getProperty("jdbc.sql.getAllAttr"));
		rs = ps.executeQuery();
		while (rs.next()) {
			Attraction attr = new Attraction(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4),
					rs.getString(5));
			arr.add(attr);
			System.out.println(attr.toString());
		}
		closeAll(rs, ps, conn);
		return arr;
	}

	@Override
	public ArrayList<Attraction> totalRankAttr() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Attraction> arr = new ArrayList<>();

		conn = getConnect();
		ps = conn.prepareStatement(p.getProperty("jdbc.sql.totalRankAttr"));
		rs = ps.executeQuery();
		while (rs.next()) {
			Attraction attr = new Attraction(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4),
					rs.getString(5));
			arr.add(attr);
			System.out.println(attr.toString());
		}
		closeAll(rs, ps, conn);
		return arr;
	}

	@Override
	public ArrayList<Attraction> ageRankAttr(int n, int m) throws SQLException {
		Connection conn = getConnect();
		ArrayList<Attraction> arr = new ArrayList<>();
		PreparedStatement ps = conn.prepareStatement(p.getProperty("jdbc.sql.ageRankAttr"));
		ps.setInt(1, n);
		ps.setInt(2, m);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Attraction attr = new Attraction(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4),
					rs.getString(5));
			arr.add(attr);
		}
		return arr;
	}

	public ArrayList<Attraction> sexRankAttr(String sex) throws SQLException { //
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Attraction> arr = new ArrayList<Attraction>();

		try {
			conn = getConnect();

			String query = p.getProperty("jdbc.sql.sexRankAttr");
			ps = conn.prepareStatement(query);
			ps.setString(1, sex);
			rs = ps.executeQuery();
			/*
			 * System.out.println("=========*** 성별 인기 어트랙션 순위 ***=========");
			 * System.out.println("       <남성>		<여성>");
			 */
			while (rs.next()) {
				Attraction attr = new Attraction(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4),
						rs.getString(5));
				arr.add(attr);
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		return arr;
	}

	@Override
	public int getOrder(int custNo, int attrNo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int myOrder = 0;
		
		conn = getConnect();
		String query1 = "set @rownum =0";
		ps = conn.prepareStatement(query1);
		ps.executeUpdate();
		
		String query2 = "select temp.myorder from (select @rownum:=@rownum+1 myorder, attraction_no, customer_no from uselist where status = 1 and attraction_no = ?) temp where temp.customer_no = ?";
		ps = conn.prepareStatement(query2);
		ps.setInt(1, attrNo);
		ps.setInt(2, custNo);
		rs = ps.executeQuery();
		if(rs.next())
			myOrder = rs.getInt("myorder");
		closeAll(conn, ps, rs);
		return myOrder;
	}

}

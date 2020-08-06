package broker.twotier.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.transaction.InvalidTransactionException;

import broker.twotier.exception.DuplicateSSNException;
import broker.twotier.exception.RecordNotFoundException;
import broker.twotier.vo.CustomerRec;
import broker.twotier.vo.SharesRec;
import broker.twotier.vo.StockRec;
import config.ServerInfo;

public class Database implements DatabaseTemplate{

	public Database(String serverIp) throws ClassNotFoundException {
		Class.forName(ServerInfo.DRIVER_NAME);
		System.out.println("드라이버 로딩 성공....");
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
	
	
	public boolean isExist(String ssn, Connection conn) throws SQLException{
		//있는지 없는지 존재유무 확인.... 
		
		// Connection conn = getConnect(); ---> connection을 두개 열게된다. 그러므로 위에 인자로 받아줘서 밑에서 열었던 커넥션을 쓴다.
		
		String sql = "SELECT * FROM customer WHERE ssn=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, ssn);
		ResultSet rs = ps.executeQuery();
		
		return rs.next();
		
		
	}
	
	
	

	//비지니스 로직 .... 
	@Override
	public void addCustomer(CustomerRec cust) throws SQLException, DuplicateSSNException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnect();
			
			if(!isExist(cust.getSsn(), conn)) {//없는거야 ... 없으니까 추가가능
				String query = "INSERT INTO customer(ssn, cust_name, address) VALUES(?,?,?)";
				ps = conn.prepareStatement(query);
				
				ps.setString(1, cust.getSsn());
				ps.setString(2, cust.getName());
				ps.setString(3, cust.getAddress());
				
				System.out.println(ps.executeUpdate()+"명 INSERT OK.... addCustomer()...");
			}else {
				throw new DuplicateSSNException(cust.getName()+" 님은 이미 회원이십니다....");
			}
		}finally {
			closeAll(ps,conn);
		}
	}

	@Override
	public void deleteCustomer(String ssn) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
	
		try {
			
			conn = getConnect();
			
			if(isExist(ssn, conn)) {//없는거야 ... 없으니까 추가가능
				String query = "DELETE FROM customer WHERE ssn=?";
				ps = conn.prepareStatement(query);
				
				ps.setString(1, ssn);
				
				System.out.println(ps.executeUpdate()+"명 DELETE OK.... deleteCustomer()...");
			}else {
				throw new RecordNotFoundException(ssn+" 님은 존재하지 않습니다");
			}
			
		}finally {
			closeAll(ps,conn);
		}
	}

	@Override
	public void updateCustomer(CustomerRec cust) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
	
		try {
			conn = getConnect();
			
			if(isExist(cust.getSsn(), conn)) {//있으면 수정가능
				String query = "UPDATE customer set cust_name=?, address=? WHERE ssn=?";
				ps = conn.prepareStatement(query);
				
				ps.setString(1, cust.getName());
				ps.setString(2, cust.getAddress());
				ps.setString(3, cust.getSsn());
				
				System.out.println(ps.executeUpdate()+"명 update OK.... updateCustomer()...");
			}else {
				throw new RecordNotFoundException(cust.getSsn()+" 님은 존재하지 않습니다");
			}
			
		}finally {
			closeAll(ps,conn);
		}
		
	}

	// 짱중요
	@Override
	public Vector<SharesRec> getPortfolio(String ssn) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Vector<SharesRec> shares = new Vector<>();
		
		try {
			conn = getConnect();
			
			String query = "SELECT ssn, symbol, quantity FROM Shares where ssn=?";
			ps = conn.prepareStatement(query);
			
			ps.setString(1, ssn);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				SharesRec sha = new SharesRec(ssn, rs.getString("symbol"),rs.getInt("quantity"));
				shares.add(sha);
			}
		}finally {
			closeAll(rs,ps,conn);
		}
		
		
		return shares;
	}

	@Override
	public CustomerRec getCustomer(String ssn) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		CustomerRec cus = null;
		
		try {
			conn = getConnect();
			
			String query = "SELECT * FROM customer where ssn=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, ssn);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				cus = new CustomerRec(ssn, rs.getString("cust_name"),rs.getString("address"));
			}//if
			cus.setPortfolio(getPortfolio(ssn));
//			System.out.println("======"+ssn+"님 조회======");
				
				
		}finally {
			closeAll(rs,ps,conn);
		}
		
		return cus;
	}

	@Override
	public ArrayList<CustomerRec> getAllCustomers() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList<CustomerRec> custList = new ArrayList<>();
		
		try {
			conn = getConnect();
			String query = "SELECT * FROM customer";
			
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				//짱중요 
				CustomerRec cus = new CustomerRec(rs.getString(1),rs.getString(2),rs.getString(3),getPortfolio(rs.getString(1)));
				custList.add(cus);
			}
//			System.out.println("======모든 고객 정보 조회======");
			
		}finally {
			closeAll(rs,ps,conn);
		}
		closeAll(rs,ps,conn);
		return custList;

	}

	@Override
	public ArrayList<StockRec> getAllStocks() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList<StockRec> stockList = new ArrayList<>();
		
		try {
			conn = getConnect();
			String query = "SELECT symbol, price FROM stock";
			
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				StockRec sto = new StockRec(rs.getString("symbol"),rs.getFloat("price"));
				stockList.add(sto);
			}
//			System.out.println("======모든 주식 정보 조회======");
			
		}finally {
			closeAll(rs,ps,conn);
		}
		closeAll(rs,ps,conn);
		return stockList;
	}

	@Override
	public void buyShares(String ssn, String symbol, int quantity) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		/*try {
			conn = getConnect();
			if(isExist(ssn, conn)){
				
				String query = "INSERT INTO shares(ssn, symbol, quantity)  VALUES(?,?,?)";
				
				ps = conn.prepareStatement(query);

				ps.setString(1,ssn);
				ps.setString(2,symbol);
				ps.setInt(3,quantity);
				
				//고객이 가지기
				SharesRec share = new SharesRec(ssn,symbol,quantity);
				Vector<SharesRec> ports = new Vector<>();
				ports.add(share);
				getCustomer(ssn).setPortfolio(ports);
				
				System.out.println(ps.executeUpdate()+"개 BUY OK.... buyShares()...");

			}else{
				throw new RecordNotFoundException(ssn +" 님은 존재하지 않습니다");
			}
		}finally {
			closeAll(ps,conn);
		}*/
		
		try {
		conn = getConnect();
			if(isExist(ssn, conn)){
				
				String query = "SELECT quantity from shares where ssn=? AND symbol=?";
				
				ps = conn.prepareStatement(query);
	
				ps.setString(1,ssn);
				ps.setString(2,symbol);
	
				rs = ps.executeQuery();
				
				if(rs.next()) {
					int q = rs.getInt(1); //50 ...현재 가지고 이는 주식의 수량
					int newQuantity = q+quantity; //50+100 = 150 .... UPDATE
					String query1 = "UPDATE shares SET quantity=? WHERE ssn=? AND symbol=?";
					
					ps = conn.prepareStatement(query1);
					ps.setInt(1, newQuantity);
					ps.setString(2, ssn);
					ps.setString(3, symbol);
					System.out.println(ps.executeUpdate()+"개 BUY OK.... buyShares()...update");
				}else { //주식이 없다... INSERT
					String query2 = "INSERT INTO shares(ssn, symbol, quantity)  VALUES(?,?,?)";
					ps = conn.prepareStatement(query2);
					ps.setString(1,ssn);
					ps.setString(2,symbol);
					ps.setInt(3,quantity);
					System.out.println(ps.executeUpdate()+"개 BUY OK.... buyShares()...insert");
				};
	
			}else{
				throw new RecordNotFoundException(ssn +" 님은 존재하지 않습니다");
			}
		}finally {
			closeAll(rs, ps,conn);
		}
		
		
	}


/*누가 어떤 주식을 몇개 팔것인가.... 현재 몇개를 가지고 있는가....
1) 100개를 현재 가지고 있다 ---- 50 ---- UPDATE
2) 100개를 현재 가지고 있다 ---- 100 ---- DELETE 
3) 100개를 현재 가지고 있다 ---- 200 ---- 펑
4) 팔려는 고객이 없을때 ---- 펑*/
	@Override
	public void sellShares(String ssn, String symbol, int quantity) throws SQLException, RecordNotFoundException, InvalidTransactionException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnect();
			if(!isExist(ssn,conn)) {
				throw new RecordNotFoundException(ssn +" 님은 존재하지 않습니다");
			}else {
				String query = "SELECT quantity FROM shares WHERE ssn=? AND symbol=?";
				ps = conn.prepareStatement(query);
				ps.setString(1, ssn);
				ps.setString(2, symbol);
				
				rs=ps.executeQuery();
				rs.next();//일단 커서를 한단계 밑으로 내려서 수량을 받아올 준비를 한다.
				
				int q = rs.getInt(1); //100개 현재 가지고 있다
				int newQuantity = q - quantity; // 팔고남은 수량....
				
				if(q==quantity) { //delete
					String query2 = "DELETE FROM shares WHERE ssn=? AND symbol=?";
					ps = conn.prepareStatement(query2);
					ps.setString(1, ssn);
					ps.setString(2, symbol);
					
					System.out.println(ps.executeUpdate()+"SHARES DELETE.... sellShares()");
				}else if(q>quantity) { //update
					String query3 = "UPDATE shares SET quantity=? WHERE ssn=? AND symbol=?";
					ps = conn.prepareStatement(query3);
					ps.setInt(1, newQuantity);
					ps.setString(2, ssn);
					ps.setString(3, symbol);
					
					System.out.println(ps.executeUpdate()+"SHARES UPDATE.... sellShares()");
				}else { //q<quantity  //펑
					throw new InvalidTransactionException("팔려는 주식의 수량이 너무많아요");
				}
			}
		}finally {
			closeAll(rs,ps,conn);
		}
		
	}

}








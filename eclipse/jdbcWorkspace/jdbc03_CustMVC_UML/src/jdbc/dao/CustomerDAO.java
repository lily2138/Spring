package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.vo.Customer;

public interface CustomerDAO {

	Connection getConnect() throws SQLException;
	void closeAll(PreparedStatement ps, Connection conn) throws SQLException;
	void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException;
	
	void registerCustomer(Customer vo) throws SQLException;
	void deleteCustomer(String id) throws SQLException;
	void updateCustomer(Customer vo) throws SQLException;
	
	Customer getCustomer(String id) throws SQLException;
	ArrayList<Customer> getAllCustomer() throws SQLException;
	
	//? 생성자 오버로딩
	Customer login(Customer vo)throws SQLException;
	
}

package park.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import park.vo.Attraction;
import park.vo.Customer;
import park.vo.UseList;

public interface EncoreLandDao {
	//add
	public void entranceCustomer(Customer c) throws SQLException; //1
	
	// useList에 추가 -> get Order를 안에 넣어서 리턴타입도 바꿔주거나 하고싶은데로 하세요. 나이 따라서 튕겨내는 매소드도 작성하세요.
	public void useAttraction(int custNo,int attrNo) throws SQLException;	//공통
	
	//update
	public void updateCustomer(Customer c);	//2
	public void cancelAttr(int custNo, int attrNo);	//3
	
	//read
	public ArrayList<UseList> getMyUseList(int custNo);	//3
	public Customer getMyInfo(int custNo) throws SQLException;	//1
	public Attraction getAttrInfo(int attrNo) throws SQLException;	//2
	public ArrayList<Attraction> getAllAttr();	//4
	
	// analysis
	public ArrayList<Attraction> totalRankAttr();	//4
	public ArrayList<Attraction> ageRankAttr();	//3
	public ArrayList<Attraction> sexRankAttr();	//2
	
	
	
	// useList에 있는 고객이 사용하고싶은 기구에 몇번째 대기자인지 돌려주세요. 만약 대기자가 아니라 바로 탈 수 있으면
	public int getCurrentStatus(int attrNo,Connection conn) throws SQLException;	//공통
	// 만약 시간까지 계산하고싶으면 밑에 추가해서 하세요.
}

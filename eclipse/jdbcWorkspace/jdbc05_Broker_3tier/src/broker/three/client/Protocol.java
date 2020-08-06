package broker.three.client;
/*
 * Protocol + Jury
 * 서버----ProtocolHandler
 * 클라이언트----Broker
 */

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Vector;

import javax.activity.InvalidActivityException;
import javax.transaction.InvalidTransactionException;

import broker.three.exception.DuplicateSSNException;
import broker.three.exception.RecordNotFoundException;
import broker.three.shares.Command;
import broker.three.vo.CustomerRec;
import broker.three.vo.SharesRec;
import broker.three.vo.StockRec;

//Database의 동명이인
//클라이언트 사이드의 통신의 대표주자....Socket...스트림
public class Protocol {
	
	private Socket s;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private Command cmd;
	public static final int MIDDLE_PORT = 60000;
	
	public Protocol(String serverIp) throws Exception {
		s = new Socket(serverIp, MIDDLE_PORT);
		oos = new ObjectOutputStream(s.getOutputStream());
		ois = new ObjectInputStream(s.getInputStream());
	}
	
	public void close() {
		try {
			s.close();
		}catch(Exception e) {
			System.out.println("Protocol.close()...."+e);
		}
	}
	
	//공통적인 로직 작성....
	//Command object를stream에write한다.
	public void writeCommand(Command cmd) {
		//도시락 날린다.
		try {
			oos.writeObject(cmd);
			System.out.println("Client writeCommand .... end....");
		}catch (IOException e) {
			System.out.println("Client Protocol writeCommand .... error"+e);
		}
	}
	
	//Stream으로부터읽은Command객체를member에할당하고
	//Command의status 값을가져온다.
	public int getResponse() { //readObject() + getResults().getStatus() ---> Status code
		try {
			cmd = (Command) ois.readObject();
			System.out.println("Client readObject()....end....");
		} catch (Exception e) {
			System.out.println("Client getResponse()....error...."+e);
		}
		 //0, DuplicateE(-2), RecordNE(-1), InvalidE(-3)
		int status = cmd.getResults().getStatus();
		return status;
	}
	
	public void addCustomer(CustomerRec cust) throws DuplicateSSNException{
		/*
		 * 1. 도시락 싼다. (Data Packing...setter)
		 * 2. 던진다...Jury가 받는다
		 * -------------------------------------
		 * 3. jury가 던진 도시락 받는다
		 * 4. 양수 | 정상 		음수 | 펑
		 */
		
		cmd = new Command(Command.ADDCUSTOMER);
		String[] str = {cust.getSsn(), cust.getName(), cust.getAddress()};  //반찬만 만듦 아직 도시락 안쌈
		cmd.setArgs(str); //이렇게 까지해야 도시락 다싼거임

		writeCommand(cmd);
		
		//Jury가 보낸 데이타 받는다....응답결과
		int status = getResponse();  //data Unpacking... getter
		if(status==-2)
			throw new DuplicateSSNException("그런 회원 이미 있어요...");
	}
	
	public void deleteCustomer(String ssn) throws RecordNotFoundException{
		//1. 도시락 싼다 (커맨드)
		cmd = new Command(Command.DELETECUSTOMER);
		String[] str = {ssn};  //반찬만 만듦 아직 도시락 안쌈
		cmd.setArgs(str); //이렇게 까지해야 도시락 다싼거임

		//던진다 jury에게! 
		writeCommand(cmd);
		
		//Jury가 보낸 데이타 받는다....응답결과
		int status = getResponse();
		if(status==-1)
			throw new RecordNotFoundException("삭제할 대상이 없어요");
	}
	
	public void updateCustomer(CustomerRec cust) throws RecordNotFoundException{
		cmd = new Command(Command.UPDATECUSTOMER);
		String[] str = {cust.getSsn(), cust.getName(), cust.getAddress()};  //반찬만 만듦 아직 도시락 안쌈
		cmd.setArgs(str); //이렇게 까지해야 도시락 다싼거임

		writeCommand(cmd);
		
		//Jury가 보낸 데이타 받는다....응답결과
		int status = getResponse();
		if(status==-1)
			throw new RecordNotFoundException("수정할 대상이 없어요");
	}
	
	
	public CustomerRec getCustomer(String ssn){
		CustomerRec cr = null;
		//1.도시락싼다.
		cmd = new Command(Command.GETCUSTOMER);
		String[] str = {ssn};  //반찬만 만듦 아직 도시락 안쌈
		cmd.setArgs(str); //이렇게 까지해야 도시락 다싼거임

		//2. 도시락 던진다...Jury쪽으로
		writeCommand(cmd);
		
		//Jury가 보낸 데이타 받는다....응답결과
		int status = getResponse(); //상태값, 결과값 | cmd는 Jury가 던진 도시락
		return (CustomerRec) cmd.getResults().get(0);

	}
	
	public ArrayList<CustomerRec> getAllCustomers(){
		ArrayList<CustomerRec> list = null;
		cmd = new Command(Command.GETALLCUSTOMERS);
		//반찬없다
		
		writeCommand(cmd);
		
		//Jury가 보낸 데이타 받는다....응답결과
		int status = getResponse(); //cmd....jury가 던진 cmd
		list = (ArrayList<CustomerRec>) cmd.getResults().get(0);
		return list;
		
	}
	
	public ArrayList<StockRec> getAllStocks(){
		ArrayList<StockRec> list = null;
		cmd = new Command(Command.GETALLSTOCK);
		//반찬없다
		
		writeCommand(cmd);
		
		//Jury가 보낸 데이타 받는다....응답결과
		int status = getResponse(); //cmd....jury가 던진 cmd
		list = (ArrayList<StockRec>) cmd.getResults().get(0);
		return list;
		
	}
	
	public void buyShares(String ssn, String symbol, int quantity) throws RecordNotFoundException{
		
		cmd = new Command(Command.BUYSHARES);
		String[] str = {ssn, symbol, String.valueOf(quantity)};  //반찬만 만듦 아직 도시락 안쌈
		cmd.setArgs(str); //이렇게 까지해야 도시락 다싼거임

		writeCommand(cmd);
		
		//Jury가 보낸 데이타 받는다....응답결과
		int status = getResponse();
		if(status==-1)
			throw new RecordNotFoundException("주식을 살 사람이 없어요");
		
	}
	
	public void sellShares(String ssn, String symbol, int quantity) throws RecordNotFoundException, InvalidTransactionException{
		cmd = new Command(Command.SELLSHARES);
		String[] str = {ssn, symbol, String.valueOf(quantity)};  //반찬만 만듦 아직 도시락 안쌈
		cmd.setArgs(str); //이렇게 까지해야 도시락 다싼거임

		writeCommand(cmd);
		
		//Jury가 보낸 데이타 받는다....응답결과
		int status = getResponse();
		if(status==-1)
			throw new RecordNotFoundException("주식을 팔 사람이 없어요");
		if(status==-3)
			throw new InvalidTransactionException("팔려는 주식의 양이 넘 많아요");
	}
	
	
	
}

package broker.three.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import broker.three.exception.DuplicateSSNException;
import broker.three.exception.InvalidTransactionException;
import broker.three.exception.RecordNotFoundException;
import broker.three.shares.Command;
import broker.three.shares.Result;
import broker.three.vo.CustomerRec;
import broker.three.vo.StockRec;

public class JuryThread extends Thread{
	Socket s;
	Database db;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	Command cmd;
	
	public JuryThread(Socket s, Database db){
		this.s = s;
		this.db = db;
		
		try {
			ois = new ObjectInputStream(s.getInputStream());
			oos = new ObjectOutputStream(s.getOutputStream());
		}catch(IOException e) {
			
		}
		System.out.println("Jury Creating...");		
	}
	
	public void run() {		
		System.out.println("run()....들어옴...");
		while(true) {
		try {
			//1. 도시락 받는다.
			cmd = (Command)ois.readObject();
			System.out.println("cmd...Jury readObject()...");		
		}catch(Exception e) {
			
		}
		
		//2. 도시락 깐다...Data UnPack...getter...상수값|반찬통|빈통
		int comm = cmd.getCommandValue();//10~90까지의 숫자가 튀어나온다.
		String[ ] args = cmd.getArgs();
		Result r = cmd.getResults();
		
		switch(comm) {//실수형은 못온다
		case Command.BUYSHARES:
			try {
				db.buyShares(args[0], args[1], Integer.parseInt(args[2]));
				r.setStatus(0);
			}catch(Exception e) {				
			}
			break;
		case Command.SELLSHARES:
			try {
				db.sellShares(args[0], args[1], Integer.parseInt(args[2]));
				r.setStatus(0);
			}catch(RecordNotFoundException e) {	
				System.out.println("주식을 살 고객이 없어요...jury...");
				r.setStatus(-1);
			}catch(InvalidTransactionException e) {		
				System.out.println("팔려는 주식의 수량이 너무 많아요...jury...");
				r.setStatus(-3);
			}catch(Exception e) {				
			}
			break;
		case Command.GETALLSTOCK:
			try {
				ArrayList<StockRec> list=db.getAllStocks();
				r.setStatus(0);
				r.add(list);
			}catch(Exception e) {	
			
			}
			break;
		case Command.GETALLCUSTOMERS:
			try {
				ArrayList<CustomerRec> list=db.getAllCustomers();
				System.out.println(list);
				r.setStatus(0);
				r.add(list);
			}catch(Exception e) {	
			
			}
			break;
		case Command.GETCUSTOMER:
			try {
				CustomerRec cust=db.getCustomer(args[0]);
				r.setStatus(0);
				r.add(cust);
			}catch(Exception e) {	
			
			}
			break;
		case Command.ADDCUSTOMER: //addCustomer()
			try {
				CustomerRec cr = new CustomerRec(args[0], args[1], args[2]);
				db.addCustomer(cr);//디비 갔다온다...
				r.setStatus(0);
			}catch(DuplicateSSNException e) {
				r.setStatus(-2);
			}catch(Exception e) {
				
			}
			break;
		case Command.DELETECUSTOMER: //deleteCustomer()
			try {				
				db.deleteCustomer(args[0]);//디비 갔다온다...
				r.setStatus(0);
			}catch(RecordNotFoundException e) {
				r.setStatus(-1);
			}catch(Exception e) {
				
			}
			break;
			
		case Command.UPDATECUSTOMER: //updateCustomer()
			try {			
				CustomerRec cr = new CustomerRec(args[0], args[1], args[2]);
				db.updateCustomer(cr);
				r.setStatus(0);
			}catch(RecordNotFoundException e) {
				r.setStatus(-1);
			}catch(Exception e) {
				
			}
			break;
		}//switch
		
		//다시 Protocol로 cmd를 던진다...
		try {
			oos.writeObject(cmd);
		}catch(Exception e) {
			
		}
		}//while
	}//run
}//class

















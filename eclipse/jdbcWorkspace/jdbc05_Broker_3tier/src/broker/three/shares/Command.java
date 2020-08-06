package broker.three.shares;

import java.io.Serializable;//직렬화


public class Command implements Serializable {
	public static final int BUYSHARES = 10;
	public static final int SELLSHARES = 20;
	public static final int GETALLSTOCK = 30;
//	public static final int GETPORTFOLIO = 40;
	public static final int GETALLCUSTOMERS = 50;
	public static final int GETCUSTOMER = 60;
	public static final int ADDCUSTOMER = 70;
	public static final int DELETECUSTOMER = 80;
	public static final int UPDATECUSTOMER = 90;
	
	private int commandValue;
	private String[] args;
//	private ArrayList<E> list; //arraylist는 선언하면 10칸만들어져서 안됨
	private Result results;
	
	public Command(int commandValue) {
		this.commandValue = commandValue;
		results = new Result();
	}

	public void setCommandValue(int commandValue) {
		this.commandValue = commandValue;
	}

	public void setArgs(String[] args) {
		this.args = args;
	}

	public void setResults(Result results) {
		this.results = results;
	}

	public int getCommandValue() {
		return commandValue;
	}

	public String[] getArgs() {
		return args;
	}

	public Result getResults() {
		return results;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

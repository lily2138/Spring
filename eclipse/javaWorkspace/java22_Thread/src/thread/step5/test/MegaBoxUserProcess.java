package thread.step5.test;

import thread.step5.MegaBoxUser;

public class MegaBoxUserProcess {
	public static void main(String[] args) {
		MegaBoxUser user = new MegaBoxUser();
		Thread t1 = new Thread(user, "юс©╣©У");
		Thread t2 = new Thread(user, "х©а╓");
		
		t1.start();
		t2.start();
	}

}

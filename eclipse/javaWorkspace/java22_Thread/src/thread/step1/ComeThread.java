package thread.step1;

public class ComeThread extends Thread {
	public ComeThread(String name) {
		super(name);
	}
	//쓰레드가 작동하는 부분....내부적으로 호출되기 때문에 그대로 써야한다.
	public void run() {
		int i=0;
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

			}
			String tname = Thread.currentThread().getName();
			System.out.println("CurrentThread::"+","+i);
			i++;
			if(i==20)break;
		}
	}

}

package thread.step4.test;
/*
 * 카운팅 작업 - CountThread
 * 숫자입력작업  - InputThread
 * ::
 * 두 쓰레드간의 Communication 은 프로세스의 자원으로 해야한다.
 * 
 */
import javax.swing.JOptionPane;

class CountThread extends Thread{
	private InputThreadTest3 process;
	
	public CountThread(InputThreadTest3 process) {
		this.process = process;
	}
	
	public void run() {
		//2. 일종의 카운팅 작업....
		for(int i=10; i>0; i--) {
			if(process.inputCheck) break;
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
			}
		}//for
		
		if(!process.inputCheck) {
			System.out.println("10초 경과되었습니다... 값입력 시간초과!!");
			System.exit(0);
		}
	}
}

class InputThread extends Thread{
	private InputThreadTest3 process;
	
	public InputThread(InputThreadTest3 process) {
		this.process = process;
	}


	public void run() {
		//1. 데이타 입력작업....
		String input = JOptionPane.showInputDialog("최종로또 번호를 입력하세요");
		System.out.println("입력하신 숫자는 "+ input + " 입니다.");
		
		process.inputCheck = true;
	}
	
}

//process....
public class InputThreadTest3 {
	boolean inputCheck = false;

	public static void main(String[] args) {
		InputThreadTest3 process = new InputThreadTest3();
		
		CountThread countT = new CountThread(process);
		InputThread inputT = new InputThread(process);
		
		countT.start(); //여기서 병렬작업시작
		inputT.start();
	}

}

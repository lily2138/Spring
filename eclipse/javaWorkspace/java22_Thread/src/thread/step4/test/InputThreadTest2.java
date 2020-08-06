package thread.step4.test;

import javax.swing.JOptionPane;
/*
 * step2
 * ::
 * 카운팅 작업은 카운팅 작업대로
 * 팝업창 입력은 팝업창 입력대로
 * 병렬적으로 작업을 진행
 * ::
 * 메인쓰레드
 * 작업쓰레드 -- 카운팅 처리 -- CountingThread(implements Runnable)
 */

class CountingThread implements Runnable{

	@Override
	public void run() {
		//2. 일종의 카운팅 작업....
		for(int i=10; i>0; i--) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
			}
			System.out.println(i);
		}	
	}
}

public class InputThreadTest2 {
	public static void main(String[] args) { 
		CountingThread countT = new CountingThread();
		Thread t = new Thread(countT); //runnable implements 할때만 이작업 한다
		
		t. start(); //여기서 병렬작업시작
		
		//1. 데이타 입력작업....
		String input = JOptionPane.showInputDialog("최종로또 번호를 입력하세요");
		System.out.println("입력하신 숫자는 "+ input + " 입니다.");
		
		
	}

}

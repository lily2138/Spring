package thread.step4.test;

import javax.swing.JOptionPane;
/*
 * 메인쓰레드만 가동되는 로직....
 * 동시작업이 안된다.
 * 로또 번호를 입력바든 작업과
 * 카운팅 작업이 병렬적으로 진행되어야한다.
 * -----------------------------------
 * 10초안에 최종적인 로또 번호가 입력되어져야 한다.
 */
public class InputThreadTest1 {
	public static void main(String[] args) {
		//1. 데이타 입력작업....
		String input = JOptionPane.showInputDialog("최종로또 번호를 입력하세요");
		System.out.println("입력하신 숫자는 "+ input + " 입니다.");
		
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

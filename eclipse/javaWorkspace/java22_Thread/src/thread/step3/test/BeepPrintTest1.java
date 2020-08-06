package thread.step3.test;

import java.awt.Toolkit;

/*
 * 해당코드에서는 별도의 쓰레드를 작성하지 않고 실행....
 * 경고음을 발생시키고 / 동시에 경고음을 콘솔로 프린팅하는 작업
 * 두가지 일을 main 아래에서 처리하도록 할것이다.
 */
public class BeepPrintTest1 {

	public static void main(String[] args) {
		Toolkit tool = Toolkit.getDefaultToolkit();
		//경고음 5번 울리는 작업....
		for(int i=0; i<5; i++) {
			tool.beep();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
		
		//띵띵띵띵띵을 5번 출력하는 작업
		for(int i=0; i<5; i++) {
			System.out.println("띵~~~~");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
		
	}

}

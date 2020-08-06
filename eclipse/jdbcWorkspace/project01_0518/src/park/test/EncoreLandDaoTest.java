package park.test;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import park.dao.EncoreLandDaoImpl;
import park.dao.UpdateThread;
import park.exception.InvalidTransactionException;
import park.exception.RecordNotFoundException;
import park.vo.Attraction;
import park.vo.Customer;
import park.vo.UseList;
public class EncoreLandDaoTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EncoreLandDaoImpl dao = EncoreLandDaoImpl.getInstance();
		Thread ut = new Thread(new UpdateThread());
		Scanner sc = new Scanner(System.in);
		try {
			dao.randAddCustomer(100);
			dao.randUseAttraction(100, 100);
		} catch (SQLException e1) {
		} 
		
		while (true) {
			try {
			System.out.println("\n \n 1.고객 입장 \t2.나의 정보조회\n"
					+ "3.나의 정보 수정\n"
					+ "4.모든 놀이기구 조회\n"
					+ "5.탑승하기\t 6.대기취소\n"
					+ "7.전체 랭킹\t8.연령별 랭킹\t9.성별랭킹\n"
					+ "10.내가탄 놀이기구 조회\t11.놀이기구 정보조회\n"+
					"Thread 13. 놀이기구 동작 14.놀이기구 정지");
			switch (sc.nextInt()) {
			case 1:
				System.out.println("성별");
				String sex = sc.next();
				System.out.println("나이");
				int age = sc.nextInt();
				dao.entranceCustomer(new Customer(0, sex, age));
				break;
			case 2:
				System.out.println("번호");
				int custNo3 = sc.nextInt();
				dao.getMyInfo(custNo3);
				break;
			case 3:
				System.out.println("번호");
				int custNo1 = sc.nextInt();
				System.out.println("성별");
				String sex2 = sc.next();
				System.out.println("나이");
				int age2 = sc.nextInt();
				dao.updateCustomer(new Customer(custNo1, sex2, age2));
				break;
			case 4:
				dao.getAllAttr();
				break;
			case 5:
				System.out.println("손님");
				int custNo = sc.nextInt();
				System.out.println("기구");
				int attrNo = sc.nextInt();
				try {
					dao.useAttraction(custNo, attrNo);
				} catch (InvalidTransactionException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 6:
				System.out.println("고객");
				int custNo2 = sc.nextInt();
				System.out.println("기구");
				int attrNo2 = sc.nextInt();
				try {
					dao.cancelAttr(custNo2, attrNo2);
				} catch (RecordNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 7:
				ArrayList<Attraction> a = dao.totalRankAttr();
/*				for(Attraction attr: a)
					System.out.println(attr);*/
				break;
			case 8:
				System.out.println("0대");
				int n = sc.nextInt();
				System.out.println("100대");
				int m = sc.nextInt();
				ArrayList<Attraction> a1 =dao.ageRankAttr(n, m);
				for(Attraction attr: a1)
					System.out.println(attr);
				break;
			case 9:
				System.out.println("성별");
				String sex3 = sc.next();
				ArrayList<Attraction> a2 = dao.sexRankAttr(sex3);
				for(Attraction attr2: a2)
					System.out.println(attr2);
				break;
			case 10:
				System.out.println("번호");
				int custNo4 = sc.nextInt();
				ArrayList<UseList> u = dao.getMyUseList(custNo4);

				break;
			case 11:
				System.out.println("번호");
				int attrNo4 = sc.nextInt();
				Attraction a3 =  dao.getAttrInfo(attrNo4);
				System.out.println(a3);
				break;
			case 13:
				ut.start();
				break;
			case 14:
				ut.stop();
				break;
			default:
				continue;
			}
			} catch(SQLException e) {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}
}

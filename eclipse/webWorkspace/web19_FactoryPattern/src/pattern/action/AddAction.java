package pattern.action;
/*
 * AddAction ::
 * 컴포넌트
 * 
 * 인터페이스 기반으로 작성된 재사용성이 강한 자바클래스
 */
public class AddAction implements Action{

	@Override
	public void execute() {
		/*
		 * 1. 폼값받아서
		 * 2. DAO 리턴받고
		 * 3. biz 로직호출
		 * 4. 리턴된 값 바인딩
		 * 5. path를 최종적으로 리턴
		 * 
		 */
		
		insert();
	}

	public void insert() {
		//위의 로직들이 수행됐다고 치고....
		System.out.println("INSERT OK!!!");
	}
}

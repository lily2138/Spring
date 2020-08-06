package oop.javadoc;
//
/*
 * 
 */
/**
 * 
 * @author Lily [소스코드 작성자정보]
 * @since JDK 1.8.4
 * @version [소스코드 버전정보]
 * 
 */
public class JavaComment {
	/**
	 * 해당 점수를 받은 수강자의 이름이 입력되는 변수
	 */
	public String name;
	public int age;
	
	/**
	 * 
	 * @param java program Score
	 * @param algo program Score
	 * @return 자바성적과 알고리즘 성적의 합산으로 학생의 최종점수를 반환
	 */
	
	public int scoreSum(int java, int algo) {
		return java+algo;
	}
}

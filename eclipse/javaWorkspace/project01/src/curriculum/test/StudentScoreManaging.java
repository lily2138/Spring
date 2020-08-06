package curriculum.test;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import curriculum.manage.StudentManageImpl;
import curriculum.vo.*;
public class StudentScoreManaging {
	
	//map 출력함수
	public static void printMapStudents(Map<Integer, Student> students) {
		Set<Integer> stdSet = students.keySet();
		Iterator<Integer> it = stdSet.iterator();
		while(it.hasNext()) {
			int key = it.next();
			Student std = students.get(key);
			System.out.println(std.toString());
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println("Start student score managing program...");
		StudentManageImpl scoreMngr = StudentManageImpl.getInstance();
		
		
		Map<Integer, Student> students = null;
		int menuNum, stdId, stdAge, currId, score = 0;
		String stdName = "";
		Student std = null;
		Curriculum cur = null;
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("메뉴를 선택해주세요...");
			System.out.println("1. 학생 등록		2. 학생의 커리큘럼 등록");
			System.out.println("3. 점수 등록		4. 학생 삭제");
			System.out.println("5. 모든 학생 정보 조회	6. 반별 학생 정보 조회");
			System.out.println("7. 전체 수석 조회		8. 반별 수석 조회");
			System.out.println("9. 반별 평균 점수 조회 10.일정 점수 이하 학생 조회");
			System.out.println("11. 시험 점수 수정	12.발표 점수 수정");
			System.out.println("13. 팀 점수 수정		14.퀴즈 점수 수정");
			System.out.println("0. 총 점수를 일괄 계산합니다.");
			
			menuNum = sc.nextInt();
			switch(menuNum) {
			
			case 1:
				System.out.println("학생을 등록합니다.");
				System.out.println("생성할 ID를 입력하세요.");
				stdId = sc.nextInt();
				System.out.println("학생의 이름을 입력하세요.");
				stdName = sc.next();
				System.out.println("학생의 나이를 입력하세요.");
				stdAge = sc.nextInt();
				scoreMngr.addStudent(stdId, stdName, stdAge);
				break;
			case 2:{
				System.out.println("학생의 커리큘럼을 등록합니다.");
				System.out.println("학생의 ID를 입력하세요.");
				stdId = sc.nextInt();
				System.out.println("등록할 과정을 선택하세요. 1. Big Data, 2. AI");
				menuNum = sc.nextInt();
				switch(menuNum) {
				case 1:
					scoreMngr.addSubjectOfStudent(stdId,  new BigData());//issue occur
					break;
				case 2:
					scoreMngr.addSubjectOfStudent(stdId,  new AI());//issue occur
					break;
				}
				break;
			}
			case 3:
				System.out.println("학생의 시험점수를 등록합니다.");
				System.out.println("학생의 ID를 입력하세요.");
				stdId = sc.nextInt();
				cur = scoreMngr.getCurriculum(stdId);
				if(cur instanceof BigData) menuNum = 1;
				else menuNum = 2;
				
				switch(menuNum) {
				case 1:
					System.out.println("시험점수를 입력하세요.");
					score = sc.nextInt();
					System.out.println("발표점수를 입력하세요. ");
					int ptScore = sc.nextInt();
					scoreMngr.registerBigdataScore(stdId, score, ptScore);
					break;
				case 2:
					System.out.println("시험점수를 입력하세요.");
					score = sc.nextInt();
					System.out.println("퀴즈점수를 입력하세요.");
					int quizScore = sc.nextInt();
					System.out.println("팀 점수를 입력하세요.");
					int teamScore = sc.nextInt();
					scoreMngr.registerAIScore(stdId, score, quizScore, teamScore);
					break;
				}
				break;
			case 4:
				System.out.println("학생 정보를 삭제합니다.");
				System.out.println("학생의 ID를 입력하세요.");
				stdId = sc.nextInt();
				scoreMngr.deleteStudent(stdId);
				break;
			case 5:
				System.out.println("모든 학생의 정보를 조회합니다.");
				printMapStudents(scoreMngr.getAllStudent());
				break;
			case 6:
				System.out.println("반별 학생의 정보를 조회합니다.");
				System.out.println("과정 Id를 입력하세요.");
				currId = sc.nextInt();
				printMapStudents(scoreMngr.getStudentOfClass(currId)); //issue occur
				break;
			case 7:
				System.out.println("전체 수석을 조회합니다.");
				std = scoreMngr.getFirstStudent();
				System.out.println(std.toString());
				break;
			case 8:
				System.out.println("반별 수석을 조회합니다.");
				System.out.println("과정 Id를 입력하세요.");
				currId = sc.nextInt();
				std = scoreMngr.getFirstStudent(currId);
				System.out.println(std.toString());
				break;
			case 9:
				System.out.println("반별 평균 점수를 조회합니다.");
				System.out.println("과정 Id를 입력하세요.");
				currId = sc.nextInt();
				System.out.println(scoreMngr.getAvgScoreOfClass(currId));  //issue occur
				break;
			case 10:
				System.out.println("일정 점수 이하 학생들을 조회합니다.");
				System.out.println("점수를 입력하세요.");
				score = sc.nextInt();
				printMapStudents(scoreMngr.findStudentByScore(score)); //issue occur
				break;
			case 11:
				System.out.println("시험점수를 수정합니다.");
				System.out.println("학생의 ID를 입력하세요.");
				stdId = sc.nextInt();
				System.out.println("새로운 점수를 입력하세요.");
				score = sc.nextInt();
				scoreMngr.updateStudentScore(stdId, score);
				break;
			case 12:
				System.out.println("발표점수를 수정합니다.");
				System.out.println("학생의 ID를 입력하세요.");
				stdId = sc.nextInt();
				System.out.println("새로운 점수를 입력하세요.");
				score = sc.nextInt();
				scoreMngr.updatePtScore(stdId, score);
				break;
			case 13:
				System.out.println("팀점수를 수정합니다.");
				System.out.println("학생의 ID를 입력하세요.");
				stdId = sc.nextInt();
				System.out.println("새로운 점수를 입력하세요.");
				score = sc.nextInt();
				scoreMngr.updateTeamProjectScore(stdId, score);
				break;
			case 14:
				System.out.println("퀴즈점수를 수정합니다.");
				System.out.println("학생의 ID를 입력하세요.");
				stdId = sc.nextInt();
				System.out.println("새로운 점수를 입력하세요.");
				score = sc.nextInt();
				scoreMngr.updateQuizScore(stdId, score);
				break;
			case 0:
				System.out.println("학생들의 총점수를 일괄 계산합니다.");
				scoreMngr.StudentTotalScore();
				System.out.println("계산이 끝났습니다.");
				break;
			default :
				System.out.println("프로그램을 종료합니다...");
				System.exit(0);
			}
		}
	}
}
package curriculum.manage;

import java.util.ArrayList;
import java.util.Map;

import curriculum.vo.Curriculum;
import curriculum.vo.Student;

public interface StudentManage {
	void addStudent(int stdid,String name, int age); //학생등록
	void addSubjectOfStudent(int stdid,Curriculum curriculum);
	//void registerScore(int stdid,double testScore);	//시험점수 등록
	
	void registerBigdataScore(int stdid,int testScore,int ptScore); //점수 등록(Big data)
	void registerAIScore(int stdid,int testScore,int quizScore,int teamScore); //점수 등록(AI)
	//void registerTeamProjectScore(int stdid,double teamScore); //팀프로젝트 점수 등록
		
	void StudentTotalScore(/*int stdid*/); //학생별 총점수계산
	
	Map<Integer, Student> getAllStudent(); //모든 학생 정보 조회
	Map<Integer, Student> getStudentOfClass(int classNumber);//반별 학생 정보 조회
	
	Student getFirstStudent(int classNumber); //반별 수석
	Student getFirstStudent(); //전체수석
	
	void deleteStudent(int stdId);//학생 삭제
	
	void updateStudentScore(int stdId, int testScore); //시험점수 수정
	void updatePtScore(int stdid,int ptScore); //발표점수 수정
	void updateTeamProjectScore(int stdid,int teamScore); //팀프로젝트 점수 수정
	void updateQuizScore(int stdid,int quizScore); //퀴즈점수 수정
	
	Map<Integer, Student> findStudentByScore(int score); //몇점이하 학생들조회
	
	int getAvgScoreOfClass(int classNumber);//반별 평균 점수 정보 조회
	
	Curriculum getCurriculum(int stdId);
	
}

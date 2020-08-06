package curriculum.manage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import curriculum.vo.AI;
import curriculum.vo.BigData;
import curriculum.vo.Curriculum;
import curriculum.vo.Student;

public class StudentManageImpl implements StudentManage{
	
	private Map<Integer, Student> studentMap;
	
	private static StudentManageImpl manage = new StudentManageImpl();
	private StudentManageImpl() {
		studentMap = new HashMap<Integer, Student>();
	}
	public static StudentManageImpl getInstance() {
		return manage;
	}

	@Override
	public void addStudent(int stdId,String name, int age) {
		if(studentMap.containsKey(stdId)) {
			System.out.println(name+"님은 이미 등록되어 있습니다");
		}else {
			Student st = new Student(stdId,name,age);
			studentMap.put(stdId, st);
			System.out.println(name+"님이 등록됐습니다");
		}
	}
	@Override
	public void addSubjectOfStudent(int stdId,Curriculum c) {
		if(studentMap.containsKey(stdId)) {
			Student st = studentMap.get(stdId);
			st.setCurriculum(c);
			System.out.println(st.getStudId()+"님의"+c.getCurrName()+"커리큘럼이 등록되었습니다");
		}else {
			System.out.println(stdId+"님은 없습니다");
		}
	}
	@Override
	public void registerBigdataScore(int stdId,int testScore,int ptScore) {
		if(studentMap.containsKey(stdId)) {
			Student st = studentMap.get(stdId);
			Curriculum cur = st.getCurriculum();
			cur.setTestScore(testScore);
			((BigData) cur).setPtScore(ptScore);
			System.out.println(st.getStudId()+"님의 점수가 등록되었습니다.");
		}else {
			System.out.println(stdId+"님은 없습니다");
		}
	}
	@Override
	public void registerAIScore(int stdId,int testScore,int quizScore,int teamScore) {
		if(studentMap.containsKey(stdId)) {
			Student st = studentMap.get(stdId);
			Curriculum cur = st.getCurriculum();
			cur.setTestScore(testScore);
			((AI) cur).setQuizScore(quizScore);
			((AI) cur).setTeamScore(teamScore);
			System.out.println(st.getStudId()+"님의 점수가 등록되었습니다.");
		}else {
			System.out.println(stdId+"님은 없습니다");
		}
	}
	
	@Override
	public void StudentTotalScore() {
		Set<Integer> set=studentMap.keySet();
		for (Integer key:set) {
			Curriculum curr = studentMap.get(key).getCurriculum();
			if(curr instanceof BigData) {
				int total=((BigData)curr).getPtScore()+curr.getTestScore();
				curr.setTotalScore(total);
			}
			else if(curr instanceof AI) {
				int total=((AI)curr).getQuizScore()+((AI)curr).getTeamScore()+curr.getTestScore();
				curr.setTotalScore(total);
			}
		}
	}
	
	
	@Override
	public Map<Integer, Student> getAllStudent() {


		return studentMap;
	}
	
	@Override
	public Map<Integer, Student> getStudentOfClass(int classNumber) {
		Map<Integer, Student> classStudents = new HashMap<Integer, Student>();
		Set<Integer> stdSet = studentMap.keySet();
		Iterator<Integer> it = stdSet.iterator();
		while(it.hasNext()) {
			int key = it.next();
			Student std = studentMap.get(key);
			if(classNumber == 1) {
				if (std.getCurriculum() instanceof BigData) {
					classStudents.put(key,std);
				}
				else continue;
			}
			else if(classNumber == 2) {
				if (std.getCurriculum() instanceof AI) {
					classStudents.put(key,std);
				}
				else continue;
			}
		}
		return classStudents;
	}
	
	@Override
	public Student getFirstStudent(int classNumber) {
		Student firstStudent = null;
		List<Student> list = new ArrayList<>();
		int firstScore = 0;
		
		Set<Integer> stdSet = studentMap.keySet();
		Iterator<Integer> it = stdSet.iterator();
		while(it.hasNext()) {
			int key = it.next();
			Student std = studentMap.get(key);
			if(std.getCurriculum().getCurrId()==classNumber) {
				list.add(std);
			}
		}
		for(Student st : list) {
			if(st.getCurriculum().getTotalScore()>firstScore) {
				firstStudent = st;
				firstScore = st.getCurriculum().getTotalScore();
			}
		}
		
		return firstStudent;
	}
	
	@Override
	public Student getFirstStudent() {
		Student firstStudent = null;
		int bigdataFirstStudent = getFirstStudent(1).getCurriculum().getTotalScore();
		int AIFristStudent = getFirstStudent(2).getCurriculum().getTotalScore();
		if(bigdataFirstStudent > AIFristStudent ){
			firstStudent = getFirstStudent(1);
		}else if(bigdataFirstStudent < AIFristStudent) {
			firstStudent = getFirstStudent(2);
		}else {
			System.out.println(getFirstStudent(1).toString());
			System.out.println(getFirstStudent(2).toString());
		}
		
		return firstStudent;
	}
	
	@Override
	public void deleteStudent(int stdId) {
		if(studentMap.containsKey(stdId)) {
			studentMap.remove(stdId);
		}else {
			System.out.println("존재하지 않는 학번입니다.");
		}
	}
	
	@Override
	public void updateStudentScore(int stdId, int testScore) {
		if(studentMap.containsKey(stdId))
			studentMap.get(stdId).getCurriculum().setTestScore(testScore);
		else
			System.out.println("존재하지 않는 학번입니다.");
	}
	
	@Override
	public void updatePtScore(int stdId,int ptScore) {
		if(studentMap.containsKey(stdId)) {
			Curriculum curr=studentMap.get(stdId).getCurriculum();
			if(curr instanceof BigData) {
				((BigData)curr).setPtScore(ptScore);
				System.out.println("PT점수 수정이 완료되었습니다.");
			}
			else if(curr instanceof AI)
				System.out.println("AI 강의에 PT 점수는 반영되지 않습니다.");
		}else System.out.println("존재하지 않는 학번입니다.");
	}
	
	@Override
	public void updateTeamProjectScore(int stdId,int teamScore) {
		if(studentMap.containsKey(stdId)) {
			Curriculum curr=studentMap.get(stdId).getCurriculum();
			if(curr instanceof AI) {
				((AI)curr).setTeamScore(teamScore);
				System.out.println("팀점수 수정이 완료되었습니다.");
			}
			else if(curr instanceof BigData)
				System.out.println("BigData 강의에 팀과제 점수는 반영되지 않습니다.");
		}else System.out.println("존재하지 않는 학번입니다.");
	}
	@Override
	public void updateQuizScore(int stdId,int quizScore) {
		if(studentMap.containsKey(stdId)) {
			Curriculum curr=studentMap.get(stdId).getCurriculum();
			if(curr instanceof AI) {
				((AI)curr).setQuizScore(quizScore);
				System.out.println("퀴즈점수 수정이 완료되었습니다.");
			}
			else if(curr instanceof BigData)
				System.out.println("BigData 강의에 팀과제 점수는 반영되지 않습니다.");
		}else System.out.println("존재하지 않는 학번입니다.");
	}
	
	@Override
	public Map<Integer, Student> findStudentByScore(int score){
		Map<Integer, Student> findStudents = new HashMap<Integer, Student>();
		Set<Integer> set=studentMap.keySet();
		ArrayList<Student> student=null;
		for (Integer key:set) {
			Student std = studentMap.get(key);
			Curriculum curr =std.getCurriculum();
			if(curr.getTotalScore()<=score)
				findStudents.put(key,std);
			
		}
		return findStudents;
	}

	@Override
	public int getAvgScoreOfClass(int classNumber) {
		ArrayList<Student> students = null;
		Set<Integer> stdSet = studentMap.keySet();
		Iterator<Integer> it = stdSet.iterator();
		Curriculum curr = null;
		int totalScore = 0;
		int studentNumber = 0;
		
		while(it.hasNext()) {
			int key = it.next();
			Student std = studentMap.get(key);
			if(classNumber == 1) {
				if (std.getCurriculum() instanceof BigData) {
					curr = std.getCurriculum();
					totalScore += curr.getTotalScore();
					studentNumber++;
				}
			}
			else if(classNumber == 2) {
				if (std.getCurriculum() instanceof AI) {
					curr = std.getCurriculum();
					totalScore += curr.getTotalScore();
					studentNumber++;
				}
			}
		}
		return totalScore / studentNumber;
	}
	
	@Override
	public Curriculum getCurriculum(int stdId) {
		Student std = studentMap.get(stdId);
		return std.getCurriculum();		
	}
	
}

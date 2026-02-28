package day3Assignment;

public class MidTermExam extends ExamProcess {

	public MidTermExam(String examCode) {
		super(examCode);
	}

	@Override
	void conductExam(Student s) {
		System.out.println("Conducting Mid Term Exam for " +s.studentName);
		
	}

	@Override
	int evaluate(Student s) {
		System.out.println("Evaluating Mid Term Performance");
		return (int)Math.random()*100;
	}
}

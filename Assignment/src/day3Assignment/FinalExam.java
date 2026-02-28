package day3Assignment;

public class FinalExam extends ExamProcess {

	public FinalExam(String examCode) {
		super(examCode);
	}

	@Override
	void conductExam(Student s) {
		System.out.println("Conducting Final Exam for " +s.studentName);
		
	}

	@Override
	int evaluate(Student s) {
		System.out.println("Evaluating Final Exam Performance");
		return (int)Math.random()*100;
	}
	
}

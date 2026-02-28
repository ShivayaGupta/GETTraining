package day3Assignment;

public class LabExam extends ExamProcess {

	public LabExam(String examCode) {
		super(examCode);
	}

	@Override
	void conductExam(Student s) {
		System.out.println("Conducting Lab Practicals for " +s.studentName);
		
	}

	@Override
	int evaluate(Student s) {
		System.out.println("Evaluating Lab Performance");
		return (int)Math.random()*100;
	}
	
	}



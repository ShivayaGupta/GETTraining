package day3Assignment;

public abstract class ExamProcess {
	static final int passMarks = 40;
	final String examCode;
	
	public ExamProcess(String examCode) {
		super();
		this.examCode = examCode;
	}
	
	boolean validateEligibility(Student s) {
		return s.attendancePercent >= UniversityExamRules.minAttendance;
	}
	
	String allocateHallTicket() {
		return UniversityExamRules.generateHallTicket();
	}
	
	abstract void conductExam(Student s);
	abstract int evaluate(Student s);
	
	final void publishResult(Student s, int marks) {
		if(marks >= passMarks) {
			System.out.println(s.studentName+ "PASSED WITH MARKS: " +marks);
		}
		
		else {
			System.out.println(s.studentName + " FAILED WITH MARKS: "+ marks);
		}
	}
	
	final void ExamProcessSteps(Student s) {
		if(!validateEligibility(s)) {
			System.out.println(s.studentName+ " is NOT eligible");
			return;
		}
		String hallTicket = allocateHallTicket();
		System.out.println("Here is the HallTicket :- " +hallTicket);
		conductExam(s);
		int marks = evaluate(s);
		publishResult(s, marks);
	}

}

package day3Assignment;

public class UniversityExamMain {
	public static void main(String[] args) {
		Student s1 = new Student("1", "Shivaya", 91);
		Student s2= new Student("2", "khushboo", 79);
		
		ExamProcess lab = new LabExam("ABC234");
		ExamProcess midTerm = new MidTermExam("ABC34");
		ExamProcess finalExam = new FinalExam("XYZ456");
		
		System.out.println("-------Mid-Term Exams-------");
		midTerm.ExamProcessSteps(s1);
		midTerm.ExamProcessSteps(s2);
		
		System.out.println( "-------Lab Exam-------");
		lab.ExamProcessSteps(s1);
		lab.ExamProcessSteps(s2);
		
		System.out.println("-------Final Exams------");
		finalExam.ExamProcessSteps(s1);
		finalExam.ExamProcessSteps(s2);
	}
}

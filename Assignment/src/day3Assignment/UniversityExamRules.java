package day3Assignment;

public class UniversityExamRules {
	static final String universityCode = "RAMSWAROOP";
	static final int minAttendance = 75;
	
	static int hallTicketCounter = 1000;

	public UniversityExamRules() {
		super();
	}
	
	static String generateHallTicket() {
		hallTicketCounter++;
		return universityCode +((int) (Math.random()*10000))+"-"+hallTicketCounter;
	}
}

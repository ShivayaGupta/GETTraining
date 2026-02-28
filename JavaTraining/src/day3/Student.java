package day3;

public class Student {
	String sname,int id;
    public Student(String sname,int sid) {
    	 super();
    	 this.sname=sname;
    	 this.sid=sid;
    }
    private static CollegeAddress address;
    static class CollegeAddress () {
    	private String city;
    	private String state;
    	private long pincode;
    	public CollegeAddress(String city,String state,long pincode) {
    		super();
    		this.city=city;
    		this.state=state;
    		this.pincode=pincode;
    	}
    	public String toString() {
    		return "CollegeAddress [city="+city+",state="+state+",pincode"+pincode+"]"
    	}
    }
    public static void main(String args[]) {
    	CollegeAddress address= new CollegeAddress("Hyderabad","Telangana",50003);
    	Student s1 = new Student("Swapna",123);
    	setAddress(address);
    	System.out.println(s1);
    	Student s2 = new Student("Amit",133);
    	System.out.println(s2);
    }
}

package day3;

public class Student {
	private String sName;
	private String sId;
	private CollegeAddress address;
	
	public Student() {
		super();
	}
	public Student(String sName, String sId, CollegeAddress address) {
		super();
		this.sName = sName;
		this.sId = sId;
		this.address = address;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsId() {
		return sId;
	}
	public void setsId(String sId) {
		this.sId = sId;
	}
	public CollegeAddress getAddress() {
		return address;
	}
	public void setAddress(CollegeAddress address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Student [sName=" + sName + ", sId=" + sId + ", address=" + address + "]";
	}
	
	static class CollegeAddress{
		
	}
}

package day3;

class Outer {

	private String name;
	
	public void printDetails() {
		System.out.println("Name= "+this.name);
	}
	
	public static class Inner{
		private String name;
		
		public void printInnerDetails() {
			System.out.println("Name= "+this.name);
		}
	}
	
	public static void main(String[] args) {
		Outer out = new Outer();
		out.name = "Shivaya";
		out.printDetails();
		
//		Outer.Inner in = new Outer.Inner();
		Inner in = new Inner();
		in.name = "khushboo";
		in.printInnerDetails();	
		
	}
}
